import java.util.ArrayList;
import java.util.List;

/**
 * @author yun
 * @date 2025/1/21 12:07
 * @desciption: 汇总区间
 */
public class LeetCode228 {
    public List<String> summaryRanges(int[] nums) {

        List<String> ret=new ArrayList<>();
        if(nums.length==0) {
            return ret;
        }
        if(nums.length==1) {
            ret.add(""+nums[0]);
            return ret;
        }
        int pre=nums[0];
        for(int i=1;i<nums.length;i++) {
            if(nums[i]!=nums[i-1]+1) {
                if(nums[i-1]==pre) {
                    ret.add(pre+"");
                } else {
                    ret.add(pre+"->"+nums[i-1]);
                }
                pre=nums[i];
            }
        }

        if(nums[nums.length-1]!=nums[nums.length-2]+1) {
            ret.add(""+nums[nums.length-1]);
        } else {
            ret.add(pre+"->"+nums[nums.length-1]);
        }
        return ret;
    }
}
