import java.util.*;

public class LeetCode217 {
    //给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；
    // 如果数组中每个元素互不相同，返回 false 。
    public boolean containsDuplicate(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();

        for (int num : nums) {
            if(!map.containsKey(num)) {
                map.put(num,1);
            } else {
                map.put(num,map.get(num)+1);
            }
        }


        List<Integer> list = new ArrayList<>(map.values());

        for (Integer num:
                list) {
            if(num>1) {
                return true;
            }
        }
        return false;
    }
}
