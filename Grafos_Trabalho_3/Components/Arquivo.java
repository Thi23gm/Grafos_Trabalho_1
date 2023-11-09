package Components;

import java.io.*;

public class Arquivo {
    Arquivo() {
    }

    public static Grafo lerGrafo(String path) throws FileNotFoundException {
        int[] values = new int[2];
        try (BufferedReader bf = new BufferedReader(new FileReader(path))) {
            System.out.println("\nGrafo do aquivo " + path + " aberto com sucesso!\n");
            String line = bf.readLine();
            if (line != null) {
                String[] parts = line.trim().split("\\s+");

                if (parts.length >= 2) {
                    values[0] = Integer.parseInt(parts[0]); // Numero de Vertices
                    values[1] = Integer.parseInt(parts[1]); // Numero de Arestas
                    Grafo grafo = new Grafo(values[0]);

                    for (int i = 0; i < values[1]; i++) {
                        int[] arr = new int[2];
                        line = bf.readLine();
                        if (line != null) {
                            String[] aresta = line.trim().split("\\s+");

                            if (aresta.length >= 2) {
                                arr[0] = Integer.parseInt(aresta[0]); // Predecessor
                                arr[1] = Integer.parseInt(aresta[1]); // Sucessor
                                grafo.addAresta(arr[0], arr[1]);
                            }
                        }
                    }
                    bf.close();
                    return grafo;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
