package common;

public class AncientEgyptian {
    static int func(int a, int b) {
        int x = a, y = b, z = 0;
        while (x > 0) {
            if (x % 2 == 1) z = z + y;//add only if odd
            y <<= 1;//y=y*2
            x >>= 1;//x=x/2;
        }
        return z;
    }
}
