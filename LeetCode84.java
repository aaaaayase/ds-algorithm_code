/**
 * @author yun
 * @date 2025/4/29 21:44
 * @desciption: 84. 柱状图中最大的矩形
 */
public class LeetCode84 {
    public int largestRectangleArea(int[] ss) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> heights = new ArrayList<>();
        for (int i = 0; i < ss.length; i++) {
            heights.add(ss[i]);
        }
        heights.add(-1);
        int ans = 0;
        for (int i = 0; i <heights.size(); i++) {
            while (!stack.isEmpty() && heights.get(i) < heights.get(stack.peek())) {
                int temp = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                ans = Math.max(ans, (i - left - 1) * heights.get(temp));
            }
            stack.push(i);
        }

        return ans;
    }
}
