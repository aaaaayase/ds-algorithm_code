/**
 * @author yun
 * @date 2025/4/29 22:51
 * @desciption:
 */
public class LeetCode55 {
    public boolean canJump(int[] nums) {
        int target=nums.length-1;
        for(int i=nums.length-2;i>=0;i--) {
            if(i+nums[i]>=target) {
                target=i;
            }
        }

        if(target==0) {
            return true;
        }

        return false;
    }

}
