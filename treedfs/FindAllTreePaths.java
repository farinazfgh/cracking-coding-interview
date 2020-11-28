package treedfs;

import java.util.*;

public class FindAllTreePaths {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int x) {
            data = x;
        }
    }

    static Map<Node, Node> parents = new HashMap<>();
    static List<List<Integer>> allPaths = new ArrayList<>();

    static List<List<Integer>> findPaths(Node root, int X) {

        Stack<Node> stack = new Stack<>();
        Node nullNode = new Node(Integer.MIN_VALUE);
        nullNode.left = nullNode.right = null;
        parents.put(root, nullNode);
        stack.push(root);

        while (!stack.isEmpty()) {
            Node current = stack.pop();
            if (isLeaf(current)) {
                getPathSum(current, X);
            }

            if (current.left != null) {
                stack.push(current.left);
                parents.put(current.left, current);
            }
            if (current.right != null) {
                stack.push(current.right);
                parents.put(current.right, current);
            }
        }
        return allPaths;
    }

    static boolean isLeaf(Node node) {
        if (node == null) return false;
        if (node.data == Integer.MIN_VALUE) return false;
        return (node.left == null && node.right == null);

    }

    static void getPathSum(Node leaf, int X) {
        List<Integer> paths = new ArrayList<>();
        int tempSum = leaf.data;
        paths.add(leaf.data);
        Node parent = parents.get(leaf);
        while (parent.data != Integer.MIN_VALUE) {
            tempSum += parent.data;
            paths.add(parent.data);
            parent = parents.get(parent);
        }
        if (tempSum == X) allPaths.add(paths);

    }

    public static void main(String[] args) {
        Node root = new Node(12);
        root.left = new Node(7);
        root.right = new Node(1);
        root.left.left = new Node(4);
        root.right.left = new Node(10);
        root.right.right = new Node(5);
        int sum = 23;
        List<List<Integer>> result = FindAllTreePaths.findPaths(root, sum);
        System.out.println("Tree paths with sum " + sum + ": " + result);
    }

}