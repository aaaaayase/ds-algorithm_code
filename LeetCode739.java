/**
 * @author yun
 * @date 2025/3/23 23:44
 * @desciption: 739. 每日温度
 */
public class LeetCode739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int temp = stack.pop();
                ans[temp] = i - temp;
            }
            stack.push(i);
        }

        return ans;

    }
}
