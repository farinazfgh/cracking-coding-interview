package stacksandqueues;

import java.util.Stack;

//There's just one issue with this: if we have a I;uge stack, we waste a lot of space by keeping track of the min
//for every single element.
public class StackWithMin extends Stack<StackWithMin.Node> {
    class Node {
        int value;
        int min;

        public Node(int value, int min) {
            this.value = value;
            this.min = min;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", min=" + min +
                    '}';
        }
    }

    public void push(int value) {
        int newMin = Math.min(value, min());
        super.push(new Node(value, newMin));
    }

    public int min() {
        if (this.empty()) return Integer.MAX_VALUE;
        return peek().min;
    }


    public static void main(String[] args) {
        StackWithMin stackWithMin = new StackWithMin();
        //9,3,7,2,4,1,6
        stackWithMin.push(9);
        System.out.println(stackWithMin.min());

        stackWithMin.push(3);
        System.out.println(stackWithMin.min());

        stackWithMin.push(7);
        System.out.println(stackWithMin.min());

        stackWithMin.push(2);
        System.out.println(stackWithMin.min());

        stackWithMin.push(4);
        System.out.println(stackWithMin.min());

        stackWithMin.push(1);
        System.out.println(stackWithMin.min());
        while (!stackWithMin.isEmpty()) {
            System.out.println(stackWithMin.pop());
        }

    }
}
