public class LeetCode227 {

    public int calculate(String ss) {
        char[] s = ss.toCharArray();
        int n = s.length;
        Stack<Integer> stack = new Stack<>();
        char op = '+';
        int i = 0;
        while (i < n) {
            char ch = s[i];
            if (ch == ' ') {
                i++;
            } else if (ch >= '0' && ch <= '9') {
                int temp = 0;
                while (i < n && s[i] >= '0' && s[i] <= '9') {
                    int num = s[i] - '0';
                    temp = temp * 10 + num;
                    i++;
                }
                switch (op) {
                    case '*': {
                        stack.push(stack.pop() * temp);
                        break;
                    }
                    case '/': {
                        stack.push(stack.pop() / temp);
                        break;
                    }
                    case '+':
                        stack.push(temp);
                        break;
                    case '-':
                        stack.push(-temp);
                        break;
                }
            } else {
                op = s[i];
                i++;
            }
        }

        int len = stack.size();
        int ret = 0;
        for (int j = 0; j < len; j++) {
            ret += stack.pop();
        }

        return ret;
    }
}