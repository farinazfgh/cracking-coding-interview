package treesandgraphs;

import java.util.Arrays;
import java.util.List;

class Util {
    static Node minimalTree(int low, int high, int[] array) {
        if (low >= high) {
            return null;
        }
        int mid = (low + high) / 2;
        Node node = new Node(array[mid]);
        node.left = minimalTree(low, mid, array);
        node.right = minimalTree(mid + 1, high, array);
        return node;
    }

    static Graph createGraphFromArray(int v) {
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

    static void preOrder(MinimalTree.Node node) {
        //NLR
        if (node == null) return;
        System.out.print(node.data + " , ");
        preOrder(node.left);
        preOrder(node.right);
    }

    static void postOrder(MinimalTree.Node node) {
        //LRN
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " , ");

    }

    static void inOrder(MinimalTree.Node node) {
        //LNR
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.data + " , ");
        inOrder(node.right);
    }

    static class Node {
        final int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
        }
    }

}
