public class LeetCode42 {
    public int trap(int[] height) {
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(height[i - 1], left[i - 1]);
        }
        for (int i = n - 2; i >= 1; i--) {
            right[i] = Math.max(height[i + 1], right[i + 1]);
        }

        int ret = 0;
        for (int i = 1; i <= n - 2; i++) {
            int temp = Math.min(left[i], right[i]) - height[i];
            ret += (temp < 0 ? 0 : temp);
        }

        return ret;
    }
}
