package linkedlist;

public class Util {
    static Node add(Node head, int data) {
        if (head == null) {
            head = new Node(data);
            return head;
        }
        Node pointer = head;
        while (pointer.next != null) {
            pointer = pointer.next;
        }
        pointer.next = new Node(data);
        return pointer.next;
    }
   static void visit(Node node) {
       if (node == null) return;
       while (node != null) {
           System.out.print(node.data + " ");
           node = node.next;
       }
       System.out.println();
   }
}
