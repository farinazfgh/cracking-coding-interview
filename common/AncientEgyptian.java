package common;

public class AncientEgyptian {
    static int multiply(int a, int b) {
        int x = a, y = b, sum = 0;
        while (x > 0) {
            if (x % 2 == 1) sum = sum + y;//add only if odd
            y <<= 1;//y=y*2
            x >>= 1;//x=x/2;
        }
        return sum;
    }

    int multiplyRecursive(int a, int b) {
        if (a == 0) return 0;
        if (a % 2 == 0) return (2 * multiplyRecursive(a / 2, b));
        return b + 2 * multiplyRecursive((a - 1) / 2, b);
    }
}
