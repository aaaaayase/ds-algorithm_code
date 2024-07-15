public class LeetCode268 {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int ret = 0;
        for (int i = 0; i < n; i++) {
            ret ^= i;
            ret ^= nums[i];
        }

        return ret ^ n;
    }
}
