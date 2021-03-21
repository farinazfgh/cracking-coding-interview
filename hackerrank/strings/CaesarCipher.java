package hackerrank.strings;

public class CaesarCipher {
    static String shift(int k) {
        String s = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        for (int i = k; i < s.length(); i++) {
            sb.append(s.charAt(i));
        }
        for (int i = 0; i < k; i++) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }


    static char getChar(char ch, int k) {
        int diff = ch + k;
        if (diff <= 122) return (char) diff;
        return (char) (diff - 26);
    }

    static boolean isAlphabet(char c) {
        return ((int) c <= 122 && (int) c >= 97) || ((int) c <= 90 && (int) c >= 65);
    }

    static String caesarCipher(StringBuilder s, int k) {
        k %= 26;

        for (int i = 0; i < s.length(); i++) {
            int a = (s.charAt(i));

            if ((a >= 65 && a <= 90)) {//A-Z
                if (a + k > 90)
                    s.setCharAt(i, (char) (k - Math.abs(a - 90) + 64));
                else
                    s.setCharAt(i, (char) (a + k));
            } else if ((a >= 97 && a <= 122)) {//a-z
                if (a + k > 122)
                    s.setCharAt(i, (char) (k - Math.abs(a - 122) + 96));
                else//others
                    s.setCharAt(i, (char) (a + k));
            }
        }
        return s.toString();
    }

    static String caesarCipherOnlyLetters(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            if (isAlphabet(s.charAt(i)))
                sb.setCharAt(i, getChar(s.charAt(i), k));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s1 = "1X7T4VrCs23k4vv08D6yQ3S19G4rVP188M9ahuxB6j1tMGZs1m10ey7eUj62WV2exLT4C83zl7Q80M";
        //1Y7U4WsDt23l4ww08E6zR3T19H4sWQ188N9bivyC6k1uNHAt1n10fz7fVk62XW2fyMU4D83am7R80N
        String s2 = "6DWV95HzxTCHP85dvv3NY2crzt1aO8j6g2zSDvFUiJj6XWDlZvNNr";
        //6MFE95QigCLQY85mee3WH2laic1jX8s6p2iBMeODrSs6GFMuIeWWa
        String s3 = "DNFjxo?b5h*5<LWbgs6?V5{3M].1hG)pv1VWq4(!][DZ3G)riSJ.CmUj9]7Gzl?VyeJ2dIPEW4GYW*scT8(vhu9wCr]q!7eyaoy.";
        System.out.println(caesarCipher(new StringBuilder(s1), 27));
        System.out.println(caesarCipher(new StringBuilder(s2), 87));
        System.out.println(caesarCipher(new StringBuilder(s3), 45));

    }
}
