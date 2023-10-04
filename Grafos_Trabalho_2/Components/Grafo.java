package Components;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Grafo {
    private final Map<Integer, List<Integer>> adjList;
    private int numVertices; // Adicione este campo

    public Grafo(int numVertices) {
        this.numVertices = numVertices;
        adjList = new HashMap<>();
        for (int i = 0; i < numVertices; i++) {
            adjList.put(i, new ArrayList<>());
        }
    }

    public void addEdge(int from, int to) {
        if (from >= 0 && from < numVertices && to >= 0 && to < numVertices) {
            adjList.get(from).add(to);
        } else {
            // Lide com arestas inválidas de alguma forma, se necessário
        }
    }

    public List<Integer> getNeighbors(int vertex) {
        List<Integer> list = adjList.get(vertex);
        Collections.sort(list);
        return list;
    }

    public int size() {
        return numVertices;
    }

    public void DFS(int verticeEscolhido, FileWriter AA, FileWriter AC, FileWriter AR, FileWriter AAV)
            throws IOException {
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
                    DFSRecursivo(vertice, verticeEscolhido, visitado, tempoDescoberta, tempoFinalizacao, tempo, AA, AC,
                            AR, AAV);
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
            int[] tempoFinalizacao, int tempo, FileWriter AA, FileWriter AC, FileWriter AR, FileWriter AAV)
            throws IOException {
        visitado[vertice - 1] = true;
        tempo++;
        tempoDescoberta[vertice - 1] = tempo;

        List<Integer> vizinhos = adjList.get(vertice - 1);
        Collections.sort(vizinhos);

        for (int vizinho : vizinhos) {
            if (!visitado[vizinho - 1]) {
                // Aresta de Árvore
                AA.write(vertice + " -> " + vizinho + "\n");
                DFSRecursivo(vizinho, verticeEscolhido, visitado, tempoDescoberta, tempoFinalizacao, tempo, AA, AC, AR,
                        AAV);
            } else if (tempoDescoberta[vizinho - 1] > tempoDescoberta[vertice - 1]) {
                // Aresta de Avanço
                if (vertice == verticeEscolhido) {
                    AAV.write(vertice + " -> " + vizinho + "\n");
                }
            } else if (tempoFinalizacao[vizinho - 1] == 0) {
                // Aresta de Retorno
                if (vertice == verticeEscolhido) {
                    AR.write(vertice + " -> " + vizinho + "\n");
                }
            } else {
                // Aresta de Cruzamento
                if (vertice == verticeEscolhido) {
                    AC.write(vertice + " -> " + vizinho + "\n");
                }
            }
        }

        tempo++;
        tempoFinalizacao[vertice - 1] = tempo;
    }
}
