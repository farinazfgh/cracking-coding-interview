package sortingsearching;

public class Selection {
    void sort(int[] array) {
        for (int i = 0; i < array.length; i++)
            for (int j = i + 1; j < array.length; j++)
                if (array[i] > array[j]) swap(array, i, j);
    }

    void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {3, 4, 1, 2, 7, 0, 9};
        new Selection().sort(array);
        for (int value : array) System.out.print(value + " , ");
    }
}
