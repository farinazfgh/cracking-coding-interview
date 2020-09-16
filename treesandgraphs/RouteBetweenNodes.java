package treesandgraphs;

import java.util.LinkedList;
import java.util.List;

public class RouteBetweenNodes {
    Graph G;
    boolean[] isVisited = new boolean[G.V];

    void dfs(Graph G, int vertex) {
        isVisited[vertex] = true;
        List<Integer> neighbors = G.adjacencyList[vertex];
        for (int current : neighbors) {
            if (!isVisited[current]) {
                isVisited[current] = true;
                dfs(G, current);
            }
        }
    }

    boolean search(Graph G, int start, int end) {
        isVisited[start] = true;
        List<Integer> neighbors = G.adjacencyList[start];
        for (int current : neighbors) {
            if (current == end) return true;
            if (!isVisited[current]) {
                isVisited[current] = true;
                dfs(G, current);
            }
        }
        return false;
    }

    static class Node {
        public String name;
        public List<Node> nodes;
        public State state;

        public List<Node> getNodes() {
            return nodes;
        }

        public Node[] getAdjacent() {
            return null;
        }
    }

    enum State {Unvisited, Visited, Visiting;}

    boolean search(GraphG g, Node start, Node end) {
        if (start == end) return true;

        // operates as Queue
        LinkedList<Node> q = new LinkedList<Node>();

        for (Node u : g.getNodes()) {
            u.state = State.Unvisited;
        }
        start.state = State.Visiting;
        q.add(start);
        Node u;
        while (!q.isEmpty()) {
            u = q.removeFirst();
            // i.e., dequeue()
            if (u != null) {
                for (Node v : u.getAdjacent()) {
                    if (v.state == State.Unvisited) {
                        if (v == end) {
                            return true;
                        } else {
                            v.state = State.Visiting;
                            q.add(v);
                        }

                    }
                }
                u.state = State.Visited;
            }
        }
        return false;
    }

    static class GraphG {


        public List<Integer>[] adjacencyList;

        public Node[] getNodes() {
            return null;
        }
    }
}
