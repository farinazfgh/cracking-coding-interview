package TwoPointers;

import java.util.ArrayList;
import java.util.List;

public class PairWithTargetSum {

    List<Integer[]> bruteForceSearch(int[] array, int target) {
        List<Integer[]> results = new ArrayList();

        for (int j : array) {
            if (binarySearch(array, target - j) != -1) {
                Integer[] result = new Integer[2];
                result[0] = j;
                result[1] = target - j;
                results.add(result);
            }
        }
        return results;

    }

    int binarySearch(int[] array, int key) {
        return binarySearch(array, 0, array.length - 1, key);
    }

    int binarySearch(int[] array, int low, int high, int key) {
        if (low > high) return -1;
        int mid = (low + high) / 2;
        if (array[mid] == key) return mid;
        if (key < array[mid]) return binarySearch(array, low, mid - 1, key);
        else return binarySearch(array, mid + 1, high, key);
    }

    List<Integer[]> search(int[] array, int target) {
        List<Integer[]> results = new ArrayList();

        int startPointer = 0;
        int endPointer = array.length - 1;
        int mid = (startPointer + endPointer) / 2;

        while (startPointer <= mid && endPointer >= mid) {
            if (array[startPointer] + array[endPointer] == target) {
                Integer[] result = new Integer[2];
                result[0] = array[startPointer];
                result[1] = array[endPointer];
                results.add(result);
                startPointer++;
                endPointer--;
                continue;
            }
            if (array[startPointer] + array[endPointer] > target) endPointer--;

            else startPointer++;

        }
        return results;
    }

    public static void main(String[] args) {
        PairWithTargetSum pairWithTargetSum = new PairWithTargetSum();
        int[] array1 = {1, 2, 3, 4, 6};
        int[] array2 = {2, 5, 9, 11};
        int[] array3 = {1, 3, 5, 7, 9, 11, 13, 15, 17};
        pairWithTargetSum.printArray(pairWithTargetSum.bruteForceSearch(array1, 6));
        pairWithTargetSum.printArray(pairWithTargetSum.bruteForceSearch(array2, 11));
        pairWithTargetSum.printArray(pairWithTargetSum.bruteForceSearch(array3, 16));
        System.out.println();
        pairWithTargetSum.printArray(pairWithTargetSum.search(array1, 6));
        pairWithTargetSum.printArray(pairWithTargetSum.search(array2, 11));
        pairWithTargetSum.printArray(pairWithTargetSum.search(array3, 16));
    }

    void printArray(List<Integer[]> array) {
        for (Integer[] a : array) {
            System.out.print(" [ " + a[0] + " , " + a[1] + " ] ");
        }
        System.out.println();
    }
}