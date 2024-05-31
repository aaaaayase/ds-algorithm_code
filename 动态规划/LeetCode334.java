import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode334 {
    class Solution {
        public boolean increasingTriplet(int[] nums) {
            List<Integer> list = new ArrayList<>();
            list.add(nums[0]);

            for (int i = 1; i < nums.length; i++) {
                if (list.get(list.size() - 1) < nums[i]) {
                    list.add(nums[i]);
                } else {
                    int left = 0;
                    int right = list.size();
                    while (left < right) {
                        int mid = (left + right) / 2;
                        if (list.get(mid) < nums[i]) {
                            left = mid + 1;
                        } else {
                            right = mid;
                        }

                    }
                    list.set(left, nums[i]);
                }
            }

            return list.size() >= 3 ? true : false;
        }
    }
}
