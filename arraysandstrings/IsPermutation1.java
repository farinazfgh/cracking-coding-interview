package arraysandstrings;

public class IsPermutation1 {
    boolean isPermutation(String str1, String str2) {
        if (str1.length() != str2.length()) return false;
        return sort(str1).equals(str2);
    }

    String sort(String s) {
        //find the best way to sort an array of chatacters in java
        //they are the same length so we can use radix, MSD, LSD
        return "";
    }
}
