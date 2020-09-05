package linkedlist;

public class LinkedListG {
    Node head = null;
    int size = 0;

    void add(int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }
        Node pointer = head;
        while (pointer.next != null) {
            pointer = pointer.next;
        }
        pointer.next = new Node(data);
        size++;
    }

    void delete(int data) {
        if (head == null) return;

        if (head.data == data) {
            head = head.next;
            size--;
            return;
        }

        Node pointer = head;
        while (pointer.next != null) {
            if (pointer.next.data == data) {
                pointer.next = pointer.next.next;
                size--;
                return;
            }
            pointer = pointer.next;
        }
    }

    void visit(Node node) {
        if (node == null) return;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }
}
