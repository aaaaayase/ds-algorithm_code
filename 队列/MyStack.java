import java.util.LinkedList;
import java.util.Queue;

// 用普通队列实现栈
class MyStack {

    Queue<Integer> queue1;
    Queue<Integer> queue2;

    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        if (empty()) {
            queue1.offer(x);
            return;
        }

        if (!queue1.isEmpty()) {
            queue1.offer(x);

        } else {
            queue2.offer(x);

        }


    }

    public int pop() {
        if (empty()) {
            return -1;
        }

        if (!queue1.isEmpty()) {
            int size = queue1.size();
            for (int i = 0; i < size - 1; i++) {

                queue2.offer(queue1.poll());
            }
            return queue1.poll();
        }


        int size = queue2.size();
        for (int i = 0; i < size - 1; i++) {

            queue1.offer(queue2.poll());
        }
        return queue2.poll();


    }

    public int top() {
        if (empty()) {
            return -1;
        }

        if (!queue1.isEmpty()) {
            int size = queue1.size();
            int temp = 0;
            for (int i = 0; i < size; i++) {
                temp = queue1.poll();
                queue2.offer(temp);
            }
            return temp;
        }


        int temp = 0;
        int size = queue2.size();
        for (int i = 0; i < size; i++) {
            temp = queue2.poll();
            queue1.offer(temp);
        }
        return temp;
    }

    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
}
