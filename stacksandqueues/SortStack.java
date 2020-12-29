package stacksandqueues;

import java.util.Stack;

public class SortStack {
    static Stack<Integer> sort(Stack<Integer> unsortedStack) {

        Stack<Integer> buffer = new Stack<>();
        while (!unsortedStack.isEmpty()) {
            int temp = unsortedStack.pop();
            if (buffer.isEmpty()) buffer.push(temp);
            else {
                while (!buffer.isEmpty() && buffer.peek() > temp) {
                    unsortedStack.push(buffer.pop());
                }
                buffer.push(temp);
            }
        }
        return buffer;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(2);
        stack.push(3);
        stack.push(1);
        stack.push(5);
        stack.push(4);
        stack.push(9);
        stack.push(8);
        stack.push(7);
        System.out.println(sort(stack));
    }

}
