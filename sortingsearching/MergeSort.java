package sortingsearching;

public class MergeSort {
    static void merge(int[] array, int[] aux, int low, int mid, int high) {
        int left = low;
        int right = mid + 1;
        int index = low;

        while (left <= mid && right <= high) {
            if (array[left] < array[right])
                aux[index++] = array[left++];
            else
                aux[index++] = array[right++];
        }
        //left side was bigger
        for (; left <= mid; left++)
            aux[index++] = array[left];
        //right side was bigger
        for (; right <= high; right++)
            aux[index++] = array[right];


        //copy the aux back to the main array
        for (left = low; left <= high; left++)
            array[left] = aux[left];
    }

    static void mergeSort(int[] array, int[] aux, int low, int high) {
        int mid;
        if (low < high) {
            mid = (low + high) / 2;
            mergeSort(array, aux, low, mid);
            mergeSort(array, aux, mid + 1, high);
            merge(array, aux, low, mid, high);
        }
    }

    static void mergeSort(int[] array) {
        int[] aux = new int[array.length];
        mergeSort(array, aux, 0, array.length - 1);
    }

    static void printArray(int[] array) {
        for (int val : array) {
            System.out.print(val + ",");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {};
        int[] array1 = {1};
        int[] array2 = {1, 2};
        int[] array3 = {10, 7, 11};
        int[] array4 = {10, 7, 11, 6};
        int[] array5 = {10, 7, 11, 6, 12};
        mergeSort(array5);
        printArray(array5);

        mergeSort(array4);
        printArray(array4);

        mergeSort(array2);
        printArray(array2);

        mergeSort(array3);
        printArray(array3);

        mergeSort(array1);
        printArray(array1);

        mergeSort(array);
        printArray(array);
    }
}
