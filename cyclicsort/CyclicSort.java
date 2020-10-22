package cyclicsort;
/*
O(n) + O(n-1) which is asymptotically equivalent to O(n).
Space complexity # The algorithm runs in constant space O(1).
 */

public class CyclicSort {
    static void sort(int[] array) {

        for (int i = 0; i < array.length; i++) {
            while (array[i] != i + 1) {
                int temp = array[array[i] - 1];
                array[array[i] - 1] = array[i];
                array[i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 5, 4, 2};
        CyclicSort.sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();

        arr = new int[]{2, 6, 4, 3, 1, 5};
        CyclicSort.sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();

        arr = new int[]{1, 5, 6, 4, 3, 2};
        CyclicSort.sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();
    }
}