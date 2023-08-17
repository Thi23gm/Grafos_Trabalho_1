package Components;

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class GrafoDeLista {
    private ArrayList<LinkedList<Integer>> lista;
    private int numVertices;

    public GrafoDeLista(int numVertices) {
        this.numVertices = numVertices;
        lista = new ArrayList<>(numVertices);
        for (int i = 0; i < numVertices; i++) {
            lista.add(new LinkedList<>());
        }
    }

    public void add(int predecessor, int sucessor) {
        lista.get(predecessor - 1).add(sucessor);
    }

    public void maiorGrauDeSaida() {
        int resp = 0;

        for (int i = 0; i < this.numVertices; i++) {
            if (this.lista.get(resp).size() < this.lista.get(i).size()) {
                resp = i;
            }
        }

        System.out.println("O Vértice que tem o maior grau de saída do grafo é: " + (resp + 1)
                + " com " + this.lista.get(resp).size() + " ligações de saida."
                + "\nAs ligações são nos vértices: " + this.lista.get(resp) + "\n");
    }

    public void maiorGrauDeEntrada() {
        int[] grausDeEntrada = new int[numVertices];

        for (int i = 0; i < numVertices; i++) {
            grausDeEntrada[i] = 0;
        }

        // Contando as ocorrências de cada vértice nas listas de adjacência
        for (int i = 0; i < numVertices; i++) {
            LinkedList<Integer> adjacencia = lista.get(i);
            for (Integer vertice : adjacencia) {
                grausDeEntrada[vertice - 1]++;
            }
        }

        int resp = 0;
        for (int i = 0; i < numVertices; i++) {
            if (grausDeEntrada[resp] < grausDeEntrada[i]) {
                resp = i;
            }
        }

        // Encontrando os vértices que têm arestas para 'resp'
        List<Integer> verticesOrigem = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            if (lista.get(i).contains(resp + 1)) {
                verticesOrigem.add(i + 1);
            }
        }

        System.out.println("O Vértice que tem o maior grau de entrada do grafo é: " + (resp + 1)
                + " com " + grausDeEntrada[resp] + " ligações de entrada."
                + "\nAs ligações são dos vértices: " + verticesOrigem + "\n");
    }

    public int getNumVertices() {
        return this.numVertices;
    }

    public void getNumVertices(int numVertices) {
        this.numVertices = numVertices;
    }

    public void setNumVertices(int numVertices) {
        this.numVertices = numVertices;
    }

    public ArrayList<LinkedList<Integer>> getLista() {
        return lista;
    }
}
