import java.util.Stack;

public class LeetCode946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> s = new Stack<>();

        int j = 0;
        for (int i = 0; i < pushed.length; i++) {
            s.push(pushed[i]);
            while (!s.isEmpty() && s.peek() == popped[j]) {
                s.pop();
                j++;
            }
        }

        if (j == popped.length) {
            return true;
        }

        return false;
    }
}
