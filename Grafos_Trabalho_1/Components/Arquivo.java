package Components;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Arquivo {
    private String path;

    Arquivo() {
    }

    public static GrafoDeLista lerGrafoDeLista(String path) throws FileNotFoundException {
        int[] values = new int[2];
        try (BufferedReader bf = new BufferedReader(new FileReader(path))) {
            System.out.println("Grafo do aquivo " + path + " aberto com sucesso!\n");
            String line = bf.readLine();
            if (line != null) {
                String[] parts = line.trim().split("\\s+");

                if (parts.length >= 2) {
                    values[0] = Integer.parseInt(parts[0]); // Numero de Vertices
                    values[1] = Integer.parseInt(parts[1]); // Numero de Arestas
                    GrafoDeLista grafo = new GrafoDeLista(values[0]);

                    for (int i = 0; i < values[1]; i++) {
                        int[] arr = new int[2];
                        line = bf.readLine();
                        if (line != null) {
                            String[] aresta = line.trim().split("\\s+");

                            if (aresta.length >= 2) {
                                arr[0] = Integer.parseInt(aresta[0]); // Predecessor
                                arr[1] = Integer.parseInt(aresta[1]); // Sucessor
                                grafo.add(arr[0], arr[1]);
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

    public static GrafoDeVetores lerGrafoDeVetores(String path) throws FileNotFoundException {
        int[] values = new int[2];
        try (BufferedReader bf = new BufferedReader(new FileReader(path))) {
            String line = bf.readLine();
            if (line != null) {
                String[] parts = line.trim().split("\\s+");

                if (parts.length >= 2) {
                    values[0] = Integer.parseInt(parts[0]); // Numero de Vertices
                    values[1] = Integer.parseInt(parts[1]); // Numero de Arestas
                    GrafoDeVetores grafo = new GrafoDeVetores(values[0], values[1]);

                    for (int i = 0; i < values[1]; i++) {
                        int[] arr = new int[2];
                        line = bf.readLine();
                        if (line != null) {
                            String[] aresta = line.trim().split("\\s+");

                            if (aresta.length >= 2) {
                                arr[0] = Integer.parseInt(aresta[0]); // Predecessor
                                arr[1] = Integer.parseInt(aresta[1]); // Sucessor
                                grafo.addOrigemDestino(arr[0], arr[1]);
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

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
