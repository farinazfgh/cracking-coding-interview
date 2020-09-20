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
        inOrder(node, list);
        return isArraySortedAscending(list.stream().mapToInt(i -> i).toArray());
    }

    static void inOrder(Util.Node node, List<Integer> arrayList) {
        if (node == null) return;
        inOrder(node.left, arrayList);
        arrayList.add(node.data);
        inOrder(node.right, arrayList);
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
