package topologicalsort;

import java.util.LinkedList;
import java.util.Queue;

public class TopologicalX {

    private Queue<Integer> order;     // vertices in topological order
    private static int[] ranks;              // ranks[v] = order where vertex v appers in order
    private int[] indegree;        // indegree[v] = indegree of vertex v

    /**
     * Determines whether the digraph {@code G} has a topological order and, if so,
     * finds such a topological order.
     *
     * @param G the digraph
     */
    public TopologicalX(Digraph G) {

        // indegrees of remaining vertices
        int[] indegree = new int[G.V()];
        for (int v = 0; v < G.V(); v++) {
            indegree[v] = G.indegree(v);
        }

        // initialize
        ranks = new int[G.V()];
        order = new LinkedList<>();
        int count = 0;

        // initialize queue to contain all vertices with indegree = 0
        Queue<Integer> queue = new LinkedList<>();
        for (int v = 0; v < G.V(); v++)//add sources to the queue (those that have inDegree=0)
            if (indegree[v] == 0) queue.offer(v);

        while (!queue.isEmpty()) {
            int v = queue.poll();
            order.offer(v);
            ranks[v] = count++;
            for (int w : G.adj.get(v)) {
                indegree[w]--;
                if (indegree[w] == 0) queue.offer(w);
            }
        }

        // there is a directed cycle in subgraph of vertices with indegree >= 1.
        if (count != G.V()) {
            order = null;
        }

        assert check(G);
    }


    /**
     * Returns a topological order if the digraph has a topologial order,
     * and {@code null} otherwise.
     *
     * @return a topological order of the vertices (as an interable) if the
     * digraph has a topological order (or equivalently, if the digraph is a DAG),
     * and {@code null} otherwise
     */
    public Iterable<Integer> order() {
        return order;
    }

    public int indegree(int v) {
        validateVertex(v);
        return indegree[v];
    }


    /**
     * Does the digraph have a topological order?
     *
     * @return {@code true} if the digraph has a topological order (or equivalently,
     * if the digraph is a DAG), and {@code false} otherwise
     */
    public boolean hasOrder() {
        return order != null;
    }

    /**
     * The the rank of vertex {@code v} in the topological order;
     * -1 if the digraph is not a DAG
     *
     * @param v vertex
     * @return the position of vertex {@code v} in a topological order
     * of the digraph; -1 if the digraph is not a DAG
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public int rank(int v) {
        validateVertex(v);
        if (hasOrder()) return ranks[v];
        else return -1;
    }

    // certify that digraph is acyclic
    private boolean check(Digraph G) {

        // digraph is acyclic
        if (hasOrder()) {
            // check that ranks are a permutation of 0 to V-1
            boolean[] found = new boolean[G.V()];
            for (int i = 0; i < G.V(); i++) {
                found[rank(i)] = true;
            }
            for (int i = 0; i < G.V(); i++) {
                if (!found[i]) {
                    System.err.println("No vertex with rank " + i);
                    return false;
                }
            }

            // check that ranks provide a valid topological order
            for (int v = 0; v < G.V(); v++) {
                for (int w : G.adj.get(v)) {
                    if (rank(v) > rank(w)) {
                        System.err.printf("%d-%d: rank(%d) = %d, rank(%d) = %d\n",
                                v, w, v, rank(v), w, rank(w));
                        return false;
                    }
                }
            }

            // check that order() is consistent with rank()
            int r = 0;
            for (int v : order()) {
                if (rank(v) != r) {
                    System.err.println("order() and rank() inconsistent");
                    return false;
                }
                r++;
            }
        }


        return true;
    }

    // throw an IllegalArgumentException unless {@code 0 <= v < V}
    private void validateVertex(int v) {
        int V = ranks.length;
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
    }

    public static void main(String[] args) {

        Digraph G1 = new Digraph(7, 8);
        G1.addEdge(5, 3);
        G1.addEdge(5, 4);
        G1.addEdge(3, 0);
        G1.addEdge(3, 2);
        G1.addEdge(3, 1);
        G1.addEdge(4, 1);
        G1.addEdge(6, 2);
        G1.addEdge(6, 4);
        // find a directed cycle
        TopologicalX topological1 = new TopologicalX(G1);
        if (!topological1.hasOrder()) {
            System.out.println("Not a DAG");
        }

        // or give topologial sort
        else {
            System.out.print("Topological order: ");
            for (int v : topological1.order()) {
                System.out.print(v + " ");
            }
            System.out.println(">>>>>>>> ranks <<<<<<<<<");
              for (int v : ranks) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }
}
