package hackerrank.problemsolving.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class BigSorting {
    //todo failed for one test case time exceeded
    //https://medium.com/swlh/slow-sorting-and-big-o-notation-aa31631ceacb
    //try fork join later
    static class MyNumber implements Comparable<MyNumber> {
        final String numberStr;

        MyNumber(String numberStr) {
            this.numberStr = numberStr;
        }

        public String getNumberStr() {
            return numberStr;
        }

        @Override
        public int compareTo(MyNumber str) {

            if (numberStr.length() < str.getNumberStr().length()) return -1;
            if (numberStr.length() > str.getNumberStr().length()) return 1;
            for (int i = 0; i < numberStr.length(); i++) {
                int diff = numberStr.charAt(i) - str.getNumberStr().charAt(i);
                if (diff != 0) return diff;
            }
            return 0;
        }
    }

    static String[] bigSorting2(String[] unsorted) {
        List<MyNumber> list = new ArrayList<>();
        for (String s : unsorted) {
            MyNumber number = new MyNumber(s);
            list.add(number);
        }
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            unsorted[i] = list.get(i).getNumberStr();
        }
        return unsorted;
    }

    static String[] bigSorting(String[] unsorted) {
        return Stream.of(unsorted).sorted((str1, str2) -> {
            if (str1.length() < str2.length()) return -1;
            if (str1.length() > str2.length()) return 1;
            for (int i = 0; i < str1.length(); i++) {
                int diff = str1.charAt(i) - str2.charAt(i);
                if (diff != 0) return diff;
            }
            return 0;
        }).toArray(String[]::new);
    }

    static String[] bigSorting3(String[] unsorted) {
        Arrays.sort(unsorted, (x, y) -> x.length() == y.length() ? x.compareTo(y) : Integer.compare(x.length(), y.length()));
        return unsorted;
    }

    public static void main(String[] args) {
        String[] unsorted = {
                "1", "2", "100", "12303479849857341718340192371", "3084193741082937"
                , "3084193741082938", "111", "200"};
        unsorted = bigSorting(unsorted);
        for (String str : unsorted) {
            System.out.print(str + " , ");
        }
        System.out.println();
        String[] unsorted2 = {
                "1", "111", "1111", "2222"};
        unsorted2 = bigSorting(unsorted2);

        for (String str : unsorted2) {
            System.out.print(str + " , ");
        }
        for (String str : unsorted2) {
            System.out.print(str + " , ");
        }
    }
}
