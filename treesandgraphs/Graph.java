package treesandgraphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph {

    private final int v;

    public Graph(int v) {
        this.v = v;
    }


    int V() {
        return v;
    }

    Map<Integer, Set<Integer>> adjacencyList = new HashMap<>();


    void addEdge(int u, int v) {
        Set<Integer> set = adjacencyList.get(u);
        if (set == null) {
            set = new HashSet<>();
        }
        set.add(v);
        adjacencyList.put(u, set);
    }

    @Override
    public String toString() {
        return "Graph{" +
                "V=" + V() +
                ", adjacencyList=" + adjacencyList +
                '}';
    }
}
