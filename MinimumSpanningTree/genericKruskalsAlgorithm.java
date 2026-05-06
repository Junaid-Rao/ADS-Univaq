import java.util.*;

class Edge {
    int u, v, weight;

    Edge(int u, int v, int weight) {
        this.u = u;
        this.v = v;
        this.weight = weight;
    }
}

public class KruskalSimple {

    static int V; // number of vertices

    // DFS to check if there's already a path between u and v
    static boolean isConnected(List<List<Integer>> tree, int u, int v, boolean[] visited) {
        if (u == v) return true;

        visited[u] = true;

        for (int neighbor : tree.get(u)) {
            if (!visited[neighbor]) {
                if (isConnected(tree, neighbor, v, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void kruskal(List<Edge> edges, int vertices) {
        V = vertices;

        // Step 1: Sort edges
        edges.sort(Comparator.comparingInt(e -> e.weight));

        // Step 2: Initialize empty tree (adj list)
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            tree.add(new ArrayList<>());
        }

        int totalCost = 0;

        // Step 3: Process edges
        for (Edge edge : edges) {
            int u = edge.u;
            int v = edge.v;

            boolean[] visited = new boolean[V];

            // Step 4: Check if u and v are already connected
            if (!isConnected(tree, u, v, visited)) {
                // Add edge to MST
                tree.get(u).add(v);
                tree.get(v).add(u);

                totalCost += edge.weight;

                System.out.println(u + " - " + v + " : " + edge.weight);
            }
        }

        System.out.println("Total Cost: " + totalCost);
    }

    public static void main(String[] args) {
        int vertices = 5;

        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 2));
        edges.add(new Edge(0, 3, 6));
        edges.add(new Edge(1, 2, 3));
        edges.add(new Edge(1, 3, 8));
        edges.add(new Edge(1, 4, 5));
        edges.add(new Edge(2, 4, 7));

        kruskal(edges, vertices);
    }
}
