package fastslowpointers;

/*
Time Complexity: The above algorithm runs in O(N) time complexity
space complexity O(1)
 */
public class LinkedListCycle {
    static class Node {
        int data;

        public Node(int data) {
            this.data = data;
        }

        Node next;
    }

    static boolean hasCycle(Node head) {
        if (head == null) return false;
        Node slow = head;
        Node fast = slow.next;
        if (fast == null) return false;
        while (fast != null && fast.next != null) {
            if (fast.next == slow) return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        System.out.println("LinkedList has cycle: " + LinkedListCycle.hasCycle(head));

        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList has cycle: " + LinkedListCycle.hasCycle(head));

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList has cycle: " + LinkedListCycle.hasCycle(head));
    }

    int calculateCycleLength(Node slow) {
        int cycleLength = 0;
        Node current = slow;
        while (current != slow) {
            if (current.next == slow) {
                cycleLength++;
                return cycleLength;
            }
            slow = slow.next;
            current = current.next.next;
            cycleLength++;
        }
        return cycleLength;
    }
}
