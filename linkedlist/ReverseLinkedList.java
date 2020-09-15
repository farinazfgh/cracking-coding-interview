package linkedlist;

public class ReverseLinkedList {
    Node head;

    static Node reverseI(Node node) {
        Node prev = null;
        Node current = node;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;

        }
        return prev;
    }

    static Node reverseR(Node node) {
        //todo
        return null;
    }

    public static void main(String[] args) {
        Node head = new Node(0);

        for (int i = 6; i >= 2; i--) Util.add(head, i);
        Util.visit(head);

        System.out.println("*************");
        Util.visit(reverseI(head));

    }

}
