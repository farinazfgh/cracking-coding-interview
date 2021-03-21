package hackerrank.strings;

public class Pangrams {
    static String pangrams(String s) {
        if (s == null || s.length() < 26) return "not pangram";
        int[] radix = new int[128];
        for (int i = 0; i < s.length(); i++) {
            int index = (int) s.charAt(i);
            radix[index]++;
        }
        for (int i = 97; i <= 122; i++) {
            if (radix[i] == 0 && radix[i - 32] == 0) return "not pangram";
        }
        return "pangram";
    }

    public static void main(String[] args) {
        //97-122
        //65-90
        System.out.println(pangrams("We promptly judged antique ivory buckles for the next prize"));
        System.out.println(pangrams("We promptly judged antique ivory buckles for the next"));
    }
}
