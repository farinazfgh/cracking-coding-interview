package linkedlist;

public class Node {
    int data;
    Node next = null;

    public Node(int data) {
        this.data = data;
    }

    void appendToTail(int data) {
        Node end = new Node(data);
        Node n = this;
        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
    }
}
