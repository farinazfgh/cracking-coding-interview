package mathandstats;

public class FactorialZeros {

    static int countFactZeros(int num) {
        int count = 0;
        for (int i = 2; i <= num; i++) {
            count += factorsOf5(i);
        }
        return count;
    }

    static int factorsOf5(int i) {
        int count = 0;
        while (i % 5 == 0) {
            count++;
            i /= 5;
        }
        return count;
    }

    static int countFactZerosII(int num) {
        int count = 0;
        if (num < 0) {
            return -1;
        }
        for (int i = 5; num / i > 0; i *= 5) {
            count += num / i;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countFactZeros(5));
        System.out.println(countFactZeros(10));
        System.out.println(countFactZeros(15));
        System.out.println(countFactZeros(20));
        System.out.println(countFactZeros(25));
    }

}
