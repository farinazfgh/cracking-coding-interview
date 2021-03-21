package sortingsearching.classic;

public class Heap {
    public static void sort(int[] pq) {
        int n = pq.length;

        // heapify phase
        for (int k = n / 2; k >= 1; k--)
            sink(pq, k, n);

        // sortdown phase
        int k = n;
        while (k > 1) {
            swap(pq, 1, k--);
            sink(pq, 1, k);
        }
    }

    private static void swap(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static void sink(int[] pq, int k, int n) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(pq, j, j + 1)) j++;
            if (!less(pq, k, j)) break;
            swap(pq, k, j);
            k = j;
        }
    }

    /***************************************************************************
     * Helper functions for comparisons and swaps.
     * Indices are "off-by-one" to support 1-based indexing.
     ***************************************************************************/
    private static boolean less(int[] pq, int i, int j) {
        return pq[i - 1] < pq[j - 1];
    }

    public static void main(String[] args) {
        int[] array = {8, 6, 9, 2, 3, 7, 5, 0, 4, 1};
        sort(array);
        for (int val : array) System.out.print(val + " , ");
    }

}
