package Components;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class DepthFirstSearchStack {
    private boolean[] marked; // marked[v] = is there an s-v path?

    // Referencia do livro Algorithms 4th ed. dos autores R. Sedgewick and K. Wayne
    // (Site desponibilizado no canvas).
    // Fiz algumas modificações mas me inspirei no codigo dele.
    public DepthFirstSearchStack(Grafo G, int s, FileWriter AA, FileWriter AC, FileWriter AR, FileWriter AAV)
            throws IOException {
        marked = new boolean[G.size()];

        validateVertex(s);

        // Para ser capaz de iterar sobre cada lista de adjacência, mantendo o controle
        // de
        // qual vértice em cada lista de adjacência precisa ser explorado a seguir
        Iterator<Integer>[] adj = (Iterator<Integer>[]) new Iterator[G.size()];
        for (int v = 0; v < G.size(); v++)
            adj[v] = G.getNeighbors(v).iterator();

        // Busca em profundidade usando uma pilha explícita
        Stack<Integer> stack = new Stack<Integer>();
        marked[s] = true;
        stack.push(s);
        while (!stack.isEmpty()) {
            int v = stack.peek();
            if (adj[v].hasNext()) {
                int w = adj[v].next();
                if (!marked[w]) {
                    marked[w] = true;
                    stack.push(w);
                    AA.write(v + " -> " + w + "\n");
                }
            } else {
                stack.pop();
            }
        }
    }

    public boolean marked(int v) {
        validateVertex(v);
        return marked[v];
    }

    private void validateVertex(int v) {
        int V = marked.length;
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vértice " + v + " não está entre 0 e " + (V - 1));
    }
}
