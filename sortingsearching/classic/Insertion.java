package sortingsearching.classic;

public class Insertion {
    public static void sort(int[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j] < a[j - 1]) swap(a, j, j - 1);
            }
            assert isSorted(a, 0, i);
        }
        assert isSorted(a);
    }

    private static void swap(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static boolean isSorted(int[] a) {
        return isSorted(a, 0, a.length);
    }

    private static boolean isSorted(int[] a, int lo, int hi) {
        for (int i = lo + 1; i < hi; i++)
            if (a[i] < a[i - 1]) return false;
        return true;
    }

    public static void main(String[] args) {
        int[] array = {3, 4, 1, 2, 7, 0, 9};
        sort(array);
        for (int value : array) System.out.print(value + " , ");
    }
}
