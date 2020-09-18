package treesandgraphs;

import java.util.*;

public class RouteBetweenNodes {
    Graph G = new Graph();
    boolean[] isVisited = new boolean[G.V];

    void dfs(Graph G, int vertex) {
        isVisited[vertex] = true;
        List<Integer> neighbors = G.adjacencyList.get(vertex);
        for (int current : neighbors) {
            if (!isVisited[current]) {
                isVisited[current] = true;
                dfs(G, current);
            }
        }
    }

    boolean search(Graph G, int start, int end) {
        isVisited[start] = true;
        List<Integer> neighbors = G.adjacencyList.get(start);
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

    void dfsIterative(int source) {
        boolean[] isVisited = new boolean[G.V];
        Stack<Integer> stack = new Stack();
        stack.push(source);
        isVisited[source] = true;
        while (!stack.isEmpty()) {
            int vertex = stack.pop();
            for (int currentVertex : G.adjacencyList.get(vertex)) {
                if (!isVisited[currentVertex]) {
                    isVisited[currentVertex] = true;
                    stack.push(currentVertex);
                }
            }
        }
    }

    void bfs(int source) {
        boolean[] isVisited = new boolean[G.V];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(source);
        isVisited[source] = true;
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            for (Integer currentVerex : G.adjacencyList.get(vertex)) {
                if (!isVisited[currentVerex]) {
                    isVisited[currentVerex] = true;
                    queue.offer(currentVerex);
                }
            }

        }
    }
}
