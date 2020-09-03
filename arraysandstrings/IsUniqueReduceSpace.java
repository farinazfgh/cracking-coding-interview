package arraysandstrings;

public class IsUniqueReduceSpace {
    public static void main(String[] args) {
        int x = 1;
        int y = 10;
        y = x << 1;        // x = x* 2 power of 5
        System.out.println(y);
        y = x << 2;        // x = x* 2 power of 5
        System.out.println(y);
        y = x << 3;        // x = x* 2 power of 5
        System.out.println(y);
        y = x << 4;        // x = x* 2 power of 5
        System.out.println(y);
        y = x << 5;        // x = x* 2 power of 5
        System.out.println(y);
        System.out.println("*************************");
        System.out.println(Character.getNumericValue('z'));
        System.out.println(Character.getNumericValue('a'));
        System.out.println("*************************");
        System.out.println(Character.getNumericValue('Z'));
        System.out.println(Character.getNumericValue('A'));
        System.out.println("*************************");

        System.out.println(Character.getNumericValue('z') - Character.getNumericValue('a') + 1);

    }
}