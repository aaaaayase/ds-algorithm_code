package com.yun.part1.controller;

import java.util.Stack;

/**
 * @author yun
 * @date 2024/12/10 20:52
 * @desciption: 用两个栈实现队列
 */
public class NowCoder_BM42 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(!stack2.isEmpty()) {
            return stack2.pop();
        } else {
            int size=stack1.size();
            while(size--!=0) {
                int temp=stack1.pop();
                stack2.push(temp);
            }
            return stack2.pop();
        }
    }

}
