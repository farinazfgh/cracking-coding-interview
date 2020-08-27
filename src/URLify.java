public class URLify {
    static int getCountOfSpaces(String str) {
        int count = 0;
        char[] letters = str.toCharArray();
        for (char ch : letters) {
            if (ch == ' ') count++;

        }
        return count;
    }

    //farinaz likes coding %20
    static String replaceSpaces(String str) {
        char[] temp = new char[getCountOfSpaces(str) * 3 + str.length()];
        int j = temp.length - 1;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == ' ') {
                temp[j] = '0';
                temp[j - 1] = '2';
                temp[j - 2] = '%';
                j = j - 3;
            } else {
                temp[j] = str.charAt(i);
                j--;
            }
        }
        return new String(temp);
    }

    public static void main(String[] args) {
        System.out.println(replaceSpaces("farinaz like coding"));
        System.out.println(replaceSpaces("farinaz like coding "));
        System.out.println(replaceSpaces(" farinaz like coding"));
        System.out.println(replaceSpaces("farinazlikecoding"));
        System.out.println(replaceSpaces(""));
    }
}
