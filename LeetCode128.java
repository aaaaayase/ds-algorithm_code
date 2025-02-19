/**
 * @author yun
 * @date 2025/2/19 22:00
 * @desciption: 128. 最长连续序列
 */
public class LeetCode128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int ret=0;
        for (int num : set) {
            if(!set.contains(num-1)) {
                int curL=1;
                int temp=num;
                while(set.contains(temp+1)) {
                    curL+=1;
                    temp+=1;
                }
                ret=Math.max(ret,curL);
            }
        }

        return ret;
    }
}
