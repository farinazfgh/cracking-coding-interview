package stacksandqueues;

import java.util.Stack;

public class StackWithMin2 extends Stack<Integer> {
    Stack<Integer> mins = new Stack<>();

    public void push(int value) {
        if (value < min()) {
            mins.push(value);
        }
        super.push(value);
    }

    public Integer pop() {
        int value;
        if (super.isEmpty()) {
            return Integer.MAX_VALUE;
        } else {
            value = super.pop();
        }
        if (value == min()) mins.pop();
        return value;
    }

    public Integer min() {
        if (!mins.isEmpty()) return mins.peek();
        return Integer.MAX_VALUE;
    }
}
