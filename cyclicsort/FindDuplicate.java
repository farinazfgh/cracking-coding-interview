package cyclicsort;
/*note you should take advatage of the fact that we know (n) and we can solve this O(n)
 Arrays.sort(array) takes o(nlogn)
 although it says that you can modify the array and you can sort you can sort it O(n)
 */

class FindDuplicate {

    public static int findNumber(int[] array) {
        int i = 0;
        while (i < array.length) {
            //to place each number on its correct index.
            if (array[i] != i + 1) {
                if (array[i] != array[array[i] - 1])
                    swap(array, i, array[i] - 1);
                    // Since there is only one duplicate, if while swapping the number with its index both the numbers being swapped are same, we have found our duplicate!
                else return array[i];
            } else {
                i++;
            }
        }

        return -1;
    }

    public static int findDuplicate(int[] arr) {
        int slow = 0, fast = 0;
        do {
            slow = arr[slow];
            fast = arr[arr[fast]];
        } while (slow != fast);

        // find cycle length
        int current = arr[slow];
        int cycleLength = 0;
        do {
            current = arr[current];
            cycleLength++;
        } while (current != arr[slow]);

        return findStart(arr, cycleLength);
    }

    private static int findStart(int[] arr, int cycleLength) {
        int pointer1 = arr[0], pointer2 = arr[0];
        // move pointer2 ahead 'cycleLength' steps
        while (cycleLength > 0) {
            pointer2 = arr[pointer2];
            cycleLength--;
        }

        // increment both pointers until they meet at the start of the cycle
        while (pointer1 != pointer2) {
            pointer1 = arr[pointer1];
            pointer2 = arr[pointer2];
        }

        return pointer1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(FindDuplicate.findDuplicate(new int[]{1, 4, 4, 3, 2}));
        System.out.println(FindDuplicate.findDuplicate(new int[]{2, 1, 3, 3, 5, 4}));
        System.out.println(FindDuplicate.findDuplicate(new int[]{2, 4, 1, 4, 4}));
    }
}
