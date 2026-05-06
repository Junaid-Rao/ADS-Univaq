import java.util.*;

class Edge {
    int u, v, weight;

    Edge(int u, int v, int weight) {
        this.u = u;
        this.v = v;
        this.weight = weight;
    }
}

class UnionFind {
    int[] parent;
    int[] rank;

    UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
    }

    // Step 4: makeSet(v)
    void makeSet(int v) {
        parent[v] = v;
        rank[v] = 0;
    }

    // Step 6/7: find(x)
    int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // Path compression
        }
        return parent[x];
    }

    // Step 9: union(x, y)
    void union(int x, int y) {
        if (rank[x] < rank[y]) {
            parent[x] = y;
        } else if (rank[x] > rank[y]) {
            parent[y] = x;
        } else {
            parent[y] = x;
            rank[x]++;
        }
    }
}

public class KruskalUF {

    public static void kruskal(List<Edge> edges, int V) {

        // Step 1: UnionFind UF
        UnionFind uf = new UnionFind(V);

        // Step 2: Sort edges
        edges.sort(Comparator.comparingInt(e -> e.weight));

        // Step 3: T ← empty tree
        List<Edge> mst = new ArrayList<>();

        // Step 4: makeSet(v)
        for (int i = 0; i < V; i++) {
            uf.makeSet(i);
        }

        int totalCost = 0;

        // Step 5: iterate edges
        for (Edge edge : edges) {
            int x = edge.u;
            int y = edge.v;

            // Step 6,7: find
            int Tx = uf.find(x);
            int Ty = uf.find(y);

            // Step 8: if roots different
            if (Tx != Ty) {
                // Step 9: union
                uf.union(Tx, Ty);

                // Step 10: add edge
                mst.add(edge);
                totalCost += edge.weight;

                System.out.println(x + " - " + y + " : " + edge.weight);
            }
        }

        System.out.println("Total Cost: " + totalCost);
    }

    public static void main(String[] args) {
        int V = 5;

        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 2));
        edges.add(new Edge(0, 3, 6));
        edges.add(new Edge(1, 2, 3));
        edges.add(new Edge(1, 3, 8));
        edges.add(new Edge(1, 4, 5));
        edges.add(new Edge(2, 4, 7));

        kruskal(edges, V);
    }
}
