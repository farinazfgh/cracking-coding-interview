package kwaymerge;

import java.util.PriorityQueue;

/*
Brute force solution will be concat all the lists and then sort them which will take O(nlogn),
 which is not utilizing the fact that each individual list is already sorted.
 so we use a minHep. the heap will always contains k element which is the number of lists.
 inserting to the heap takes O(log K), and deleting from heap takes O(1) so since we process every n element
 time complexity is O(n log K) and since K <= n then this one is more efficent.

 */
public class MergeKSortedLists {
    static class ListNode {
        private final int data;
        ListNode next;

        ListNode(int data) {
            this.data = data;
        }
    }

    /*
     * How can we utilize the fact that the input lists are individually sorted?
     * The best data structure that comes to mind to find the smallest number among a set of ‘K’ numbers is a Heap.
     */
    public static ListNode merge(ListNode[] lists) {
        int n = lists.length;
        ListNode resultHead = null;
        ListNode resultTail = null;
        if (n == 0) {
            System.out.println("no lists to merge");
            return null;
        }
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((node1, node2) -> node1.data - node2.data);
        for (ListNode head : lists) {
            minHeap.offer(head);
        }
        while (!minHeap.isEmpty()) {

            ListNode node = minHeap.poll();
            if (resultHead == null) {
                resultHead = resultTail = node;
            } else {
                resultTail.next = node;
                resultTail = resultTail.next;
            }
            if (node.next != null) {
                minHeap.offer(node.next);
            }
        }
        return resultHead;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(6);
        l1.next.next = new ListNode(8);

        ListNode l2 = new ListNode(3);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(7);

        ListNode l3 = new ListNode(1);
        l3.next = new ListNode(3);
        l3.next.next = new ListNode(4);

        ListNode result = MergeKSortedLists.merge(new ListNode[]{l1, l2, l3});
        System.out.print("Here are the elements form the merged list: ");
        while (result != null) {
            System.out.print(result.data + " ");
            result = result.next;
        }
    }
}
