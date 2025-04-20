/**
 * @author yun
 * @date 2025/4/20 20:40
 * @desciption: 287. 寻找重复数
 */
public class LeetCode287 {
    public int findDuplicate(int[] nums) {
        int fast = 0;
        int slow = 0;

        while (true) {
            fast = nums[nums[fast]];
            slow = nums[slow];
            if (fast == slow) {
                break;
            }
        }

        fast = 0;
        while (true) {
            fast = nums[fast];
            slow = nums[slow];
            if (fast == slow) {
                return fast;
            }
        }

    }
}
