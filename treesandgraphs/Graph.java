package treesandgraphs;

import java.util.ArrayList;

public class Graph {
    int V;
    int E;

    ArrayList[] adjacencyList = new ArrayList[V];


    public int getV() {
        return V;
    }

    public int getE() {
        return E;
    }

    public Graph(int v) {
        if (v< 0) throw new IllegalArgumentException("Number of vertices must be nonnegative");

        this.V = v;
        this.E = 0;

        for (int vertex = 0; vertex < v; vertex++) {
            adjacencyList[vertex] = new ArrayList<Integer>();
        }

    }
}
