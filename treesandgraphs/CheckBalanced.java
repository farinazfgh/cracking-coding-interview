package treesandgraphs;

/**
 * Check Balanced: Implement a function to check if a binary tree is balanced.
 * For the purposes of this question, a balanced tree is defined to be a tree such that the heights of the two subtrees of any
 * node never differ by more than one.
 */
public class CheckBalanced {


    static int getHeight(Util.Node node) {
        if (node == null) {
            return -1;
        }
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    static boolean isBalanced(Util.Node node) {
        int heightDifference = Math.abs(getHeight(node.left) - getHeight(node.right));
        return (heightDifference >= 0 && heightDifference <= 1);

    }

    boolean isBalancedII(Util.Node root) {
        if (root == null) return true;// Base case
        int heightDiff = getHeight(root.left) - getHeight(root.right);
        if (Math.abs(heightDiff) > 1) {
            return false;
        } else { // Recurse
            return isBalancedII(root.left) && isBalancedII(root.right);
        }
    }

    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        Util.Node node = Util.minimalTree(0, array.length - 1, array);
        System.out.println(getHeight(node));
        System.out.println(isBalanced(node));
    }
}
