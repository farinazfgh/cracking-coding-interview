package arraysandstrings;

public class IsPermutation2 {
    /*
   abcdefghijklmnopqrstuvwxyz  97 98 99 100 101 102 103 104 105 106 107 108 109 110 111 112 113 114 115 116 117 118 119 120 121 122
   ABCDEFGHIJKLMNOPQRSTUVWXYZ  65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90
   0123456789  48 49 50 51 52 53 54 55 56 57
     */
    static boolean permutation(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        int[] letters = new int[128];   // Assumption


        char[] str1_array = str1.toCharArray();

        for (char ch : str1_array) {
            // count number of each char i n s.
            letters[ch]++;
        }
        printArray(letters);
        //do not count and then compare, count the first one and compare the second as you are counting
        for (int i = 0; i < str2.length(); i++) {
            int ch = str2.charAt(i);
            letters[ch]--;
            if (letters[ch] < 0) {//means it appeared at least once in the second string and it wasn't in the dirst one (letters(ch)=0)
                return false;
            }
        }
        return true;
    }

    private static void printArray(int[] letters) {
        for (int value : letters) System.out.print(value + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println(permutation("ABA", "BAA"));
        System.out.println(permutation("aba", "abb"));
        System.out.println(permutation("aaa", "aaa"));
    }
}
