package sortingsearching;

import java.util.*;

public class GroupAnagrams {
    static void groupAnagrams(List<String> words) {
        Map<String, List<String>> anagramTable = new HashMap<>();

        for (String word : words) {
            char[] sortedWordChar = word.toLowerCase().toCharArray();
            Arrays.sort(sortedWordChar);
            String sortedWord = String.valueOf(sortedWordChar);
            List<String> list = anagramTable.get(sortedWord);
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(word.toLowerCase());
            anagramTable.put(sortedWord, list);
        }
        for (Map.Entry<String, List<String>> entry : anagramTable.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }

    public static void main(String[] args) {
        String[] words = {
                "Elegantman", "WilliamShakespeare's", "Astronomer", "Hamlet", "is", "actually", "an", "Theeyes", "anagram", "of", "Amleth", "Theysee", "Agentleman", "Gulliver", "Gulliver", "visits", "Tribnia", "also", "known", "as", "Langden", "anagrams", "of", "Britain", "and", "England", "respectively", "Listen", "Moonstarer", "Silent"
        };
        groupAnagrams(Arrays.asList(words));
    }
}
