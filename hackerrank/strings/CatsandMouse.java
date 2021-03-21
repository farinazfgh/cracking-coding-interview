package hackerrank.strings;

import java.util.SortedSet;

public class CatsandMouse {
    static String catAndMouse(int x, int y, int z) {

        int diff1 = Math.abs(z - x);
        int diff2 = Math.abs(z - y);
        if (diff1 == diff2) {
            return "Mouse C";
        }
        if (diff1 > diff2) return "Cat B";
        return "Cat A";
    }
}
