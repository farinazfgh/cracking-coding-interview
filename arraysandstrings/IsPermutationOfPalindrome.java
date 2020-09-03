package arraysandstrings;

public class IsPermutationOfPalindrome {
    boolean isPermutationOfPalindrome(String phrase) {
        int[] table = buildCharFrequencyTable(phrase);
        return checkMaxOneOdd(table);
    }

    /* Count how many times each character appears. */
    int[] buildCharFrequencyTable(String phrase) {
        //assuming it only contains small letters a-z table[26]
        int[] table = (new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1]);
        for (char c : phrase.toCharArray()) {
            int x = getCharNumber(c);
            if (x != -1) {
                table[x]++; //the same approach 26 instead of 256 {extended ascii}
            }
        }
        return table;
    }

    /*
     * Map each character to a number. a -> 0, b - > 1,  c->2, etc.
     * This is case insensitive because getNumericValue('a')==getNumericValue('A')
     * Non-letter characters map to -1.
     */
    int getCharNumber(Character c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);
        if (a <= val && val <= z) {
            return val - a;
        }
        return -1;
    }

    /* Check that no more than one character has an odd count. */
    boolean checkMaxOneOdd(int[] table) {
        boolean foundOdd = false;
        for (int count : table) {
            if (count % 2 == 1) {
                if (foundOdd) {//second odd-> only one odd
                    return false;
                }
                foundOdd = true;
            }
        }
        return true;
    }

    boolean isPermutationOfPalindrome2(String phrase) {
        int countOdd = 0;
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        for (char c : phrase.toCharArray()) {
            int x = getCharNumber(c);
            if (x != -1) {
                table[x]++;
                if (table[x] % 2 == 1) {
                    countOdd++;
                } else {
                    countOdd--;
                }
            }
        }
        return countOdd <= 1;
    }

    public static void main(String[] args) {
        IsPermutationOfPalindrome phrase = new IsPermutationOfPalindrome();
        System.out.println(phrase.isPermutationOfPalindrome("racecar"));
        System.out.println(phrase.isPermutationOfPalindrome("level"));
        System.out.println(phrase.isPermutationOfPalindrome("polaris"));
    }
}
