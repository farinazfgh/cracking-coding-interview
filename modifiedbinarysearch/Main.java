package modifiedbinarysearch;

public class Main {
    static int NOT_FOUND = -1;

    static int binarySearchIterative(int[] array, int key) {
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (array[mid] == key) return mid;
            if (key < array[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return NOT_FOUND;
    }

    static int binarySearchRecursive(int[] array, int low, int high, int key) {
        if (low > high) return NOT_FOUND;
        int mid = (low + high) / 2;
        if (array[mid] == key) return mid;
        if (key < array[mid]) return binarySearchRecursive(array, low, mid - 1, key);
        else return binarySearchRecursive(array, mid + 1, high, key);
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(binarySearchIterative(array, 1));
        System.out.println(binarySearchIterative(array, 9));
        System.out.println(binarySearchIterative(array, 2));
        System.out.println(binarySearchIterative(array, 7));
        System.out.println(binarySearchIterative(array, 18));
        System.out.println(binarySearchIterative(array, 0));
        System.out.println("*************************************'");
        System.out.println(binarySearchRecursive(array, 0, array.length - 1, 1));
        System.out.println(binarySearchRecursive(array, 0, array.length - 1, 9));
        System.out.println(binarySearchRecursive(array, 0, array.length - 1, 2));
        System.out.println(binarySearchRecursive(array, 0, array.length - 1, 7));
        System.out.println(binarySearchRecursive(array, 0, array.length - 1, 18));
        System.out.println(binarySearchRecursive(array, 0, array.length - 1, 0));
    }
}
