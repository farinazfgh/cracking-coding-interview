package hackerrank.interview;

import java.util.Arrays;

public class BigSorting {
    static String[] bigSorting(String[] unsorted) {
        Arrays.sort(unsorted, (s1, s2) -> {
            if (s1.length() == s2.length()) return s1.compareTo(s2);
            return (s1.length() - s2.length());
        });
        return unsorted;
    }
}
