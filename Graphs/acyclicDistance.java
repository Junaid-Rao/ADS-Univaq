// Computation of SSSP on acyclic graph

import java.util.*;

class Edge {
    int to;
    int weight;

    Edge(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}

public class Main {

    // Topological Sort (Kahn's Algorithm)
    public static List<Integer> topologicalOrdering(int vertices, List<List<Edge>> graph) {

        int[] indegree = new int[vertices];

        for (int u = 0; u < vertices; u++) {
            for (Edge e : graph.get(u)) {
                indegree[e.to]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> order = new ArrayList<>();

        for (int i = 0; i < vertices; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {

            int u = queue.poll();
            order.add(u);

            for (Edge e : graph.get(u)) {
                indegree[e.to]--;

                if (indegree[e.to] == 0) {
                    queue.add(e.to);
                }
            }
        }

        if (order.size() != vertices) {
            throw new RuntimeException("Graph is not acyclic");
        }

        return order;
    }

    // DAG shortest path
    public static int[] acyclicDistances(int vertices, List<List<Edge>> graph, int source) {

        int[] dist = new int[vertices];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        List<Integer> order = topologicalOrdering(vertices, graph);

        for (int u : order) {

            if (dist[u] == Integer.MAX_VALUE) continue;

            for (Edge e : graph.get(u)) {

                int v = e.to;
                int w = e.weight;

                if (dist[v] > dist[u] + w) {
                    dist[v] = dist[u] + w;
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {

        int vertices = 6;

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }

        // Directed weighted DAG
        graph.get(0).add(new Edge(1, 5));
        graph.get(0).add(new Edge(2, 3));
        graph.get(1).add(new Edge(3, 6));
        graph.get(1).add(new Edge(2, 2));
        graph.get(2).add(new Edge(4, 4));
        graph.get(2).add(new Edge(5, 2));
        graph.get(2).add(new Edge(3, 7));
        graph.get(3).add(new Edge(4, -1));
        graph.get(4).add(new Edge(5, -2));

        int source = 0;

        int[] result = acyclicDistances(vertices, graph, source);

        System.out.println("Shortest distances from source " + source + ":");
        System.out.println(Arrays.toString(result));
    }
}
