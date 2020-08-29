public class LonelyInteger {
    private static int lonelyInteger(int[] array) {
        int result = 0;
        for (int value : array) {
            result ^= value;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array1 = {1, 1};
        int[] array2 = {1, 1, 1};
        int[] array3 = {1, 2};
        int[] array4 = {1, 2, 3};
        int[] array5 = {1, 2, 3, 2, 1};
        System.out.println(lonelyInteger(array1));
        System.out.println(lonelyInteger(array2));
        System.out.println(lonelyInteger(array3));
        System.out.println(lonelyInteger(array4));
        System.out.println(lonelyInteger(array5));
    }
}
