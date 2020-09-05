package linkedlist;

import java.util.HashSet;
import java.util.Set;

public class RemoveDups {


    static void removeDuplicatesWithBuffer(Node head) {
        if (head == null) return;
        Node pointer = head;
        Set<Integer> set = new HashSet<>();
        while (pointer.next != null) {
            if (!set.add(pointer.next.data)) {
                pointer.next = pointer.next.next;
            } else {
                pointer = pointer.next;
            }
        }
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
        removeDuplicatesWithBuffer(head);
        Util.visit(head);
    }


}
