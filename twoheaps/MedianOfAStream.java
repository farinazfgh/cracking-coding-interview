package twoheaps;

import java.util.PriorityQueue;

public class MedianOfAStream {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianOfAStream() {
        //instead of implementing the comparator
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>((a, b) -> a - b);
    }

    public void insertNum(int n) {
        if (maxHeap.isEmpty() || n <= maxHeap.peek()) maxHeap.add(n);//number belongs to the smaller list
        else minHeap.add(n); //number belongs to the larger list

        // either both the heaps will have equal number of elements
        // or max-heap will have one more element than the min-heap
        // After every insertion, we will balance the number of elements in both heaps,
        // so that they have an equal number of elements.
        // If the count of numbers is odd, let’s decide to have more numbers in max-heap than the Min Heap.
        if (maxHeap.size() > minHeap.size() + 1)
            minHeap.add(maxHeap.poll());
        else if (maxHeap.size() < minHeap.size())
            maxHeap.add(minHeap.poll());

    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            // we have even number of elements, take the average of middle two elements
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
        // because max-heap will have one more element than the min-heap
        return maxHeap.peek();
    }

    public static void main(String[] args) {
        MedianOfAStream medianOfAStream = new MedianOfAStream();
        medianOfAStream.insertNum(3);
        medianOfAStream.insertNum(1);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(5);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(4);

    }
}
