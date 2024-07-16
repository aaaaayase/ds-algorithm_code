public class LeetCode137 {
    public int singleNumber(int[] nums) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                if (((nums[j] >> i) & 1) == 1) {
                    sum++;
                }
            }
            sum %= 3;
            ret |= (sum << i);
        }

        return ret;
    }

}
