package Components;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Grafo {
    private ArrayList<LinkedList<Integer>> lista;
    private int numVertices;
    private FileWriter AA;
    private FileWriter AR;
    private FileWriter AC;
    private FileWriter AAV;

    public Grafo(int numVertices) {
        this.numVertices = numVertices;
        lista = new ArrayList<>(numVertices);
        for (int i = 0; i < numVertices; i++) {
            lista.add(new LinkedList<>());
        }
    }

    public void add(int predecessor, int sucessor) {
        lista.get(predecessor - 1).add(sucessor);
    }

    public void DFS(int verticeEscolhido) {
        Arquivo.criarArquivosDeSaida();
        boolean[] visitado = new boolean[numVertices];
        int[] tempoDescoberta = new int[numVertices];
        int[] tempoFinalizacao = new int[numVertices];
        int tempo = 0;

        try {
            AA = new FileWriter("Saidas/Arestas/Arestas_Arvore.txt", true);
            AR = new FileWriter("Saidas/Arestas/Arestas_Retorno.txt", true);
            AC = new FileWriter("Saidas/Arestas/Arestas_Cruzamento.txt", true);
            AAV = new FileWriter("Saidas/Arestas/Arestas_Avanco.txt", true);

            for (int vertice = 1; vertice <= numVertices; vertice++) {
                if (!visitado[vertice - 1]) {
                    DFSRecursivo(vertice, verticeEscolhido, visitado, tempoDescoberta, tempoFinalizacao, tempo);
                }
            }

            AA.close();
            AR.close();
            AC.close();
            AAV.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void DFSRecursivo(int vertice, int verticeEscolhido, boolean[] visitado, int[] tempoDescoberta,
            int[] tempoFinalizacao, int tempo) {
        visitado[vertice - 1] = true;
        tempo++;
        tempoDescoberta[vertice - 1] = tempo;

        LinkedList<Integer> vizinhos = lista.get(vertice - 1);
        Collections.sort(vizinhos);

        for (int vizinho : vizinhos) {
            if (!visitado[vizinho - 1]) {
                // Aresta de Árvore
                try {
                    AA.write(vertice + " -> " + vizinho + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                DFSRecursivo(vizinho, verticeEscolhido, visitado, tempoDescoberta, tempoFinalizacao, tempo);
            } else if (tempoDescoberta[vizinho - 1] > tempoDescoberta[vertice - 1]) {
                // Aresta de Avanço
                try {
                    if (vertice == verticeEscolhido) {
                        AAV.write(vertice + " -> " + vizinho + "\n");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (tempoFinalizacao[vizinho - 1] == 0) {
                // Aresta de Retorno
                try {
                    if (vertice == verticeEscolhido) {
                        AR.write(vertice + " -> " + vizinho + "\n");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                // Aresta de Cruzamento
                try {
                    if (vertice == verticeEscolhido) {
                        AC.write(vertice + " -> " + vizinho + "\n");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        tempo++;
        tempoFinalizacao[vertice - 1] = tempo;
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
