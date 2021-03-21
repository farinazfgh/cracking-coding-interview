package hackerrank.problemsolving.basic;

import java.util.Random;

public class BigSortingQuick {
    private static final Random random;    // pseudo-random number generator
    private static final long seed;        // pseudo-random number generator seed

    // static initializer
    static {
        // this is how the seed was set in Java 1.4
        seed = System.currentTimeMillis();
        random = new Random(seed);
    }

    public static void sort(Comparable[] a) {
        shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int lt = lo, gt = hi;
        Comparable v = a[lo];
        int i = lo + 1;
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) exch(a, lt++, i++);
            else if (cmp > 0) exch(a, i, gt--);
            else i++;
        }

        // a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi].
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }

    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static void shuffle(Object[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int r = i + uniform(n - i);     // between i and n-1
            Object temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    public static int uniform(int n) {
        if (n <= 0) throw new IllegalArgumentException("argument must be positive: " + n);
        return random.nextInt(n);
    }


    static String[] bigSorting(String[] unsorted) {

        MyNumber[] list = new MyNumber[unsorted.length];
        for (int i = 0; i < unsorted.length; i++) {
            MyNumber number = new MyNumber(unsorted[i]);
            list[i] = number;
        }
        sort(list);
        for (int i = 0; i < unsorted.length; i++) {
            unsorted[i] = list[i].getNumberStr();
        }
        return unsorted;
    }

    static class MyNumber implements Comparable<MyNumber> {
        final String numberStr;

        MyNumber(String numberStr) {
            this.numberStr = numberStr;
        }

        public String getNumberStr() {
            return numberStr;
        }

        @Override
        public int compareTo(MyNumber str) {

            if (numberStr.length() < str.getNumberStr().length()) return -1;
            if (numberStr.length() > str.getNumberStr().length()) return 1;
            for (int i = 0; i < numberStr.length(); i++) {
                int diff = numberStr.charAt(i) - str.getNumberStr().charAt(i);
                if (diff != 0) return diff;
            }
            return 0;
        }
    }
    public static void main(String[] args) {
        String[] unsorted = {
                "1", "2", "100", "12303479849857341718340192371", "3084193741082937"
                , "3084193741082938", "111", "200"};

        bigSorting(unsorted);
        for (String str : unsorted) {
            System.out.print(str + " , ");
        }

    }

}
