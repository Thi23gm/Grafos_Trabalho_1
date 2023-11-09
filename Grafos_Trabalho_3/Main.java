import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import Components.Arquivo;
import Components.Grafo;

class Main {
    public static List<Integer> encontrarMenorLista(List<List<Integer>> caminhos) {
        if (caminhos == null || caminhos.isEmpty()) {
            return null; // Retorna null se a lista estiver vazia
        }

        List<Integer> menorLista = caminhos.get(0);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("saida.txt"))) {
            writer.write("Todas os possiveis caminhos: ");
            writer.newLine();
            for (List<Integer> lista : caminhos) {
                writer.write(lista.toString());
                writer.newLine();
                if (lista.size() < menorLista.size()) {
                    menorLista = lista;
                }
            }
        } catch (IOException e) {
            System.err.println("Ocorreu um erro ao escrever os caminhos no arquivo: " + e.getMessage());
        }
        return menorLista;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o Caminho do Grafo: ");
        String path = sc.nextLine();
        Grafo g = Arquivo.lerGrafo(path);
        System.out.println("Digite o Vertice Inicial: ");
        int VI = sc.nextInt();
        System.out.println("Digite o Vertice de Destino: ");
        int VD = sc.nextInt();
        List<List<Integer>> caminhos = g.encontrarCaminhos(VI, VD);
        System.out.println("Caminhos entre " + VI + " e " + VD + ":");
        System.out.println("Melhor caminho: " + encontrarMenorLista(caminhos));
        System.out.println("Quantidade de caminhos diferentes disjuntos: " + caminhos.size());
        sc.close();
    }
}