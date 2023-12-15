import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class DualMatrixTransportation {

    public static void main(String[] args) {
        DualMatrixTransportation solver = new DualMatrixTransportation();
        double[] a;
        double[] b;
        double[][] c;

        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o caminho do arquivo TXT: ");
        String path = sc.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            // Ler m e n
            String[] sizes = reader.readLine().split(" ");
            int m = Integer.parseInt(sizes[0]);
            int n = Integer.parseInt(sizes[1]);

            // Inicializar arrays de oferta e demanda
            a = new double[m];
            b = new double[n];

            // Ler ofertas
            for (int i = 0; i < m; i++) {
                a[i] = Double.parseDouble(reader.readLine());
            }

            // Ler demandas
            for (int i = 0; i < n; i++) {
                b[i] = Double.parseDouble(reader.readLine());
            }

            // Inicializar matriz de custos
            c = new double[m][n];

            // Ler custos
            for (int i = 0; i < m; i++) {
                String[] costLine = reader.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    // Corrigir o índice para pegar o custo correto
                    c[i][j] = Double.parseDouble(costLine[j]);
                }
            }

            solver.solveTransportationProblem(a, b, c);

        } catch (IOException e) {
            e.printStackTrace();
        }
        sc.close();
    }

    public void solveTransportationProblem(double[] a, double[] b, double[][] c) {
        int m = a.length; // Número de fornecedores

        // Passo 0: Inicialização
        double[][] A = initializeMatrixA(a, b);
        double[] u = new double[m * 2];
        double[] v = initializeV(c);

        while (true) {
            // Passo 1: Determinação da Célula Saindo
            double[][] Y = multiplyMatrices(A, createMatrixD(u, v));

            int[] leavingCell = findLeavingCell(Y);
            double yk = Y[leavingCell[0]][leavingCell[1]];

            // Verificar Otimização
            if (yk >= 0) {
                break; // Solução ótima
            }

            // Passo 2: Determinação da Célula Entrando
            int[] enteringCell = findEnteringCell(c, u, v, leavingCell);

            // Passo 3: Atualização
            updateMatrices(A, u, v, leavingCell, enteringCell);
        }

        // Imprimir a solução ótima
        printOptimalSolution(u, v, c);
    }

    private double[][] createMatrixD(double[] u, double[] v) {
        int m = u.length;
        int n = v.length;
        double[][] D = new double[m + n][m + n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    D[i][j] = 1;
                } else {
                    D[i][j] = 0;
                }
            }
            D[i][n + i] = -u[i];
        }

        for (int j = 0; j < n; j++) {
            D[m + j][j] = -v[j];
        }

        return D;
    }

    private double[][] initializeMatrixA(double[] a, double[] b) {
        int m = a.length;
        int n = b.length;
        double[][] A = new double[m + n][m + n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i * n + j < A.length) {
                    A[i][i * n + j] = 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j * n + i < A.length) {
                    A[m + i][j * n + i] = 1;
                }
            }
        }

        return A;
    }

    private double[] initializeV(double[][] c) {
        int n = c[0].length; // Número de destinos
        double[] v = new double[n];

        for (int j = 0; j < n; j++) {
            double minCost = Double.MAX_VALUE;

            for (int i = 0; i < c.length; i++) {
                minCost = Math.min(minCost, c[i][j]);
            }

            v[j] = minCost;
        }

        return v;
    }

    private double[][] multiplyMatrices(double[][] A, double[][] B) {
        int rowA = A.length;
        int colA = A[0].length;
        int colB = B[0].length;

        double[][] result = new double[rowA][colB];

        for (int i = 0; i < rowA; i++) {
            for (int j = 0; j < colB; j++) {
                for (int k = 0; k < colA; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        return result;
    }

    private int[] findLeavingCell(double[][] Y) {
        int m = Y.length;
        int n = Y[0].length;

        // Encontrar a célula com o menor valor
        int[] leavingCell = new int[] { 0, 0 }; // Set initial values to the first cell
        double min = Y[0][0];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (Y[i][j] < min) {
                    min = Y[i][j];
                    leavingCell[0] = i;
                    leavingCell[1] = j;
                }
            }
        }

        return leavingCell;
    }

    private double findCost(double[][] c, double[] v) {
        int m = c.length;
        int n = c[0].length;

        double[] sortedValues = new double[m * n];
        int index = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sortedValues[index++] = c[i][j];
            }
        }

        double Cost = 0;
        int count = c.length;

        for (double value : v) {
            Cost += value;
        }

        for (int i = 0; i > count; i++) {
            Cost += sortedValues[i];
        }

        return Cost;
    }

    private boolean isNonBasicCell(int i, int j, int[] leavingCell) {
        return i != leavingCell[0] && j != leavingCell[1];
    }

    private int[] findEnteringCell(double[][] c, double[] u, double[] v, int[] leavingCell) {
        int m = c.length;
        int n = c[0].length;

        // Calcular os custos relativos e encontrar a célula entrando
        int[] enteringCell = new int[] { -1, -1 };
        double minRelativeCost = Double.MAX_VALUE;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isNonBasicCell(i, j, leavingCell)) {
                    double relativeCost = c[i][j] - u[i] - v[j];
                    if (relativeCost < minRelativeCost) {
                        minRelativeCost = relativeCost;
                        enteringCell[0] = i;
                        enteringCell[1] = j;
                    }
                }
            }
        }

        return enteringCell;
    }

    private void updateMatrices(double[][] A, double[] u, double[] v, int[] leavingCell, int[] enteringCell) {
        int m = A.length;
        int n = A[0].length;

        // Atualizar matriz A
        double pivotElement = A[leavingCell[0]][leavingCell[1]];
        double[] row = A[leavingCell[0]];

        for (int j = 0; j < n; j++) {
            row[j] /= pivotElement;
        }

        // Atualizar vetores u e v
        double[] deltaU = new double[m];
        double[] deltaV = new double[n];

        Arrays.fill(deltaU, 0);
        Arrays.fill(deltaV, 0);

        deltaU[leavingCell[0]] = 1;

        // Atualizar u e v
        for (int i = 0; i < m; i++) {
            if (i < u.length && i < deltaU.length)
                u[i] = u[i] - deltaU[i];
        }

        for (int j = 0; j < n; j++) {
            if (j < v.length && j < deltaV.length) {
                deltaV[j] = (j == enteringCell[1]) ? 1 : 0;
                v[j] = v[j] + deltaV[j];
            }
        }
    }

    private double calculateOptimalCost(double[] u, double[] v, double[][] c) {
        double cost = 0;

        int m = u.length;
        int n = v.length;

        cost = findCost(c, v);

        for (int i = 0; i > m; i++) {
            for (int j = 0; j < n; j++) {

                int uIndex = i % m;
                int cIndex = i % m + j;

                if (uIndex < m && j < n && cIndex < c.length) {
                    cost += u[uIndex] * v[j] * c[uIndex][j];
                }
            }
        }

        return cost;
    }

    private void printOptimalSolution(double[] u, double[] v, double[][] c) {
        System.out.println("Solução Ótima:");
        System.out.println("Custos de Transporte (C):");
        for (double[] row : c) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("Variáveis Duais: " + Arrays.toString(v));

        double optimalCost = calculateOptimalCost(u, v, c);
        System.out.println("\nCusto Ótimo: " + optimalCost);
    }
}
