package bitwisexor;

import java.util.HashSet;
import java.util.Set;

public class SingleNumberBetweenDuplicates {
    /*
    Time and space complexity Time Complexity of the above solution will be O(n) and space complexity will also be O(n).
     */
    static int findSingleNumber(int[] array) {
        Set<Integer> set = new HashSet<>();
        int singleNumber = -1;
        for (int value : array) {
            if (set.add(value)) singleNumber = value;
        }
        return singleNumber;
    }

    /*
    Time Complexity: Time complexity of this solution is O(n) as we iterate through all numbers of the input once.
    Space Complexity: The algorithm runs in constant space O(1).
     */
    static int findSingleNumberXOR(int[] array) {
        int result = 0;
        for (int value : array) {
            result ^= value;
        }
        System.out.println(result);
        return result;

    }

    public static void main(String[] args) {
        int[] arr1 = {1, 4, 2, 1, 3, 2, 3};
        int[] arr2 = {1, 1,};
        int[] arr3 = {1, 1, 1};
        int[] arr4 = {1};
        System.out.println(findSingleNumber(arr1));
        System.out.println(findSingleNumber(arr2));
        System.out.println(findSingleNumber(arr3));
        System.out.println(findSingleNumber(arr4));
        System.out.println("***************************");
        System.out.println(findSingleNumberXOR(arr1));
        System.out.println(findSingleNumberXOR(arr2));
        System.out.println(findSingleNumberXOR(arr3));
        System.out.println(findSingleNumberXOR(arr4));
    }
}
