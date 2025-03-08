package rabbitmq.work;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yun
 * @date 2025/3/8 10:11
 * @desciption: 41. 缺失的第一个正数
 */
public class LeetCode41 {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        for (int i = 1; i <= n; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }

        return n + 1;
    }
}
