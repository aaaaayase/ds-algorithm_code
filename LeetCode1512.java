import java.util.Arrays;

public class LeetCode1512 {
    public int numIdenticalPairs(int[] nums) {
        Arrays.sort(nums);
        int index = 0;
        int count = 0;
        while (index < nums.length) {
            int temp = index;
            while (index + 1 < nums.length && nums[index] == nums[index + 1]) {
                index++;
                count++;

            }
            index = temp + 1;

        }
        return count;
    }
}
