import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LeetCode179 {


    class Solution {
        public String largestNumber(int[] nums) {
            int n = nums.length;
            String[] strs = new String[n];
            for (int i = 0; i < n; i++) {
                strs[i] = String.valueOf(nums[i]);
            }

            Arrays.sort(strs, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return (o2 + o1).compareTo(o1 + o2);
                }
            });


            StringBuilder retS = new StringBuilder();
            for (String str : strs) {
                retS.append(str);
            }

            if (retS.charAt(0) == '0') {
                return "0";
            }
            return retS.toString();
        }
    }


}
