package arraysandstrings;

public class OneWay2 {
    boolean oneEditAway(String first, String second) {
        /* Length checks. */
        if (Math.abs(first.length() - second.length()) > 1) {
            return false;
        }
        /* Get shorter and longer string.*/
        String shorter = first.length() < second.length() ? first : second;
        String longer = first.length() < second.length() ? second : first;

        boolean foundDifference = false;
        int index1 = 0;
        int index2 = 0;
        while (index2 < longer.length() && index1 < shorter.length()) {
            if (shorter.charAt(index1) != longer.charAt(index2)) {
                /* Ensure that this is the first difference found. */
                if (foundDifference) return false;
                foundDifference = true;
                if (shorter.length() == longer.length()) { //On replace, move shorter pointer
                    index1++;
                }
            } else {
                index1++; // If matching, move shorter pointer
            }
            index2++;// Always move pointer for longer string
        }
        return true;
    }
}
