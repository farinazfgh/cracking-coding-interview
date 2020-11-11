package treebfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    static class TreeNode {
        private final int data;

        public TreeNode(int data) {
            this.data = data;
        }

        TreeNode left, right;
    }

    static void traverse(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            visit(current);
            if (current.left != null) queue.offer(current.left);
            if (current.right != null) queue.offer(current.right);
        }
        System.out.println();
    }

    static private void visit(TreeNode current) {
        System.out.print(current.data + " , ");
    }

    static List<List<Integer>> traverseByLevel(TreeNode node) {
        if (node == null) throw new IllegalArgumentException("tree should not be null");
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!(queue.isEmpty())) {
            int levelSize = queue.size();
            List<Integer> nodesPerLevel = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                nodesPerLevel.add(current.data);
                nodesPerLevel.add(current.data);
                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
            result.add(nodesPerLevel);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        traverse(root);
        System.out.println(traverseByLevel(root));
    }
}
