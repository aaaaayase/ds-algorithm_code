import java.util.Stack;

public class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        if (stack.empty()) {
            stack.push(val);
            minStack.push(val);
        } else {
            stack.push(val);
            if (val<=minStack.peek()) {
                minStack.push(val);
            }
        }
    }

    public void pop() {
        if (stack.empty()) {
            return ;
        }

        int temp=stack.pop();
        if (minStack.peek()==temp) {
            minStack.pop();
        }

    }

    public int top() {
        if (stack.empty()) {
            return -1;
        }
        return stack.peek();
    }

    public int getMin() {
        if (stack.empty()) {
            return -1;
        }
        return minStack.peek();
    }

}
