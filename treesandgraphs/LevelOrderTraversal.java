package treesandgraphs;

import java.util.ArrayDeque;
import java.util.Queue;

public class LevelOrderTraversal {
    static class Node {
        final int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    static Queue<Node> queue = new ArrayDeque<>();

    static void levelOrderTraverse(Node root) {
        bfs(root);
    }

    static void bfs(Node node) {

        queue.offer(node);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.println(current.data);
            if (current.left != null) queue.offer(current.left);
            if (current.right != null) queue.offer(current.right);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(12);
        root.left = new Node(7);
        root.right = new Node(1);
        root.left.left = new Node(9);
        root.right.left = new Node(10);
        root.right.right = new Node(5);
//        List<List<Integer>> result = LevelOrderTraversal.traverse(root);
        bfs(root);
    }
}
