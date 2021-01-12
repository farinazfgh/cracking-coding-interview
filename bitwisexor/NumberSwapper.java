package bitwisexor;

public class NumberSwapper {
    /*
       static void swapIntBitwise(int a, int b) {
           System.out.println("a:" + a + ", b:" + b);
           a = a ^ b;
           b = a ^ b;
           System.out.println("a:" + a + ", b:" + b);
       }
   */
    static void swapInt(int a, int b) {
        System.out.println("a:" + a + ", b:" + b);
        a = a - b;
        b = a + b;
        a = b - a;
        System.out.println("a:" + a + ", b:" + b);
    }

    public static void main(String[] args) {
//        swapIntBitwise(10, 23);
        swapInt(10, 23);
    }
}
