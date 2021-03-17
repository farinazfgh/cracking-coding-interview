package hackerrank.warmup;

public class PlusMinus {
    static void printResult(double p, double n, double z) {
        System.out.println(p);
        System.out.println(n);
        System.out.println(z);
    }

    // Complete the plusMinus function below.
    static void plusMinus(int[] arr) {
        if (arr == null || arr.length == 0) {
            printResult(0.0, 0.0, 0.0);
            return;
        }
        double positives = 0.0;
        double negatives = 0.0;
        double zeros = 0.0;
        for (int value : arr) {
            if (value > 0) positives++;
            else if (value < 0) negatives++;
            else zeros++;
        }
        printResult(positives / arr.length, negatives / arr.length, zeros / arr.length);
    }
}
