package cyclicsort;

public class FindCorruptNums {
    public static int[] findNumbers(int[] array) {
        int[] corrupted = new int[2];
        for (int i = 0; i < array.length; i++) {
            if (array[i] != (i + 1))
                swap(array, i, array[i] - 1);
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] != (i + 1)) {
                corrupted[0] = array[i - 1];
                corrupted[1] = array[i];
            }

        }
        return corrupted;
    }

    static void swap(int[] array, int index1, int index2) {
        array[index1] = array[index1] - array[index2];
        array[index2] = array[index1] + array[index2];
        array[index1] = array[index2] - array[index1];
    }

    public static void main(String[] args) {
        printArray(findNumbers(new int[]{3, 1, 2, 5, 2}));
        printArray(findNumbers(new int[]{3, 1, 2, 3, 6, 4}));
    }

    static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " , ");
        }
        System.out.println();
    }
}
