package hackerrank.strings;

import java.util.HashMap;
import java.util.Map;

public class HackerRankString {
    static Map<Character, Integer> countCharacters(String s) {
        Map<Character, Integer> countChars = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Integer count = countChars.get(s.charAt(i));
            if (count == null) {
                count = 0;
            } else {
                count++;
            }
            countChars.put(s.charAt(i), count);
        }
        return countChars;
    }

    static String test(String s) {
        Map<Character, Integer> schars = countCharacters(s);
        Map<Character, Integer> hackerrank = countCharacters("hackerrank");
        for (Map.Entry<Character, Integer> entry : hackerrank.entrySet()) {
            Character key = entry.getKey();
            if (!(schars.get(key) >= entry.getValue())) return "NO";
        }
        return "YES";
    }

    // Complete the hackerrankInString function below.

    static String hackerrankInString(String s) {
    /*
    hhaacckkekraraannk
    rhbaasdndfsdskgbfefdbrsdfhuyatrjtcrtyytktjjt
    lastFound=3
    */
        int index = 0;
        char[] hackerrank = "hackerrank".toCharArray();
        for (char ch : hackerrank) {
            int lastFound = s.indexOf(ch, index);
            if (lastFound == -1) return "NO";
            index = lastFound + 1;
        }
        return "YES";
    }
}
