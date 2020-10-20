package slidingwindow;

import java.util.ArrayList;
import java.util.List;

public class AverageOfSubarrayOfSizeK {
    static int[] array = {1, 3, 2, 6, -1, 4, 1, 8, 2};
    static int windowSize = 5;
    static List<Double> averages = new ArrayList<>();

    static List<Double> averageOnSquared(int[] array, int windowSize) {
        for (int i = 0; i <= array.length - windowSize; i++) {
            double avg = 0.0;
            for (int j = i; j < windowSize + i; j++) {
                avg += array[j];
            }
            averages.add((avg / windowSize));
        }
        return averages;
    }

    public static List<Double> findAveragesOn(int[] arr, int K) {
        List<Double> result = new ArrayList<>();
        double windowSum = 0;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd]; // add the next element
            // slide the window, we don't need to slide if we've not hit the required window size of 'k'
            if (windowEnd >= K - 1) {
                result.add(windowSum / K); // calculate the average
                windowSum -= arr[windowStart]; // subtract the element going out
                windowStart++; // slide the window ahead
            }
        }

        return result;
    }


    public static void main(String[] args) {
        System.out.println(averageOnSquared(array, windowSize));
        System.out.println(findAveragesOn(array, windowSize));
    }

    public static double[] findAverages(int K, int[] arr) {
        double[] result = new double[arr.length - K + 1];
        for (int i = 0; i <= arr.length - K; i++) {
            // find sum of next 'K' elements
            double sum = 0;
            for (int j = i; j < i + K; j++)
                sum += arr[j];
            result[i] = sum / K; // calculate average
        }

        return result;
    }
}
