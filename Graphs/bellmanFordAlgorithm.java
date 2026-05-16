import java.util.*;

// Edge class
class Edge {
    int source;
    int destination;
    int weight;

    Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
}

public class Main {

    // Bellman-Ford Algorithm
    public static boolean algorithmBellmanFord(int vertices, List<Edge> edges, int source) {

        int[] distance = new int[vertices];

        // Step 1: Initialize distances
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;

        // Step 2: Relax all edges n-1 times
        for (int i = 1; i < vertices; i++) {

            for (Edge edge : edges) {

                int u = edge.source;
                int v = edge.destination;
                int w = edge.weight;

                if (distance[u] != Integer.MAX_VALUE &&
                    distance[v] > distance[u] + w) {

                    distance[v] = distance[u] + w;
                }
            }
        }

        // Step 3: Check for negative weight cycles
        for (Edge edge : edges) {

            int u = edge.source;
            int v = edge.destination;
            int w = edge.weight;

            if (distance[u] != Integer.MAX_VALUE &&
                distance[v] > distance[u] + w) {

                return false; // Negative cycle exists
            }
        }

        // Print shortest distances
        System.out.println("Vertex \t Distance from Source");
        for (int i = 0; i < vertices; i++) {
            System.out.println(i + "\t\t" + distance[i]);
        }

        return true;
    }

    public static void main(String[] args) {

        int vertices = 5;
        List<Edge> edges = new ArrayList<>();

        // Add edges: (source, destination, weight)
        edges.add(new Edge(0, 1, 6));
        edges.add(new Edge(0, 2, 7));
        edges.add(new Edge(1, 2, 8));
        edges.add(new Edge(1, 3, 5));
        edges.add(new Edge(1, 4, -4));
        edges.add(new Edge(2, 3, -3));
        edges.add(new Edge(2, 4, 9));
        edges.add(new Edge(3, 1, -2));
        edges.add(new Edge(4, 0, 2));
        edges.add(new Edge(4, 3, 7));

        int source = 0;

        boolean result = algorithmBellmanFord(vertices, edges, source);

        if (!result) {
            System.out.println("Graph contains a negative weight cycle.");
        }
    }
}
