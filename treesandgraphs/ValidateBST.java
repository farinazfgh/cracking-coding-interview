package treesandgraphs;

import java.util.ArrayList;
import java.util.List;

public class ValidateBST {


    static boolean isArraySortedAscending(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] >= array[i + 1]) return false;
        }
        return true;
    }

    static boolean validateBST(Util.Node node) {
        List<Integer> list = new ArrayList<>();
        inOrderT(node, list);
        return isArraySortedAscending(list.stream().mapToInt(i -> i).toArray());
    }

    static void inOrderT(Util.Node node, List<Integer> arrayList) {
        if (node == null) return;
        inOrderT(node.left, arrayList);
        arrayList.add(node.data);
        inOrderT(node.right, arrayList);
    }

    ////////// Gayle //////////////
    int index = 0;

    void copyBST(Util.Node root, int[] array) {
        if (root == null) return;
        copyBST(root.left, array);
        array[index] = root.data;
        index++;
        copyBST(root.right, array);
    }

    boolean checkBST1(Util.Node root) {
        int[] array = new int[/*root.size*/10];
        copyBST(root, array);
        for (int i = 1; i < array.length; i++) {
            if (array[i] <= array[i - 1]) return false;
        }
        return true;
    }

    /*
     Instead og keeping a hole array, why not just track the last element we saw and compare it as we go?
     */
    Integer last_printed = null;

    boolean inOrder(Util.Node n) {
        if (n == null) return true;
        // Check & recurse left
        if (!inOrder(n.left)) return false;
        // Check current
        if (last_printed != null && n.data <= last_printed) {
            return false;
        }
        //instead of adding it to an array just add it to an int
        last_printed = n.data;

        // Check & recurse right
        return inOrder(n.right);// All good!
    }

    boolean validate(Util.Node n) {
        return validate(n, null, null);
    }

    boolean validate(Util.Node n, Integer min, Integer max) {
        if (n == null) {
            return true;
        }
        if ((min != null && n.data <= min) || (max != null && n.data > max)) {
            return false;
        }
        return validate(n.left, min, n.data) && validate(n.right, n.data, max);
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        int[] array2 = {1, 2, 3, 4, 5, 7, 6};
        int[] array3 = {2, 1, 3, 4, 5, 6, 7};

        Util.Node node = Util.minimalTree(0, array.length, array);
        Util.Node node2 = Util.minimalTree(0, array.length, array2);
        Util.Node node3 = Util.minimalTree(0, array.length, array3);

        System.out.println(validateBST(node));
        System.out.println(validateBST(node2));
        System.out.println(validateBST(node3));
    }
}
