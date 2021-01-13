package cyclicsort;

/*
O(n) + O(n-1) which is asymptotically equivalent to O(n).
Space complexity # The algorithm runs in constant space O(1).
Each object, when created, was assigned a unique number from 1 to ‘n’ based on their creation sequence.
sort the objects in-place on their creation sequence number in O(n)O(n) and without any extra space.
 */
public class CyclicSort {
    public static void sort(int[] array) {

        for (int i = 0; i < array.length; i++) {
            if (array[i] != (i + 1)) swap(array, i, (array[i] - 1));
        }
    }

    static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 5, 4, 2};
        sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();

        arr = new int[]{2, 6, 4, 3, 1, 5};
        sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();

        arr = new int[]{1, 5, 6, 4, 3, 2};
        sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();
    }
}