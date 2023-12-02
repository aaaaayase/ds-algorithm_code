package day4.mystack;

import java.util.Arrays;

public class MyStack {
    int[] array;
    int size;

    public MyStack() {
        array = new int[3];
    }

    public int push(int e) {
        ensureCapacity();
        array[size++] = e;
        return e;
    }

    public int pop() {
        int ret=peek();
        size--;
        return ret;
    }

    public int peek() {
        if (empty()) {
            throw new PopException("Stack is empty!");
        }
        return array[size-1];
    }

    public int size() {
        return size;
    }

    public boolean empty() {
        return size == 0;
    }

    private void ensureCapacity() {
        if (array.length == size) {
            Arrays.copyOf(array, 2 * array.length);
        }
    }
}
