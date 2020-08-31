public class OneWay1 {
    boolean oneEditAway(String first, String second) {
        if (first.length() == second.length()) {
            return oneReplace(first, second);
        } else if (first.length() + 1 == second.length()) {
            return onelnsert(first, second);
        } else if (first.length() - 1 == second.length()) {
            return onelnsert(second, first);
        }
        return false;
    }

    boolean oneReplace(String s1, String s2) {
        boolean foundDifference = false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (foundDifference) {
                    return false;
                }
                foundDifference = true;
            }
        }
        return true;
    }

    /* Check if you can insert a character into s1 to make s2. */
    boolean onelnsert(String shorter, String longer) {
        int index1 = 0;
        int index2 = 0;
        while (index2 < longer.length() && index1 < shorter.length()) {
            if (shorter.charAt(index1) == longer.charAt(index2)) {
                index1++;
                index2++;
            } else {
                if (index1 != index2) {
                    return false;
                }
                index2++;
            }
        }
        return true;
    }
}
