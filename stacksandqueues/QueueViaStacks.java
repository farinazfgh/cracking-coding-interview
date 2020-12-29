package stacksandqueues;

import java.util.Stack;

/*
1. add: only to the new stack
2. remove: from old stack if it is not empty, if it is empty, move all elements from new to old then remove
on moving all from new to old bottom of stack (head) becomes top of new and remove will be queue like
 */
public class QueueViaStacks {
    Stack<Integer> stackNewest, stackOldest;

    public QueueViaStacks() {
        stackNewest = new Stack<>();
        stackOldest = new Stack<>();
    }

    public int size() {
        return stackNewest.size() + stackOldest.size();
    }
    /* Push onto stackNewest, which always has the newest elements on top
     * so the push is only done to one stack stack new */

    public void add(Integer value) {
        stackNewest.push(value);
    }

    public Integer remove() {
        shiftStacks();
        // Ensure stackOldest has the current elements
        return stackOldest.pop();
        // pop the oldest item.
    }
    /*    
    Move elements from stackNewest into stackOldest.    
    This is usually done so that we can do operations on stackOldest .
     * */


    private void shiftStacks() {
        if (stackOldest.isEmpty()) {
            while (!stackNewest.isEmpty()) {
                stackOldest.push(stackNewest.pop());
            }
        }
    }

    public Integer peek() {
        shiftStacks();
        // Ensure stackOldest has the current elements
        return stackOldest.peek();
        // retrieve the oldest item.
    }

    @Override
    public String toString() {
        return "QueueViaStacks{" +
                "stackNewest=" + stackNewest +
                ", stackOldest=" + stackOldest +
                '}';
    }

    public static void main(String[] args) {
        QueueViaStacks queue = new QueueViaStacks();
        queue.add(2);
        queue.add(3);
        queue.add(1);
        queue.add(5);
        System.out.println(queue);

        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue);

        queue.add(4);
        queue.add(9);
        queue.add(8);
        queue.add(7);
        System.out.println(queue);

    }

}