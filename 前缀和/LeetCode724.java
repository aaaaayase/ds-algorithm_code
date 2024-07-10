public class LeetCode724 {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] f = new int[n];
        int[] g = new int[n];

        for (int i = 1; i < n; i++) {
            f[i] = f[i - 1] + nums[i - 1];
        }

        for (int i = n - 2; i >= 0; i--) {
            g[i] = g[i + 1] + nums[i + 1];
        }

        for (int i = 0; i < n; i++) {
            if (f[i] == g[i]) {
                return i;
            }
        }

        return -1;
    }
}
