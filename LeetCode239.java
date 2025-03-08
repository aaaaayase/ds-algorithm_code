package rabbitmq.work;

import java.util.LinkedList;

/**
 * @author yun
 * @date 2025/3/8 10:10
 * @desciption:
 */
public class LeetCode239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> temp = new LinkedList();
        int n = nums.length;
        int[] result = new int[n - k + 1];
        for (int i = 0; i < n; i++) {
            while (!temp.isEmpty() && nums[temp.peekLast()] <= nums[i]) {
                temp.pollLast();
            }

            temp.addLast(i);

            if (temp.peek() <= i - k) {
                temp.poll();
            }

            // 达到k长度
            if (i + 1 >= k) {
                result[i - k + 1] = nums[temp.peek()];
            }
        }

        return result;
    }
}
