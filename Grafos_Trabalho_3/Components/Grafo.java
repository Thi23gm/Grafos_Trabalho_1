package Components;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

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

    public void addAresta(int from, int to) {
        if (from >= 0 && from < numVertices && to >= 0 && to < numVertices) {
            adjList.get(from).add(to);
        }
    }

    public List<Integer> getVisinhos(int vertex) {
        List<Integer> list = adjList.get(vertex);
        Collections.sort(list);
        return list;
    }

    public int size() {
        return numVertices;
    }

    public List<Integer> BFS(int startVertex) {
        List<Integer> resultadoBFS = new ArrayList<>();
        boolean[] visitados = new boolean[numVertices];
        Queue<Integer> fila = new LinkedList<>();

        visitados[startVertex] = true;
        fila.add(startVertex);

        while (!fila.isEmpty()) {
            int currentVertex = fila.poll();
            resultadoBFS.add(currentVertex);

            List<Integer> vizinhos = adjList.get(currentVertex);
            for (int vizinho : vizinhos) {
                if (!visitados[vizinho]) {
                    visitados[vizinho] = true;
                    fila.add(vizinho);
                }
            }
        }

        return resultadoBFS;
    }

    public List<List<Integer>> encontrarCaminhos(int VI, int VD) throws IOException {
        List<List<Integer>> caminhosEncontrados = new ArrayList<>();
        Queue<List<Integer>> fila = new LinkedList<>();
        List<Integer> caminhoInicial = new ArrayList<>();
        caminhoInicial.add(VI);
        fila.add(caminhoInicial);

        while (!fila.isEmpty()) {
            List<Integer> caminhoAtual = fila.poll();
            int verticeAtual = caminhoAtual.get(caminhoAtual.size() - 1);

            if (verticeAtual == VD) {
                caminhosEncontrados.add(new ArrayList<>(caminhoAtual));
            } else {
                List<Integer> vizinhosAtuais = getVisinhos(verticeAtual);
                for (int vizinho : vizinhosAtuais) {
                    if (!caminhoAtual.contains(vizinho)) {
                        List<Integer> novoCaminho = new ArrayList<>(caminhoAtual);
                        novoCaminho.add(vizinho);
                        fila.add(novoCaminho);
                    }
                }
            }
        }

        return caminhosEncontrados;
    }

}
