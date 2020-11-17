package topologicalsort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Digraph {
    private final int V;           // number of vertices in this digraph
    private int E;                 // number of edges in this digraph
    private int[] indegree;        // indegree[v] = indegree of vertex v

    Map<Integer, List<Integer>> adj;


    public Digraph(int V, int E) {
        this.adj = new HashMap<>();
        this.indegree = new int[V];

        this.V = V;
        this.E = E;
        if (V < 0) throw new IllegalArgumentException("Number of vertices in a Digraph must be nonnegative");

        // update adjacency lists
        for (int v = 0; v < V; v++) {
            adj.put(v, new ArrayList<>());
        }
    }

    private int E() {
        return this.E;
    }

    public int V() {
        return this.V;
    }

    public int indegree(int v) {
        return indegree[v];
    }


    public void addEdge(int v, int w) {
        adj.get(v).add(w);
        indegree[w]++;
    }

    private void visit(int vertex) {
        System.out.print(" " + vertex);
    }
}
