package sortingsearching.classic;

import java.util.Random;

public class Quick {
    private static final Random random;

    static {
        long seed = System.currentTimeMillis();
        random = new Random(seed);
    }

    private static int partition(int[] array, int low, int high) {
        int i = low;
        int j = high + 1;
        int pivot = array[low];
        while (true) {

            while (array[++i] < pivot) {//if less, move on the place is right stop at a greater element
                if (i == high) break;
            }

            while (array[--j] > pivot) {//if greater, move ob, the place is right, stop at a smaller element
                if (j == low) break;      // redundant since a[low] acts as sentinel
            }

            // check if pointers cross
            if (i >= j) break;

            swap(array, i, j);//swap the two that had wrong places
        }
        // put partitioning item pivot at a[j]
        swap(array, low, j);

        return j;
    }

    private static void swap(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static void sort(int[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    public static void sort(int[] a) {
        shuffle(a);
        sort(a, 0, a.length - 1);
    }

    public static void shuffle(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int r = i + uniform(n - i);     // between i and n-1
            int temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    public static int uniform(int n) {
        return random.nextInt(n);
    }

    public static void main(String[] args) {
        int[] array = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        sort(array);
        for (int value : array) System.out.print(value + " , ");
    }
}
