package sortingsearching;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

//O (n log (n) )
class AnagramComparatorG implements Comparator<String> {
    public String sortChars1(String s) {
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

    public int compare(String sl, String s2) {
        return sortChars(sl).compareTo(sortChars(s2));
    }

    void sort(String[] array) {
        HashMapList<String, String> mapList = new HashMapList<>();
        /* Group words by anagram */
        for (String s : array) {
            String key = sortChars(s);
            mapList.put(key, s);
        }
        /* Convert hash table to array */
        int index = 0;
        for (String key : mapList.keySet()) {
            ArrayList<String> list = mapList.get(key);
            for (String t : list) {
                array[index] = t;
                index++;
            }
        }
    }

    String sortChars(String s) {

        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }
}
