package modifiedbinarysearch;
/*
Given a sorted array of numbers, find
 if a given number ‘key’ is present in the array.
 Though we know that the array is sorted, we don’t know if it’s sorted in ascending or descending order.
 You should assume that the array can have duplicates.

Write a function to return the index of the ‘key’ if it is present in the array, otherwise return -1.
 */

public class BinarySearchIterative {
    public static int search(int[] array, int key) {
        int start = 0, end = array.length - 1;
        boolean isAscending = (array[start] <= array[end]);
        while ((start <= end)) {
            int mid = start + (end - start) / 2;
            if (key == array[mid]) return mid;

            if (isAscending) {
                if (key < array[mid]) end = mid - 1;
                else start = mid + 1;
            } else {
                if (key > array[mid]) end = mid - 1;
                else start = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(BinarySearchIterative.search(new int[]{4, 6, 10}, 10));
        System.out.println(BinarySearchIterative.search(new int[]{1, 2, 3, 4, 5, 6, 7}, 5));
        System.out.println(BinarySearchIterative.search(new int[]{10, 6, 4}, 10));
        System.out.println(BinarySearchIterative.search(new int[]{10, 6, 4}, 4));
    }
}
/*
 * Lessons learned:
 * dont add start+end and then divide by 2 it can cause integer overflow. start+ (end-start)/2
 * check if array is ascending or descending
 * do it in an iterative way instead of recursive
 * time complexity: O(log n)
 * space complexity O(1)
 * */