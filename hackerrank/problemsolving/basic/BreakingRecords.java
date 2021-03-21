package hackerrank.problemsolving.basic;

public class BreakingRecords {
    static int[] breakingRecords(int[] scores) {
        int minimum = Integer.MAX_VALUE, maximum = Integer.MIN_VALUE, min = -1, max = -1;
        for (int score : scores) {
            if (score < minimum) {
                minimum = score;
                min++;
            }

            if (score > maximum) {
                maximum = score;
                max++;
            }
        }
        int[] result = new int[2];
        result[0] = max;
        result[1] = min;
        return result;
    }
}
