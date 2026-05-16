import java.util.*;

public class Main {

    public static List<Integer> topologicalOrdering(int vertices, List<List<Integer>> graph) {

        int[] indegree = new int[vertices];

        // Calculate indegree of each vertex
        for (int u = 0; u < vertices; u++) {
            for (int v : graph.get(u)) {
                indegree[v]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> order = new ArrayList<>();

        // Add all vertices with indegree 0
        for (int i = 0; i < vertices; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        // Process the queue
        while (!queue.isEmpty()) {

            int u = queue.poll();
            order.add(u);

            for (int v : graph.get(u)) {

                indegree[v]--;

                if (indegree[v] == 0) {
                    queue.add(v);
                }
            }
        }

        // Check if graph contains a cycle
        if (order.size() != vertices) {
            throw new RuntimeException("Graph is not acyclic");
        }

        return order;
    }

    public static void main(String[] args) {

        int vertices = 6;

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }

        // Add directed edges
        graph.get(5).add(2);
        graph.get(5).add(0);
        graph.get(4).add(0);
        graph.get(4).add(1);
        graph.get(2).add(3);
        graph.get(3).add(1);

        List<Integer> result = topologicalOrdering(vertices, graph);

        System.out.println("Topological Order:");
        System.out.println(result);
    }
}
