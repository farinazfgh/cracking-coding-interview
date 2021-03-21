package hackerrank.strings;

public class ASCIIofAllCharacters {
    public static void main(String[] args) {
        for (int i = 0; i <= 255; i++) {
            System.out.println("" + (char) i + ": " + i);
        }
    }
}
