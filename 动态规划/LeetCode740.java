import java.util.Arrays;

public class LeetCode740 {
    public int deleteAndEarn(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int max = nums[n - 1];
        int min = nums[0];
        int[] count = new int[max - min + 1];
        for (int num : nums) {
            count[num - min] += num;
        }

        int len = count.length;
        int[] f = new int[len];
        int[] g = new int[len];

        f[0] = count[0];

        for (int i = 1; i < len; i++) {
            f[i] = g[i - 1] + count[i];
            g[i] = Math.max(g[i - 1], f[i - 1]);
        }

        return Math.max(f[len - 1], g[len - 1]);
    }
}
