package topologicalsort;

import java.util.*;

public class TopologicalSort {
    static Map<Integer, List<Integer>> adjacencyLsit = new HashMap<>();
    static Map<Integer, Integer> inDegrees = new HashMap<>();//number of incoming edges

    static Queue<Integer> sort(int vertices, int[][] edges) {
        Queue<Integer> sortedList = new LinkedList<>();
        createGraph(vertices, edges);
        System.out.println(adjacencyLsit);
        System.out.println(inDegrees);
        System.out.println(getSources(vertices));
        Queue<Integer> sources = getSources(vertices);

        /*
        For each source, do the following things:
            Add it to the sorted list.
            Get all of its children from the graph.
            Decrement the in-degree of each child by 1.
            If a child’s in-degree becomes ‘0’, add it to the sources Queue.
            Repeat step 1, until the source Queue is empty.
         */
        while (!sources.isEmpty()) {
            int vertex = sources.poll();
            sortedList.offer(vertex);
            List<Integer> neighbors = adjacencyLsit.get(vertex);
            if (neighbors != null) for (Integer neighbor : neighbors) {
                int inDegree = inDegrees.get(neighbor);
                inDegree--;
                inDegrees.put(neighbor, inDegree);
                if (inDegree == 0) sources.offer(neighbor);
            }

        }
        if (sortedList.size() != vertices) // topological sort is not possible as the graph has a cycle
            return new LinkedList<>();

        return sortedList;
    }

    static private void createGraph(int vertices, int[][] edges) {
        for (int[] edge : edges) {
            int parent = edge[0];
            int child = edge[1];
            List<Integer> neighbors = adjacencyLsit.get(parent);
            if (neighbors == null) neighbors = new ArrayList<>();
            neighbors.add(child);
            adjacencyLsit.put(parent, neighbors);
            Integer inDegree = inDegrees.get(child);
            if (inDegree == null) inDegree = 0;
            inDegree++;
            inDegrees.put(child, inDegree);
        }
    }

    public static void main(String[] args) {
      /*    List<Integer> result = TopologicalSort.sort(4,
                new int[][]{new int[]{3, 2}, new int[]{3, 0}, new int[]{2, 0}, new int[]{2, 1}});
        System.out.println(result);

        List<Integer> result  = TopologicalSort.sort(5, new int[][]{new int[]{4, 2}, new int[]{4, 3}, new int[]{2, 0},
                new int[]{2, 1}, new int[]{3, 1}});
        System.out.println(result);*/

        Queue<Integer> result = TopologicalSort.sort(7
                , new int[][]{
                        new int[]{6, 4}
                        , new int[]{6, 2}
                        , new int[]{5, 3},
                        new int[]{5, 4}
                        , new int[]{3, 0}
                        , new int[]{3, 1}
                        , new int[]{3, 2}
                        , new int[]{4, 1}});
        System.out.println(result);
    }

    static Queue<Integer> getSources(int vertices) {
        Queue<Integer> sources = new LinkedList<>();
        for (int i = 0; i < vertices; i++) {
            if (inDegrees.get(i) == null) sources.add(i);
        }
        return sources;
    }
}
