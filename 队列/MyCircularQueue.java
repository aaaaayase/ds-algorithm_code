//设计循环队列


public class MyCircularQueue {

    int[] array;
    int front;
    int rear;


    public MyCircularQueue(int k) {
        array = new int[k];

    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        array[rear] = value;
        rear = (rear + 1) % array.length;


        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % array.length;
        return true;

    }

    public int Front() {
        if(isEmpty()) {
            return -1;
        }
        return array[front];
    }

    public int Rear() {
        if(isEmpty()) {
            return -1;
        }
        return rear == 0 ? array[array.length - 1] : array[rear - 1];
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public boolean isFull() {
        return (rear + 1) % array.length == front;
    }
}
