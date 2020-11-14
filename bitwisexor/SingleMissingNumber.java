package bitwisexor;

public class SingleMissingNumber {
    // O(1) space complexity and O(n) time complexity. however,  we can get integer overflow when n is large.
    static int findMissingNumber(int[] array) {

        int n = array.length;
        int sumOfAll = ((n + 1) * (n + 2)) / 2;
        int sum = 0;
        for (int value : array) {
            sum += value;
        }
        return (sumOfAll - sum);
    }

    public static int findMissingNumberXOR(int[] arr) {
        int n = arr.length + 1;
        // find sum of all numbers from 1 to n.
        int x1 = 1;
        for (int i = 2; i <= n; i++)
            x1 = x1 ^ i;

        // x2 represents XOR of all values in arr
        int x2 = arr[0];
        for (int i = 1; i < n - 1; i++)
            x2 = x2 ^ arr[i];
        System.out.println(x1);
        System.out.println(x2);
        // missing number is the xor of x1 and x2
        return x1 ^ x2;
    }

    public static void main(String[] args) {

        int[] array = {1, 2, 3, 6, 4, 7, 8};
        System.out.println(findMissingNumber(array));
        System.out.println("*****************************'");
        System.out.println(findMissingNumberXOR(array));
    }
}