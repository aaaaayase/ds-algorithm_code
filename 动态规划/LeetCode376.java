public class LeetCode376 {


    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;

        int[] f = new int[n];
        int[] g = new int[n];

        for (int i = 0; i < n; i++) {
            f[i] = 1;
            g[i] = 1;
        }

        int max = 1;
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    f[i] = Math.max(f[i], g[j] + 1);
                } else if (nums[i] < nums[j]) {
                    g[i] = Math.max(g[i], f[j] + 1);
                }
            }

            max = Math.max(f[i], Math.max(g[i], max));
        }

        return max;
    }
}
