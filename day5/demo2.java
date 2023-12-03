package day5;

import java.util.Stack;

public class demo2 {
    //后缀表达式求值
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (!isOperation(tokens[i])) {
                stack.push(Integer.valueOf(tokens[i]));
            } else {
                int num1 = Integer.valueOf(stack.pop());
                int num2 = Integer.valueOf(stack.pop());
                switch (tokens[i]) {
                    case "/":

                        stack.push(num2 / num1);
                        break;
                    case "+":

                        stack.push(num2 + num1);
                        break;
                    case "-":

                        stack.push(num2 - num1);
                        break;
                    case "*":

                        stack.push(num2 * num1);
                        break;
                }
            }

        }

        return stack.peek();
    }

    public boolean isOperation(String s) {
        if (s.equals("/") || s.equals("-") || s.equals("+") || s.equals("*")) {

            return true;
        }
        return false;
    }
}
