import java.util.Stack;

//请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
//
//        实现 MyQueue 类：
//
//        void push(int x) 将元素 x 推到队列的末尾
//        int pop() 从队列的开头移除并返回元素
//        int peek() 返回队列开头的元素
//        boolean empty() 如果队列为空，返回 true ；否则，返回 false
class MyQueue1 {

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public MyQueue1() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        if (empty()) {
            return -1;
        }
        int size=stack1.size();
        for (int i = 0; i < size; i++) {
            stack2.push(stack1.pop());
        }

        int ret=stack2.pop();

        size=stack2.size();
        for (int i = 0; i < size; i++) {
            stack1.push(stack2.pop());
        }

        return ret;
    }

    public int peek() {
        if (empty()) {
            return -1;
        }
        int size=stack1.size();
        for (int i = 0; i < size; i++) {
            stack2.push(stack1.pop());
        }

        int ret=stack2.peek();

        for (int i = 0; i < size; i++) {
            stack1.push(stack2.pop());
        }

        return ret;
    }

    public boolean empty() {
        return stack1.empty() && stack2.empty();
    }
}
