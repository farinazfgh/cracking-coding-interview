package stacksandqueues;

import java.util.EmptyStackException;

public class StackF {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    Node top;

    int pop() {
        if (top == null) throw new EmptyStackException();
        int item = top.data;
        top = top.next;

        return item;
    }

    void push(int data) {
        Node t = new Node(data);
        t.next = top;
        top = t;
    }

    int peek() {
        if (top == null) throw new EmptyStackException();
        return top.data;
    }

    boolean isEmpty() {
        return (top == null);
    }

}
