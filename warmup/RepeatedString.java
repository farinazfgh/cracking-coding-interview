package warmup;

public class RepeatedString {
    /*
    There is a string, s, of lowercase English letters that is repeated infinitely many times.
    Given an integer, n , find and print the number of letter a's in the first  letters of the infinite string.
    abaabaabaa

    numberofAS = 2;
    howManySinN = 10/3 = 3
    numberofAinS 3*2=6
    10%3 =
    10-1=9

     */

    /*
    beware of integer overflow when the problem says big number large number dont take an int
    take int except for the loop indexes.
     */
    static long countA(String s) {
        int numberofAS = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') numberofAS++;
        }
        return numberofAS;
    }

    static long repeatedString(String s, long n) {

        if (s == null || s.length() == 0) return 0;

        long numberOfAsInS = countA(s);

        if (numberOfAsInS == 0) return 0;

        long howManySFits = n / s.length();

        numberOfAsInS = howManySFits * numberOfAsInS;

        long remain = n % (s.length());
        for (int i = 0; i < remain; i++)
            if (s.charAt(i) == 'a') numberOfAsInS++;
        return numberOfAsInS;
    }

    public static void main(String[] args) {
        System.out.println(
                repeatedString("ojowrdcpavatfacuunxycyrmpbkvaxyrsgquwehhurnicgicmrpmgegftjszgvsgqavcrvdtsxlkxjpqtlnkjuyraknwxmnthfpt",
                        685118368975L));
    }

}
