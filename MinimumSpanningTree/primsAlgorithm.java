import java.util.*;

class Edge {
    int to;
    int weight;

    Edge(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}

class Node {
    int vertex;
    int key;

    Node(int vertex, int key) {
        this.vertex = vertex;
        this.key = key;
    }
}

public class PrimsAlgorithm {

    public static void primMST(List<List<Edge>> graph, int start) {
        int V = graph.size();

        int[] key = new int[V];          // d(v)
        int[] parent = new int[V];       // MST tree
        boolean[] inMST = new boolean[V];

        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.key));

        key[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int u = current.vertex;

            // Skip if already included (handles stale entries)
            if (inMST[u]) continue;

            inMST[u] = true;

            for (Edge edge : graph.get(u)) {
                int v = edge.to;
                int weight = edge.weight;

                if (!inMST[v] && weight < key[v]) {
                    key[v] = weight;
                    parent[v] = u;
                    pq.offer(new Node(v, key[v])); // instead of decreaseKey
                }
            }
        }

        // Print MST
        System.out.println("Edge \tWeight");
        for (int i = 0; i < V; i++) {
            if (parent[i] != -1) {
                System.out.println(parent[i] + " - " + i + "\t" + key[i]);
            }
        }
    }

    public static void main(String[] args) {
        int V = 5;
        List<List<Edge>> graph = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        // Undirected graph
        graph.get(0).add(new Edge(1, 2));
        graph.get(1).add(new Edge(0, 2));

        graph.get(0).add(new Edge(3, 6));
        graph.get(3).add(new Edge(0, 6));

        graph.get(1).add(new Edge(2, 3));
        graph.get(2).add(new Edge(1, 3));

        graph.get(1).add(new Edge(3, 8));
        graph.get(3).add(new Edge(1, 8));

        graph.get(1).add(new Edge(4, 5));
        graph.get(4).add(new Edge(1, 5));

        graph.get(2).add(new Edge(4, 7));
        graph.get(4).add(new Edge(2, 7));

        primMST(graph, 0);
    }
}
