package sortingsearching;

import java.util.Arrays;

public class CompleteAbsoluteDifference {
    // O(n^2)
    static int minimumAbsoluteDifferenceBF(int[] arr) {
        //-59 -36 -13 1 -53 -92 -2 -96 -54 75
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++)
            for (int j = i + 1; j < arr.length; j++) {
                int diffAbs = Math.abs(arr[i] - arr[j]);
                if (diffAbs < min) min = diffAbs;
            }

        return min;
    }

    // O(nlogn)
    static int minimumAbsoluteDifference(int[] arr) {
        //-59 -36 -13 1 -53 -92 -2 -96 -54 75
        int min = Integer.MAX_VALUE;
        Arrays.sort(arr);
        //-96 -92 -59 -54 -53 -36 -13  -2  1 75

        for (int i = 1; i < arr.length; i++) {
            int diffAbs = Math.abs(arr[i] - arr[i - 1]);
            if (diffAbs < min) min = diffAbs;
        }
        return min;
    }

}
