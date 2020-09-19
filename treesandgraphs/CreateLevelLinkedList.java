package treesandgraphs;

import java.util.*;

public class CreateLevelLinkedList {
    /*
    List of Depths: Given a binary tree, design an algorithm which creates a linked list of all the nodes
    at each depth (e.g., if you have a tree with depth D, you 'll have D linked lists).
     */

    static class Node {
        final int data;

        public Node(int data) {
            this.data = data;
        }

        Node left;
        Node right;
    }


    static private Node createTree(int low, int high, int[] array) {
        if (low >= high) {
            return null;
        }
        int mid = (low + high) / 2;
        Node node = new Node(array[mid]);
        node.left = createTree(low, mid, array);
        node.right = createTree(mid + 1, high, array);
        return node;

    }

    static void preOrder(Node node, int level, Map<Integer, List<Integer>> listLevel) {
        //NLR
        if (node == null) return;
        List<Integer> nodes = listLevel.get(level);
        if (nodes == null) nodes = new ArrayList<>();
        nodes.add(node.data);
        listLevel.put(level, nodes);
        System.out.print(node.data + " , ");
        preOrder(node.left, level + 1, listLevel);
        preOrder(node.right, level + 1, listLevel);
    }

    static void postOrder(Node node, int level, Map<Integer, List<Integer>> listLevel) {
        //LRN
        if (node == null) return;
        postOrder(node.left, level + 1, listLevel);
        postOrder(node.right, level + 1, listLevel);
        List<Integer> nodes = listLevel.get(level);
        if (nodes == null) nodes = new ArrayList<>();
        nodes.add(node.data);
        listLevel.put(level, nodes);
        System.out.print(node.data + " , ");

    }

    static void inOrder(Node node, int level, Map<Integer, List<Integer>> listLevel) {
        //LNR
        if (node == null) return;
        inOrder(node.left, level + 1, listLevel);
        List<Integer> nodes = listLevel.get(level);
        if (nodes == null) nodes = new ArrayList<>();
        nodes.add(node.data);
        listLevel.put(level, nodes);

        System.out.print(node.data + " , ");
        inOrder(node.right, level + 1, listLevel);
    }

    ArrayList<LinkedList<Node>> createLevelLinkedList(Node root) {
        ArrayList<LinkedList<Node>> result = new ArrayList<>();
        /* "Visit" the root */
        LinkedList<Node> current = new LinkedList<>();
        if (root != null) {
            current.add(root);
        }
        while (current.size() > 0) {
            result.add(current);// Add previous level
            LinkedList<Node> parents = current;// Go to next level
            current = new LinkedList<Node>();
            for (Node parent : parents) {
                /* Visit the children */
                if (parent.left != null) {
                    current.add(parent.left);
                }
                if (parent.right != null) {
                    current.add(parent.right);
                }
            }
        }
        return result;
    }

    static int prelevel = 0;
    static int postlevel = 0;
    static int inlevel = 0;
    static Map<Integer, List<Integer>> prelistLevel = new HashMap<>();
    static Map<Integer, List<Integer>> postlistLevel = new HashMap<>();
    static Map<Integer, List<Integer>> inlistlevel = new HashMap<>();

    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        Node node = createTree(0, array.length - 1, array);
        inOrder(node, inlevel, inlistlevel);
        System.out.println(inlistlevel);
        preOrder(node, prelevel, prelistLevel);
        System.out.println(inlistlevel);
        postOrder(node, postlevel, postlistLevel);
        System.out.println(postlistLevel);
        System.out.println();
    }
}
