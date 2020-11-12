package treedfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreePathSum {
    boolean[] isVisited = new boolean[20];
    Node[] parent = new Node[20];
    List<Node> leaves = new ArrayList<>();

    static class Node {
        final int data;

        Node(int data) {
            this.data = data;
        }

        Node left, right;
    }

    void hasPathIterative(Node root, int sum) {
        if (root == null) return;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        parent[root.data] = null;
        while (!stack.isEmpty()) {
            Node current = stack.pop();
            if (isLeaf(current)) leaves.add(current);
            if (!isVisited[current.data]) {
                isVisited[current.data] = true;
                vist(current);
                if (current.left != null) {
                    parent[current.left.data] = current;
                    stack.push(current.left);
                }
                if (current.right != null) {
                    parent[current.right.data] = current;
                    stack.push(current.right);
                }
            }
        }
    }

    public static boolean hasPathRecursive(Node root, int sum) {
        if (root == null) return false;
        if (isLeaf(root) && root.data == sum) return true;
        return hasPathRecursive(root.left, sum - root.data) || hasPathRecursive(root.right, sum - root.data);
        // recursively call to traverse the left and right sub-tree
        // return true if any of the two recursive call return true
    }

    static private boolean isLeaf(Node node) {
        return (node.left == null) && (node.right == null);
    }

    private void vist(Node current) {
        System.out.print(current.data + " , ");
    }

    public static void main(String[] args) {
        Node root2 = getNode2();
        System.out.println();
        new TreePathSum().hasPathIterative(root2, 0);
    }

    private static Node getNode() {
        Node root = new Node(12);
        root.left = new Node(7);
        root.right = new Node(1);
        root.left.left = new Node(9);
        root.right.left = new Node(10);
        root.right.right = new Node(5);
        return root;
    }

    private static Node getNode2() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        return root;
    }
}