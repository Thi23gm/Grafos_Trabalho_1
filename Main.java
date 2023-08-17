import java.io.FileNotFoundException;
import java.util.Scanner;
import Components.Arquivo;
import Components.GrafoDeLista;
import Components.GrafoDeVetores;

class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o Path do Grafo: ");
        String path = sc.nextLine();

        System.out.println("GRAFO DE LISTA:");

        long tempoInicial1 = System.nanoTime();

        GrafoDeLista grafoDeLista = Arquivo.lerGrafoDeLista(path);
        grafoDeLista.maiorGrauDeEntrada();
        grafoDeLista.maiorGrauDeSaida();

        long tempoFinal1 = System.nanoTime();
        long tempoDeExecucao1 = tempoFinal1 - tempoInicial1;

        System.out.println("GRAFO DE VETORES:");

        long tempoInicial2 = System.nanoTime();

        GrafoDeVetores grafoDeVetores = Arquivo.lerGrafoDeVetores(path);
        grafoDeVetores.maiorGrauDeEntrada();
        grafoDeVetores.maiorGrauDeSaida();

        long tempoFinal2 = System.nanoTime();
        long tempoDeExecucao2 = tempoFinal2 - tempoInicial2;

        System.out.println("TEMPO DE EXECUÇÃO DA LISTA: " + tempoDeExecucao1 + " ns");
        System.out.println("TEMPO DE EXECUÇÃO DO VETOR: " + tempoDeExecucao2 + " ns");

        sc.close();
    }
}