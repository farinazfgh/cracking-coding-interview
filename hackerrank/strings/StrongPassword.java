package hackerrank.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StrongPassword {
    //if password is less than 6 character then diff=6-n
    //count number of digits, lower cases, upper cases and specials
    //return the max
    static boolean isDigit(char ch) {
        int i = (ch - '0');

        return (i >= 0 && i <= 9);

    }

    static boolean isLowerCase(char ch) {
        int i = (ch - 'a');
        return (i >= 0 && i <= 26);
    }

    static boolean isUppserCase(char ch) {
        int i = (ch - 'A');
        return (i >= 0 && i <= 26);
    }

    static boolean isSpecialChar(char ch) {
        return switch (ch) {
            case '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '+' -> true;
            default -> false;
        };

    }

    // Complete the minimumNumber function below.
    static int minimumNumber(int n, String password) {
        if (password == null || password.length() == 0) return n;
        // Return the minimum number of characters to make the password strong
        int diff = n - password.length();
        if (diff != 0) return diff;
        char[] array = password.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        map.put('d', 0);
        map.put('l', 0);
        map.put('u', 0);
        map.put('s', 0);

        for (char ch : array) {
            if (isDigit(ch)) {
                int temp = map.get('d');
                temp++;
                map.put('d', temp);
            } else if (isLowerCase(ch)) {
                int temp = map.get('l');
                temp++;
                map.put('l', temp);

            } else if (isUppserCase(ch)) {
                int temp = map.get('u');
                temp++;
                map.put('u', temp);

            } else if (isSpecialChar(ch)) {
                int temp = map.get('s');
                temp++;
                map.put('s', temp);
            }
        }
        int count = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 0) count++;
        }

        return Math.max(6 - n, count);
    }

    static int countchars(String password, String patternStr) {
        int count = 0;
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(password);
        while (matcher.find()) count++;
        return count;
    }

    static void minimumNumberReg(int n, String password) {
        System.out.println("digits:" + countchars(password, "[0-9]"));
        System.out.println("lower:" + countchars(password, "[a-z]"));
        System.out.println("upper:" + countchars(password, "[A-Z]"));
        System.out.println("special:" + countchars(password, "!@#$%^&*()-+"));
    }

    public static void main(String[] args) {
        minimumNumberReg(100, "G0N1+93Gy0C!J4ECIc53+30O9az$K-TgDO^051y2+Qfvt94qI!k)lS(-8g65^A9mt%eRL5WP#f8R)i4O33j#&LNk6H%-pr-@d^*Z");
        System.out.println("======================");
        minimumNumberReg(100, "A**U&UDJ(LWL*OBCFD!%+BCKJ(%)FD)%!Q^GW!)Q$^&Z#-H-%)D+XD&#RU-)FK#FW)T(B*U$!-S&D@%*$)BBMTEJ%^KR!$$FACHR");
    }
}
