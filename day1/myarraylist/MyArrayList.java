package day1.myarraylist;

import java.util.Arrays;

//实现ArrayList类


public class MyArrayList {

    public int[] elem;
    public int usedSize;//0
    //默认容量
    private static final int DEFAULT_SIZE = 10;

    public MyArrayList() {
        this.elem = new int[DEFAULT_SIZE];
    }

    /**
     * 打印顺序表:
     * 根据usedSize判断即可
     */
    public void display() {
        for (int i = 0; i < usedSize; i++) {
            System.out.print(elem[i] + " ");
        }
    }

    // 新增元素,默认在数组最后新增
    public void add(int data) {
        if (isFull()) {
            elem = Arrays.copyOf(elem, 2 * elem.length);
        }
        elem[usedSize] = data;
        usedSize++;
    }


    /**
     * 判断当前的顺序表是不是满的！
     *
     * @return true:满   false代表空
     */
    public boolean isFull() {
        if (usedSize == elem.length) {
            return true;
        } else {
            return false;
        }
    }


    private boolean checkPosInAdd(int pos) {

        if (pos > usedSize || pos < 0) {
            return false;
        }
        return true;//合法
    }

    // 在 pos 位置新增元素
    public void add(int pos, int data) {
        if (!checkPosInAdd(pos)) {
            throw new PosException("pos:" + pos);
        }
        if (isFull()) {
            elem = Arrays.copyOf(elem, 2 * elem.length);
        }
        for (int i = usedSize - 1; i >= pos; i--) {
            elem[i + 1] = elem[i];
        }
        elem[pos] = data;
        usedSize++;


    }

    // 判定是否包含某个元素
    public boolean contains(int toFind) {
        for (int i = 0; i < usedSize; i++) {
            if (toFind == elem[i]) {
                return true;
            }
        }
        return false;
    }

    // 查找某个元素对应的位置
    public int indexOf(int toFind) {
        for (int i = 0; i < usedSize; i++) {
            if (toFind == elem[i])
                return i;
        }
        return -1;
    }

    // 获取 pos 位置的元素
    public int get(int pos) {
        if (checkPosInAdd(pos) && !isEmpty()) {
            return elem[pos];
        } else {
            throw new PosException("pos:" + pos);
        }
    }

    private boolean isEmpty() {
        if (usedSize == 0) {
            return true;
        }
        return false;
    }

    // 给 pos 位置的元素设为【更新为】 value
    public void set(int pos, int value) {
        if (checkPosInAdd(pos) && !isEmpty()) {
            elem[pos] = value;

        } else {
            throw new PosException("pos:" + pos);
        }


    }

    /**
     * 删除第一次出现的关键字key
     *
     * @param key
     */
    public void remove(int key) {

        int pos = indexOf(key);
        if (isEmpty() || !checkPosInAdd(pos)) {
            throw new PosException("pos:" + pos);
        }
        for (int i = pos; i < usedSize - 1; i++) {
            elem[i] = elem[i + 1];
        }
        usedSize--;

    }

    // 获取顺序表长度
    public int size() {
        return usedSize;
    }

    // 清空顺序表
    public void clear() {

        usedSize = 0;

    }
}
