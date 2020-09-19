package treesandgraphs;

import java.util.*;

public class RouteBetweenNodes {
    Graph G = new Graph(5);
    boolean[] isVisited = new boolean[G.V()];

    void dfs(Graph G, int vertex) {
        isVisited[vertex] = true;
        Set<Integer> neighbors = G.adjacencyList.get(vertex);
        for (int current : neighbors) {
            if (!isVisited[current]) {
                isVisited[current] = true;
                dfs(G, current);
            }
        }
    }

    static class Edge {
        final int from;
        final int two;

        public Edge(int from, int two) {
            this.from = from;
            this.two = two;
        }

        @Override
        public String toString() {
            return from + " -> " + two;
        }
    }

    static void printArray(int[] array) {
        for (int value : array)
            System.out.print(value + ", ");
        System.out.println();
    }

    static void printEdges(List<Edge> edges) {
        for (Edge edge : edges)
            System.out.print(edge + ", ");
        System.out.println();
    }

    static void dfsIterative(Graph G, int source) {
        System.out.println("************ DFS ************");
        boolean[] isVisited = new boolean[G.V()];
        int[] parent = new int[G.V()];
        List<Edge> E = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(source);
        isVisited[source] = true;
        while (!stack.isEmpty()) {
            int vertex = stack.pop();
            visit(vertex);
            Set<Integer> neighbors = G.adjacencyList.get(vertex);
            if (neighbors == null) continue;
            for (int currentVertex : neighbors) {
                if (!isVisited[currentVertex]) {
                    parent[currentVertex] = vertex;
                    E.add(new Edge(vertex, currentVertex));
                    isVisited[currentVertex] = true;
                    stack.push(currentVertex);
                }
            }
        }
        System.out.println();
        printArray(parent);
        printEdges(E);
    }

    static void bfs(Graph G, int source) {
        System.out.println("************ BFS ************");
        boolean[] isVisited = new boolean[G.V()];
        List<Edge> E = new ArrayList<>();
        int[] parent = new int[G.V()];

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(source);
        isVisited[source] = true;
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            visit(vertex);
            Set<Integer> neighbors = G.adjacencyList.get(vertex);
            if (neighbors == null) continue;
            for (int currentVertex : neighbors) {
                if (!isVisited[currentVertex]) {
                    parent[currentVertex] = vertex;
                    E.add(new Edge(vertex, currentVertex));
                    isVisited[currentVertex] = true;
                    queue.offer(currentVertex);
                }
            }
        }
        System.out.println();
        printArray(parent);
        printEdges(E);
    }

    public static void main(String[] args) {
        Graph graph = createGraphFromArray(6);
        System.out.println(graph);
        int source = 0;//hard coded just for simplicity
        dfsIterative(graph, source);
        bfs(graph, source);

    }

    private static Graph createGraphFromArray(int v) {
        Graph graph = new Graph(v);
        int V = 6;
        int E = 9;
        List<Integer[]> array = Arrays.asList(
                new Integer[]{0, 5},
                new Integer[]{0, 1},
                new Integer[]{2, 0},
                new Integer[]{2, 3},
                new Integer[]{3, 2},
                new Integer[]{3, 5},
                new Integer[]{4, 3},
                new Integer[]{4, 2},
                new Integer[]{5, 4});

        for (Integer[] value : array) {
            graph.addEdge(value[0], value[1]);

        }
        return graph;
    }

    static void visit(int v) {
        System.out.print(v + ", ");
    }
    private static Graph createGraph() {
        Graph graph = new Graph(6);
        Scanner scanner = new Scanner(System.in);
        int V = Integer.parseInt(scanner.nextLine());
        int E = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < E; i++) {
            int from = Integer.parseInt(scanner.nextLine());
            if (from < 0 || from > V)
                throw new IllegalArgumentException("vertex should be greater than 0 and less than V!");
            int to = Integer.parseInt(scanner.nextLine());
            if (to < 0 || to > V)
                throw new IllegalArgumentException("vertex should be greater than 0 and less than V!");
            graph.addEdge(from, to);

        }
        return graph;
    }
}
