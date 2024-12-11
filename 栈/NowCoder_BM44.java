package com.yun.part1.controller;

import java.util.Stack;

/**
 * @author yun
 * @date 2024/12/10 20:52
 * @desciption:  有效括号序列
 */
public class NowCoder_BM44 {
    public boolean isValid (String _s) {
        // write code here
        char[] s = _s.toCharArray();
        Stack<Character> stack = new Stack<>();
        int i=0;
        while (i < s.length) {
            if (s[i] == '{' || s[i] == '[' || s[i] == '(') {
                stack.push(s[i]);
                i++;
            } else {
                if(stack.isEmpty()) {
                    return false;
                }
                char temp=stack.pop();
                if((temp=='{'&&s[i]!='}')||(temp=='['&&s[i]!=']')||(temp=='('&&s[i]!=')')) {
                    return false;
                }
                i++;
            }
        }

        if(stack.size()!=0) {
            return false;
        }
        return true;
    }

}
