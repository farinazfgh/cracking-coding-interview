package arraysandstrings;

public class StringCompressionF {
    static String getCompression(String str) {
        /*
        Dont use "" + = because string concatenation operates in O(n2)
         */
        StringBuilder sb = new StringBuilder();
        char previous = str.charAt(0);
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == previous) {
                count++;
                previous = ch;
            } else {
                sb.append(previous).append(count);
                previous = ch;
                count = 1;
            }
        }
        sb.append(str.charAt(str.length() - 1)).append(count);
        if (sb.toString().length() < str.length()) return sb.toString();
        return str;
    }

    public static void main(String[] args) {
        System.out.println(getCompression("aabcccccaaa"));
        System.out.println(getCompression("farinaz"));
        System.out.println(getCompression("aabccdeeaa"));
        //  System.out.println(getCompression("a2b1c2d1e1a1"));

    }
}
