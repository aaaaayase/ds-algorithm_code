/**
 * @author yun
 * @date 2025/4/29 22:51
 * @desciption:
 */
public class LeetCode45 {
    public int jump(int[] nums) {
        int maxPos=0,end=0;
        int ret=0;
        for(int i=0;i<nums.length-1;i++) {
            maxPos=Math.max(maxPos,i+nums[i]);
            if(end==i) {
                end=maxPos;
                ret++;
            }
        }

        return ret;
    }

}
