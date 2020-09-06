package stacksandqueues;

import java.util.NoSuchElementException;

public class QueueF {
    static class Node {
        Node next;
        int data;

        public Node(int data) {
            this.data = data;
        }
    }

    Node front, end;

    void add(int data) {
        Node node = new Node(data);
        if (isEmpty()) {
            front = node;
            end = node;
            return;
        }
        end.next = node;
        end = node;
    }

    int delete() {
        if (isEmpty()) throw new NoSuchElementException();
        int item = front.data;
        front = front.next;
        if(front==null)end=null;
        return item;
    }

    boolean isEmpty() {
        return (front == null && end == null);
    }

    public static void main(String[] args) {
        QueueF queueF= new QueueF();
        queueF.add(0);
        System.out.println(queueF.delete());
        queueF.add(0);
        queueF.add(1);
}
}

