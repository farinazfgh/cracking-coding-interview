package hackerrank.problemsolving.basic;

import java.util.Arrays;
import java.util.List;

public class SubarrayDivision {
    // when you hit the window; apply the logic, remove the windowstart, increment it for next round
    public static int birthdayA(int[] arr, int d, int windowSize) {
        int match = 0;
        int windowSum = 0;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd];
            //windows end reaches the window size; compare
            if (windowEnd >= windowSize - 1) {
                if (windowSum == d) match++;
                windowSum -= arr[windowStart]; // subtract the element going out
                windowStart++; // slide the window ahead
            }
        }

        return match;
    }

    public static int birthday(List<Integer> arr, int d, int m) {
        int match = 0;
        int windowSum = 0;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < arr.size(); windowEnd++) {
            windowSum += arr.get(windowEnd); // add the next element
            // slide the window, we don't need to slide if we've not hit the required window size of 'k'
            if (windowEnd >= m - 1) {
                if (windowSum == d) match++;
                windowSum -= arr.get(windowStart); // subtract the element going out
                windowStart++; // slide the window ahead
            }
        }

        return match;
    }

    public static void main(String[] args) {
        int[] list = {2, 3, 4, 4, 2, 1, 2, 5, 3, 4, 4, 3, 4, 1, 3, 5, 4, 5, 3, 1, 1, 5, 4, 3, 5, 3, 5, 3, 4, 4, 2, 4, 5, 2, 3, 2, 5, 3, 4, 2, 4, 3, 3, 4, 3, 5, 2, 5, 1, 3, 1, 4, 2, 2, 4, 3, 3, 3, 3, 4, 1, 1, 4, 3, 1, 5, 2, 5, 1, 3, 5, 4, 3, 3, 1, 5, 3, 3, 3, 4, 5, 2};
        System.out.println(birthdayA(list, 26, 8));
        int[] list2 = {2, 5, 1, 3, 4, 4, 3, 5, 1, 1, 2, 1, 4, 1, 3, 3, 4, 2, 1};
        System.out.println(birthdayA(list2, 18, 7));
        System.out.println(birthday(Arrays.asList(2, 5, 1, 3, 4, 4, 3, 5, 1, 1, 2, 1, 4, 1, 3, 3, 4, 2, 1), 18, 7));
    }
}
