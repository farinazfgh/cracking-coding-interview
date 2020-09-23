package treesandgraphs;

public class BSTInOrderSuccessor {
    static class TreeNode {
        final int data;

        public TreeNode(int data) {
            this.data = data;
        }

        TreeNode left;
        TreeNode right;
        int predecessor;
    }

    //2^log(n) -1 recursive calls
    static int numberOfRecursiveCalls = 0;

    static void inOrder(TreeNode node) {
        numberOfRecursiveCalls++;
        if (node == null) return;
        inOrder(node.left);
        System.out.println(node.data + ", predecessor: " + node.predecessor);
        inOrder(node.right);
    }

    static int last_array_mid = -1;

    static TreeNode minimalTree(int low, int high, int[] array) {
        if (low >= high) {
            return null;
        }
        int mid = (low + high) / 2;
        TreeNode node = new TreeNode(array[mid]);
        node.predecessor = last_array_mid;
        last_array_mid = array[mid];
        node.left = minimalTree(low, mid, array);
        node.right = minimalTree(mid + 1, high, array);
        return node;
    }

    public static void main(String[] args) {
        //int[] array = {1, 2, 3, 4, 5, 6, 7};
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        TreeNode node = minimalTree(0, array.length, array);
        inOrder(node);
        System.out.println(numberOfRecursiveCalls);

    }
}
