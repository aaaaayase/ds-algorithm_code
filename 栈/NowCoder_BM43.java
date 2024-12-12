package com.yun.part1.controller;

import java.util.ArrayList;
import java.util.List;

public class NowCoder_BM43 {
    private List<Integer> stack = new ArrayList<>();
    private int min = Integer.MAX_VALUE;

    public void push(int node) {
        stack.add(node);
        min = Math.min(node, min);
    }

    public void pop() {
        int temp = stack.remove(stack.size() - 1);
        if (temp == min()) {
            int size = stack.size();
            min = Integer.MAX_VALUE;
            while (size-- != 0) {
                min = Math.min(min, stack.get(size));
            }
        }
    }

    public int top() {
        return stack.get(stack.size() - 1);
    }

    public int min() {

        return min;
    }

}
