package recursiondynamicprogramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SmallestDifference {
    static int numberOfRecursiveCalls = 0;//503;

    static int findSmallestDifferencDP(int[] array1, int[] array2, int index1, int index2, int minDiff, Map<String, Integer> cache) {
        numberOfRecursiveCalls++;
        if (array1.length == 0 || array2.length == 0) return 0;
        //base case
        if (index1 == array1.length || index2 == array2.length) return minDiff;//minDiff
        String key = index1 + "#" + index2 + "#" + minDiff;
        if (cache.get(key) != null) return cache.get(key);
        int min = Math.abs(array1[index1] - array2[index2]);
        if (min < minDiff) minDiff = min;

        //include

        int min1 = findSmallestDifferencDP(array1, array2, index1, index2 + 1, minDiff, cache);
        int min2 = findSmallestDifferencDP(array1, array2, index1 + 1, index2, minDiff, cache);
        int finalMin = Math.min(min1, Math.min(min1, min2));
        cache.put(key, finalMin);
        return finalMin;
    }

    int findSmallestDifference(int[] array1, int[] array2) {
        if (array1.length == 0 || array2.length == 0) return -1;
        int min = Integer.MAX_VALUE;
        for (int value1 : array1) {
            for (int value2 : array2) {
                if (Math.abs(value1 - value2) < min) {
                    min = Math.abs(value1 - value2);
                }
            }
        }
        return min;
    }

    static int findSmallestDifferenceoptimal(int[] array1, int[] array2) {
        /*
    A: {1, 2, 11, 15}
    B: {4, 12, 19, 23, 127, 235}
         */
        Arrays.sort(array1);
        Arrays.sort(array2);
        int pointer1 = 0;
        int pointer2 = 0;
        int min = Math.abs(array1[pointer1] - array2[pointer2]);
        while (pointer1 < array1.length && pointer2 < array2.length) {
            if (array1[pointer1] > array2[pointer2]) {
                pointer2++;
            } else {
                pointer1++;
            }
            min = Math.min(min, Math.abs(array1[pointer1] - array2[pointer2]));
        }
        /*
        O(A log A + B log B) timetosortandO(A + B) time to find the minimum difference.
        Therefore, the overall runtime is 0 (A log A + B log B).
         */
        return min;
    }

    public static void main(String[] args) {
        int[] array1 = {1, 3, 15, 11, 2};
        int[] array2 = {23, 127, 235, 19, 8};
        Map<String, Integer> cache = new HashMap<>();
        System.out.println(findSmallestDifferencDP(array1, array2, 0, 0, Integer.MAX_VALUE, cache));
        System.out.println(numberOfRecursiveCalls);
        int[] A = {1, 2, 11, 15};
        int[] B = {4, 12, 19, 23, 127, 235};
        System.out.println(findSmallestDifferenceoptimal(A, B));

    }
}

