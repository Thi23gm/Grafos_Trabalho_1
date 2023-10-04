import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import Components.Arquivo;
import Components.Grafo;
import Components.DepthFirstSearchStack;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o Path do Grafo: ");
        String path = sc.nextLine();
        System.out.print("Digite o Numero do Vertice: ");
        int vertice = sc.nextInt();

        long tempoInicial = System.nanoTime();

        Grafo grafo = Arquivo.lerGrafo(path);
        Arquivo.criarArquivosDeSaida();
        FileWriter AA = new FileWriter("Saidas/Arestas/Arestas_Arvore.txt", true);
        FileWriter AC = new FileWriter("Saidas/Arestas/Arestas_Cruzamento.txt", true);
        FileWriter AR = new FileWriter("Saidas/Arestas/Arestas_Retorno.txt", true);
        FileWriter AAV = new FileWriter("Saidas/Arestas/Arestas_Avanco.txt", true);
        if (path == "Tests/graph-test-50000.txt") {
            DepthFirstSearchStack df = new DepthFirstSearchStack(grafo, 19, AA, AC, AR, AAV);
        } else {
            grafo.DFS(vertice, AA, AC, AR, AAV);
        }

        long tempoFinal = System.nanoTime();
        long tempoDeExecucao = tempoFinal - tempoInicial;

        System.out.println("TEMPO DE EXECUÇÃO: " + tempoDeExecucao + " ns");

        sc.close();
    }
}