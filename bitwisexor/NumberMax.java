package bitwisexor;

public class NumberMax {
    /* Flips a 1 to a 0 and a 0 to a 1 */
    int flip(int bit) {

        return 1 ^ bit;
    }


    int sign(int a) {
        return flip((a >> 31) & 0x1);
    }

    int getMaxNaive(int a, int b) {
        int k = sign(a - b);
        int q = flip(k);
        return a * k + b * q;
    }

    int getMax(int a, int b) {
        int c = a - b;


        int sa = sign(a);//if a >= 0, then 1 else 0
        int sb = sign(b);//if b >= 0, then 1 else 0
        int sc = sign(c);//depends on whether or not a -b overflows




        /* Goal:define a value k whieh is 1 if a > band 0 a<b
         * ( if a = b, it doesn 't matter what value k i s ) */

        // If a and b have different signs, then k=sign(a)
        int use_sign_of_a = sa ^ sb;
        // If a and b have different signs, then k =   sign(a)


//if a and b have the same sign then k=sign(a-b);
        int use_sign_of_c = flip(sa ^ sb);
        int k = use_sign_of_a * sa + use_sign_of_c * sc;
        int q = flip(k);// II opposite of k
        return a * k + b * q;
    }
}
