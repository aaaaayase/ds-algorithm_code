import java.util.HashMap;
import java.util.Map;

public class LeetCode219 {
    //给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，满足 nums[i] == nums[j] 且 abs(i - j) <= k 。
    // 如果存在，返回 true ；否则，返回 false 。
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            } else {
                if(Math.abs(map.get(nums[i])-i)<=k) {
                    return true;
                }
                map.put(nums[i],i);
            }
        }
        return false;
    }
}
