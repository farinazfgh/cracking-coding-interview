package topkelements;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/*
every problem that asks us to find the
    1. top
    2. smallest
    3. frequent ‘K’
can be solved with heap.

As discussed above, it will take us O(logK)to extract the minimum number from the min-heap.
So the overall time complexity of our algorithm will be O(K*logK+(N-K)*logK) since,
first, we insert ‘K’ numbers in the heap and then iterate through the remaining numbers and at every step,
in the worst case, we need to extract the minimum number and insert a new number in the heap.
This algorithm is better than O(N*logN).

Time complexity #
The time complexity of this algorithm is O(K*logK+(N-K)*logK), which is asymptotically equal to O(N∗logK)

Space complexity #
The space complexity will be O(K) since we need to store the top ‘K’ numbers in the heap.
 */
public class KLargestNumbers {
    static List<Integer> findKLargestNumbers(int[] array, int k) {
        List<Integer> result = new ArrayList<>();
        //this one is the default and minHeap, maxHeap will be  new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);
        for (int value : array) {
            minHeap.offer(value);
            if (minHeap.size() > k) minHeap.poll();
        }
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll());
        }
        return result;
    }

    static List<Integer> findKSmallestNumbers(int[] array, int k) {
        List<Integer> result = new ArrayList<>();
        //this one is the default and minHeap, maxHeap will be  new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int value : array) {
            maxHeap.offer(value);
            if (maxHeap.size() > k) maxHeap.poll();
        }
        while (!maxHeap.isEmpty()) {
            result.add(maxHeap.poll());
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> result = KLargestNumbers.findKLargestNumbers(new int[]{3, 1, 5, 12, 2, 11}, 3);
        System.out.println("Here are the top K numbers: " + result);

        result = KLargestNumbers.findKLargestNumbers(new int[]{5, 12, 11, -1, 12}, 3);
        System.out.println("Here are the top K numbers: " + result);

        result = KLargestNumbers.findKSmallestNumbers(new int[]{3, 1, 5, 12, 2, 11}, 3);
        System.out.println("Here are the top K numbers: " + result);

        result = KLargestNumbers.findKSmallestNumbers(new int[]{5, 12, 11, -1, 12}, 3);
        System.out.println("Here are the top K numbers: " + result);
    }
}
