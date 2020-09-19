package treesandgraphs;

/*
    Minimal Tree: Given a sorted (increasing order) array with unique integer elements, write an
    algorithm to create a binary search tree with minimal height.
 */

public class MinimalTree {

    static class Node {
        final int data;

        public Node(int data) {
            this.data = data;
        }

        Node left;
        Node right;
    }


    static private Node minimalTree(int low, int high, int[] array) {
        if (low >= high) {
            return null;
        }
        int mid = (low + high) / 2;
        Node node = new Node(array[mid]);
        node.left = minimalTree(low, mid, array);
        node.right = minimalTree(mid + 1, high, array);
        return node;

    }

    static void preOrder(Node node) {
        //NLR
        if (node == null) return;
        System.out.print(node.data + " , ");
        preOrder(node.left);
        preOrder(node.right);
    }

    static void postOrder(Node node) {
        //LRN
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " , ");

    }

    static void inOrder(Node node) {
        //LNR
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.data + " , ");
        inOrder(node.right);
    }

    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        Node node = minimalTree(0, array.length - 1, array);
        inOrder(node);
        System.out.println();
        preOrder(node);
        System.out.println();
        postOrder(node);
        System.out.println();
    }
}
