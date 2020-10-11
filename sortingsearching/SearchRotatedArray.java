package sortingsearching;

public class SearchRotatedArray {
    // {15, 16, 19, 20, 25, 1, 3,4,5,7,10, 14}
    //  Array2: {50, 5 , 20, 30, 40}
    //  Array3:  {2, 2, 2, 3, 5, 6}
    //  Array4:  {2, 2, 2, 3, 5, 2}
    static int binarySearch(int[] array, int key) {
        return binarySearch(array, 0, array.length - 1, key);
    }

    static int binarySearch(int[] array, int low, int high, int key) {
        int mid = (low + high) / 2;
        if (low > high) return -1;//not found
        if (array[mid] == key) return mid;
        if (array[mid] > key) return binarySearch(array, low, mid, key);
        else return binarySearch(array, mid + 1, high, key);
    }

    static int binarySearchRotatedArray(int[] array, int key) {
        return binarySearchRotatedArray(array, 0, array.length - 1, key);
    }

    static int binarySearchRotatedArray(int[] a, int left, int right, int key) {
        int mid = (left + right) / 2;
        if (a[mid] == key) return mid;
        if (right < left) {
            return -1;
        }
        if (a[left] < a[mid]) { //left side is normal search right Array1: {10, 15, 20, 0, 5}

            if (key >= a[left] && key < a[mid]) {
                return binarySearchRotatedArray(a, left, mid - 1, key); // Search left
            } else {
                return binarySearchRotatedArray(a, mid + 1, right, key); // Search right
            }
        } else if (a[mid] < a[left]) {//right side is normal search left
            if (key > a[mid] && key <= a[right]) {
                return binarySearchRotatedArray(a, mid + 1, right, key); // Search right
            } else {
                return binarySearchRotatedArray(a, left, mid - 1, key); // Search left
            }
        }
        if (a[mid] == a[left]) {// Left or right half is all repeats
            if (a[mid] != a[right]) {
                // If right is different, search it if the left and the middle are identical.
                // In this case, we can check if the rightmost element is different. If it is, we can search just the right side.
                // Array3:  {2, 2, 2, 3, 5, 6}
                return binarySearchRotatedArray(a, mid + 1, right, key); // search right
            } else { // Else, we have to search both halves Array4:  {2, 2, 2, 3, 5, 2}
                int result = binarySearchRotatedArray(a, left, mid - 1, key); // Search left
                if (result == -1) {
                    return binarySearchRotatedArray(a, mid + 1, right, key); // Search right
                } else {
                    return result;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] rotatedArray1 = {10, 15, 20, 0, 5};
        int[] rotatedArray2 = {50, 5, 20, 30, 40};
        int[] rotatedArray3 = {2, 2, 2, 3, 5, 6};
        int[] rotatedArray4 = {2, 2, 2, 3, 5, 2};
        int[] rotatedArray5 = {2, 2, 2, 2, 2, 2};

        System.out.println(binarySearchRotatedArray(rotatedArray1, 5));
        System.out.println(binarySearchRotatedArray(rotatedArray2, 5));
        System.out.println(binarySearchRotatedArray(rotatedArray3, 5));
        System.out.println(binarySearchRotatedArray(rotatedArray4, 5));
        System.out.println(binarySearchRotatedArray(rotatedArray5, 5));

        int[] sortedArray = {1, 2, 3, 4, 5};
        System.out.println(binarySearch(sortedArray, 1));
        System.out.println(binarySearch(sortedArray, 4));
        System.out.println(binarySearch(sortedArray, 5));
        System.out.println(binarySearch(sortedArray, 8));
    }
}

