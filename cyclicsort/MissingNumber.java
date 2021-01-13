package cyclicsort;

public class MissingNumber {

    //‘n’ distinct numbers taken from the range 0 to ‘n’.
    public static int findMissingNumber(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;

        }
        int n = nums.length;

        return ((n * (n + 1) / 2) - sum);
    }

    public static int findMissingNumberCyclicSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) swap(nums, i, nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) return i;
        }
        return nums.length;//all in place so the missing number was the last one
    }

    static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void main(String[] args) {
        System.out.println(findMissingNumber(new int[]{4, 0, 3, 1}));
        System.out.println(findMissingNumber(new int[]{8, 3, 5, 2, 4, 6, 0, 1}));
    }
}
