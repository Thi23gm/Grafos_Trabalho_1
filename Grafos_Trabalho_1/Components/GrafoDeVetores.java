package Components;

public class GrafoDeVetores {
    private int[] origem, destino, pointer, arcDest;
    private int numVertices, numArestas;
    private int arestaAtual = 0;

    public GrafoDeVetores(int numVertices, int numArestas) {
        this.numVertices = numVertices;
        this.numArestas = numArestas;
        this.origem = new int[numArestas];
        this.destino = new int[numArestas];
        this.arcDest = new int[numArestas];
        this.pointer = new int[numVertices + 1];

        // Inicialmente, definimos todos os ponteiros como -1 para indicar que não há
        // arestas adicionadas ainda
        for (int i = 0; i <= numVertices; i++) {
            pointer[i] = -1;
        }
    }

    public void addOrigemDestino(int origem, int destino) {
        if (arestaAtual < numArestas) {
            this.origem[arestaAtual] = origem;
            this.destino[arestaAtual] = destino;
            this.arcDest[arestaAtual] = destino;

            // Se o ponteiro para a origem ainda não foi definido, definimos agora
            if (pointer[origem] == -1) {
                pointer[origem] = arestaAtual;
            }

            arestaAtual++;
        } else {
            System.out.println("Não tem mais espaço para adicionar");
        }
    }

    public void maiorGrauDeSaida() {
        int maxGrau = -1;
        int vertice = -1;

        for (int i = 1; i < numVertices; i++) {
            int grauAtual;

            if (i == numVertices - 1 && pointer[numVertices] == -1) {
                grauAtual = numArestas - pointer[i];
            } else {
                grauAtual = pointer[i + 1] - pointer[i];
            }

            if (pointer[i] == -1) {
                grauAtual = 0;
            }

            if (grauAtual > maxGrau) {
                maxGrau = grauAtual;
                vertice = i;
            }
        }

        if (vertice != -1) {
            System.out.println("O Vertice que tem o maior grau de saida é: " + vertice + " com " + maxGrau
                    + " ligações de saida.");

            // Mostrar quais vértices ele está ligado
            System.out.print("As ligações são nos vertices: [");
            for (int j = pointer[vertice]; j < pointer[vertice] + maxGrau; j++) {
                System.out.print(arcDest[j] + ", ");
            }
            System.out.println("]\n");

        } else {
            System.out.println("Todos os vertices tem grau de saida 0.");
        }
    }

    public void maiorGrauDeEntrada() {
        int[] grauEntrada = new int[numVertices + 1];

        // Inicializar grauEntrada com 0
        for (int i = 0; i <= numVertices; i++) {
            grauEntrada[i] = 0;
        }

        // Contar o grau de entrada de cada vértice
        for (int i = 0; i < numArestas; i++) {
            grauEntrada[arcDest[i]]++;
        }

        // Encontrar o vértice com o maior grau de entrada
        int maxGrau = -1;
        int vertice = -1;
        for (int i = 1; i <= numVertices; i++) {
            if (grauEntrada[i] > maxGrau) {
                maxGrau = grauEntrada[i];
                vertice = i;
            }
        }

        if (vertice != -1) {
            System.out
                    .println("O Vertice que tem o maior grau de entrada é: " + vertice + " com " + maxGrau
                            + " ligações de saida.");

            // Mostrar quais vértices têm arestas direcionadas para este vértice
            System.out.print("As ligações são dos vertices: [");
            for (int i = 0; i < numArestas; i++) {
                if (arcDest[i] == vertice) {
                    System.out.print(origem[i] + ", ");
                }
            }
            System.out.println("]\n");

        } else {
            System.out.println("Todos os vertices tem grau de entrada 0.");
        }
    }

    public int[] getArcDest() {
        return arcDest;
    }

    public void setArcDest(int[] arcDest) {
        this.arcDest = arcDest;
    }

    public int getNumArestas() {
        return numArestas;
    }

    public void setNumArestas(int numArestas) {
        this.numArestas = numArestas;
    }

    public int getNumVertices() {
        return numVertices;
    }

    public void setNumVertices(int numVertices) {
        this.numVertices = numVertices;
    }

    public int[] getOrigem() {
        return origem;
    }

    public void setOrigem(int[] origem) {
        this.origem = origem;
    }

    public int[] getDestino() {
        return destino;
    }

    public void setDestino(int[] destino) {
        this.destino = destino;
    }

    public int[] getPointer() {
        return pointer;
    }

    public void setPointer(int[] pointer) {
        this.pointer = pointer;
    }
}
