
public class OneAway {
    static boolean isOneAway(String greater, String smaller) {
        System.out.println(greater + "," + smaller);
        if (Math.abs(greater.length() - smaller.length()) >= 2) return false;
        int diff = 0;
        for (int i = 0, j = 0; j < smaller.length(); i++, j++) {
            System.out.println(greater.charAt(i));
            System.out.println(smaller.charAt(j));
            System.out.println("*****************");
            if (greater.charAt(i) != smaller.charAt(j)) {
                diff++;
                if (diff > 2) return false;
                if (((greater.charAt(i + 1) != smaller.charAt(j))) && (greater.charAt(i) != smaller.charAt(j + 1))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
      //  System.out.println(isOneAway("pale", "ple"));
        //System.out.println(isOneAway("pales", "pale"));
        System.out.println(isOneAway("pale", "bale"));
        System.out.println(isOneAway("pale", "bae"));
    }
}
