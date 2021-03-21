package hackerrank.strings;

public class MarsExploration {
    /*
    SOSSPSSQSSOR
    SOSSOT
    SOSSOSSOS
    */
    static int marsExploration(String s) {
        int count = 0;
        if (s == null || s.length() == 0) return 0;
        char[] sos = {'s', 'o', 's'};
        String str = s.toLowerCase();
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (j == 3) j = 0;
            if (str.charAt(i) != sos[j]) count++;
            j++;
        }
        return count;
    }

    public static int countChanges(String message) {
        //to reset the i use i mod length just like matrix rotation, when we reach the end we use mod to go back
        String sos = "SOS";
        int count = 0;
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) != sos.charAt(i % 3)) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        marsExploration("SOSSPSSQSSOR");
    }

}
