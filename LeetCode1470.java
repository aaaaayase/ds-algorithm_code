public class LeetCode1470 {
    //给你一个数组 nums ，数组中有 2n 个元素，按 [x1,x2,...,xn,y1,y2,...,yn] 的格式排列。
    //
    //请你将数组按 [x1,y1,x2,y2,...,xn,yn] 格式重新排列，返回重排后的数组。
    public int[] shuffle(int[] nums, int n) {
        int s1 = 0;
        int s2 = n;
        int e1 = n - 1;
        int e2 = 2 * n - 1;
        int index = 0;
        int[] ret = new int[nums.length];
        while (index < ret.length) {
            if (index % 2 == 0) {
                ret[index] = nums[s1];
                s1++;
                index++;
            } else {
                ret[index] = nums[s2];
                s2++;
                index++;
            }
        }
        return ret;
    }
}
