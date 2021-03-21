package hackerrank.strings;

import java.util.HashSet;
import java.util.Set;

public class TwoCharacters {
    //i 2
    // beabeefeab
    // bebeeeb
    //be bbeefeab
    // set b e a
    //###bee#eab
    static int alternate(String s) {
        StringBuilder sb = new StringBuilder(s);
        Set<Character> set = new HashSet<>();
        int i = 0;
        while (true) {
            if (set.size() == 2) break;
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
                i++;
            }
        }

        while (i < s.length()) {
            if (!set.contains(s.charAt(i))) {
                sb.setCharAt(i, '#');
            }
            i++;
        }
        for (int j = 0; j < sb.length(); j++) {
            if (sb.charAt(j) == '#') sb.deleteCharAt(j);
        }
        System.out.println(sb.toString());
        return sb.toString().length();

    }

    public static void main(String[] args) {
        System.out.println(alternate("beabeefeab"));
        System.out.println(alternate("asvkugfiugsalddlasguifgukvsa"));
        System.out.println(alternate("beabeefeab"));
        StringBuilder sb;
    }
}
