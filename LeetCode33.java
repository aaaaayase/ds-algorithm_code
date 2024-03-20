import java.util.Arrays;

public class LeetCode33 {
    public int search(int[] nums, int target) {
        int[][] temp = new int[nums.length][];
        for (int i = 0; i < nums.length; i++) {
            temp[i] = new int[]{nums[i], i};
        }
        Arrays.sort(temp, (o1, o2) -> o1[0] - o2[0]);
        int l = 0;
        int r = nums.length;

        while (l < r) {
            int mid = (l + r) / 2;
            if (temp[mid][0] > target) {
                r = mid;
            } else if (temp[mid][0] < target) {
                l = mid + 1;
            } else {
                return temp[mid][1];
            }
        }

        return -1;
    }
}
