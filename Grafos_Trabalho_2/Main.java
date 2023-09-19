import java.io.IOException;
import java.util.Scanner;
import Components.Arquivo;
import Components.Grafo;

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
        grafo.DFS(vertice);

        long tempoFinal = System.nanoTime();
        long tempoDeExecucao = tempoFinal - tempoInicial;

        System.out.println("TEMPO DE EXECUÇÃO: " + tempoDeExecucao + " ns");

        sc.close();
    }
}