public class IsUnique {
    //Radix is important in questions as such
    //todo work on char->int int->char
    static boolean isUniqueChars(String str) {
        if (str.length() > 128) return false;

        boolean[] char_set = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (char_set[val]) {
                // II Already found this char in string
                return false;
            }
            char_set[val] = true;
        }
        return true;
    }


    private static final int R = 128;         // the radix of the alphabet

    public static void countSort(String str) {
        int[] count = new int[R];
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i)]++;
        }
        for (int i = 0; i < count.length; i++) {
            int k = count[i];
            if (k > 0) for (int j = 0; j < k; j++) System.out.print((char) i);
        }
        System.out.println();

    }

    public static void main(String[] args) {
        System.out.println(isUniqueChars("farinaz"));
        System.out.println(isUniqueChars("bannanna"));
        System.out.println(isUniqueChars("abcdefg"));
    }
}