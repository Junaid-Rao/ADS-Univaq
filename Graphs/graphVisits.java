import java.util.*;

public class Main {

    // Graph using adjacency list
    static class Graph {
        private Map<Integer, List<Integer>> adjList = new HashMap<>();

        public void addEdge(int u, int v) {
            adjList.putIfAbsent(u, new ArrayList<>());
            adjList.putIfAbsent(v, new ArrayList<>());
            adjList.get(u).add(v);
            adjList.get(v).add(u); // remove if directed
        }

        public List<Integer> getNeighbors(int node) {
            return adjList.getOrDefault(node, new ArrayList<>());
        }
    }

    // ================= BFS =================
    public static Map<Integer, Integer> bfs(Graph g, int s) {

        Set<Integer> visited = new HashSet<>();
        Map<Integer, Integer> parent = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();

        visited.add(s);
        queue.add(s);

        while (!queue.isEmpty()) {
            int u = queue.poll();
            System.out.println("BFS Visit: " + u);

            for (int v : g.getNeighbors(u)) {
                if (!visited.contains(v)) {
                    queue.add(v);
                    visited.add(v);
                    parent.put(v, u);
                }
            }
        }

        return parent;
    }

    // ================= DFS =================

    // Helper function: recursiveDFS
    public static void recursiveDFS(Graph g, int v,
                                    Set<Integer> visited,
                                    Map<Integer, Integer> parent) {

        // 1. mark and visit node v
        visited.add(v);
        System.out.println("DFS Visit: " + v);

        // 2. for each (v, w)
        for (int w : g.getNeighbors(v)) {

            // 3. if w is not marked
            if (!visited.contains(w)) {

                // 4. add (v, w) to tree
                parent.put(w, v);

                // 5. recursive call
                recursiveDFS(g, w, visited, parent);
            }
        }
    }

    // Main DFS function
    public static Map<Integer, Integer> dfs(Graph g, int s) {

        // 6. empty tree
        Map<Integer, Integer> parent = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        // 7. call recursiveDFS
        recursiveDFS(g, s, visited, parent);

        // 8. return tree
        return parent;
    }

    // ================= MAIN =================
    public static void main(String[] args) {

        Graph g = new Graph();

        // Create graph
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 5);
        g.addEdge(4, 6);

        int startNode = 1;

        // BFS
        System.out.println("=== BFS Traversal ===");
        Map<Integer, Integer> bfsTree = bfs(g, startNode);

        System.out.println("\nBFS Parent Tree:");
        for (var entry : bfsTree.entrySet()) {
            System.out.println(entry.getKey() + " <- " + entry.getValue());
        }

        // DFS
        System.out.println("\n=== DFS Traversal ===");
        Map<Integer, Integer> dfsTree = dfs(g, startNode);

        System.out.println("\nDFS Parent Tree:");
        for (var entry : dfsTree.entrySet()) {
            System.out.println(entry.getKey() + " <- " + entry.getValue());
        }
    }
}
