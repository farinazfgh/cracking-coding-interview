package sortingsearching.classic;

public class Merge {
    public static void sort(int[] a) {
        int[] aux = new int[a.length];
        sort(a, aux, 0, a.length - 1);
    }

    private static void sort(int[] a, int[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }

    private static void merge(int[] array, int[] aux, int low, int mid, int high) {

        // copy array to aux[]
        for (int index = low; index <= high; index++) {
            aux[index] = array[index];
        }

        // merge back to array[]
        int i = low, j = mid + 1;
        for (int k = low; k <= high; k++) {
            if (i > mid) array[k] = aux[j++];
            else if (j > high) array[k] = aux[i++];
            else if (aux[j] < aux[i]) array[k] = aux[j++];
            else array[k] = aux[i++];
        }
    }

}
