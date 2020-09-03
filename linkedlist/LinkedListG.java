package linkedlist;

public class LinkedListG {
    Node head = null;

    void add(int data) {
        if (head == null) {
            head = new Node(0);
        }
    }

    void delete(int data) {
        if (head == null) return;
        if (head.data == data) {
            Node del = head;
            head = head.next;
            del = null;//avoid lothering
        }
        Node pointer = head;
        while (pointer.next != null) {
            if (pointer.next.data == data) {

                pointer.next = pointer.next.next;
            }
            pointer = pointer.next;
        }
    }
}
