public class LeetCode912 {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = (left + right) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);

        int cur1 = left, cur2 = mid + 1;
        int[] temp = new int[right - left + 1];
        int i = 0;
        while (cur1 <= mid && cur2 <= right) {
            temp[i++] = (nums[cur1] <= nums[cur2]) ? nums[cur1++] : nums[cur2++];
        }

        while (cur1 <= mid) {
            temp[i++] = nums[cur1++];
        }

        while (cur2 <= right) {
            temp[i++] = nums[cur2++];
        }

        for (int j = left; j <= right; j++) {
            nums[j] = temp[j - left];
        }
    }

}
