import java.util.Arrays;

public class TestHeap {
    public int usedSize;
    public int[] elem;

    public TestHeap() {
        this.elem = new int[10];
    }

    public void initElem(int[] array) {
        for (int i = 0; i < array.length; i++) {
            elem[i] = array[i];
            usedSize++;
        }
    }

    //建堆
    public void CreateBigHeap() {
        for (int i = (usedSize - 2) / 2; i >= 0; i--) {
            siftDown(i, usedSize);
        }
    }

    //元素下沉调整
    public void siftDown(int parent, int end) {
        int child = parent * 2 + 1;
        while (child < end) {
            if (child + 1 < end && elem[child] < elem[child + 1]) {
                child++;
            }
            if (elem[child] > elem[parent]) {
                swap(child, parent);
                parent = child;
                child = 2 * parent + 1;
            } else {
                break;
            }

        }
    }

    public void offer(int val) {
        if(isFull()) {
            elem=Arrays.copyOf(elem,elem.length*2);
        } else {
            elem[usedSize]=val;
            usedSize++;
            siftUp(usedSize-1);
        }
    }

    public void heapSort() {
        int end=usedSize-1;
        while (end>0) {
            swap(0,end);
            end--;
            siftDown(0,end) ;
        }
    }
    public void siftUp(int child) {
        int parent = (child - 1) / 2;
        while (child > 0) {
            if(elem[child]>elem[parent]) {
                swap(child,parent);
                child=parent;
                parent=(child-1)/2;
            } else {
                break;
            }
        }

    }

    public boolean isFull() {
        return usedSize==elem.length;
    }

    private void swap(int i, int j) {
        int temp = elem[i];
        elem[i] = elem[j];
        elem[j] = temp;
    }

    //删除
    public int poll() {
        int temp = elem[usedSize - 1];
        swap(0, usedSize - 1);
        usedSize--;
        siftDown(0, usedSize);
        return temp;
    }
}
