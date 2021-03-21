package hackerrank.strings;

public class SuperReducedString {
    static String superReducedString(String s) {
        String reducedStr = reduce(s);
        while (reducedStr.length() < s.length()) {
            s = reducedStr;
            reducedStr = reduce(reducedStr);
        }
        return reducedStr;
    }

    static String reduce(String s) {
        if (s == null || s.length() == 0) return "Empty String";
        if (s.length() == 1) return s;
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                count++;
            } else {
                if (count % 2 == 1) sb.append(s.charAt(i));
                count = 1;
            }
        }
        if (count % 2 == 1) sb.append(s.charAt(s.length() - 1));
        return sb.toString();
    }

    public static void main(String[] args) {
        //i<8 i=7
        System.out.println(superReducedString("aaabccddd"));
        System.out.println(superReducedString("aab"));
        System.out.println(superReducedString("abba"));
    }

}
