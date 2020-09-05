package linkedlist;

import java.util.Stack;

public class ReturnKthtoLast {

    static int printKthToLastRecursive(Node node, int k) {
        if (node == null) {
            return 0;
        }
        int temp = 1 + printKthToLastRecursive(node.next, k);
        if (temp == k) {
            System.out.println("kth value of the linkedlist is:" + node.data);
        }
        return temp;
    }

    static void printKthToLast(Node node, int k) {
        Stack<Node> stack = new Stack<>();
        while (node != null) {
            stack.push(node);
            node = node.next;
        }
        int count = 0;
        do {
            Node temp = stack.pop();
            count++;
            if (count == k) {
                System.out.println(temp.data);
                break;
            }
        } while (count < k);
    }

    public static void main(String[] args) {

        Node head = new Node(0);

        for (int i = 6; i >= 2; i--) Util.add(head, i);
        Util.visit(head);

        System.out.println("*************");
        Util.add(head, 6);
        Util.add(head, 2);
        Util.add(head, 0);
        Util.visit(head);
        printKthToLast(head, 3);
        printKthToLast(head, 1);
        printKthToLast(head, 0);
        printKthToLastRecursive(head, 3);
    }

    Node nthToLast(Node head, int k) {
        Node p1 = head;
        Node p2 = head;
        /* Move pi k nodes into the list. */
        for (int i = 0; i < k; i++) {
            if (p1 == null) return null; // Out of bounds
            p1 = p1.next;
        }

        /* Move them at the same pace. When p1 hits the end, p2 will be at the right
         * element . */
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}
