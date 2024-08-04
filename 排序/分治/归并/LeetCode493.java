public class LeetCode493 {
    int[] temp;

    public int reversePairs(int[] nums) {
        int n = nums.length;
        temp = new int[n];
        return mergeSort(nums, 0, n - 1);
    }

    public int mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return 0;
        }

        int ret = 0;
        int mid = (right + left) / 2;
        ret += mergeSort(nums, left, mid);
        ret += mergeSort(nums, mid + 1, right);

        int cur1 = left, cur2 = mid + 1, i = 0;

        while (cur1 <= mid) {
            while (cur2 <= right && nums[cur1] / 2.0 <= nums[cur2]) {
                cur2++;
            }
            if (cur2 > right) {
                break;
            }
            ret += (right - cur2 + 1);
            cur1++;
        }

        cur1 = left;
        cur2 = mid + 1;

        while (cur1 <= mid && cur2 <= right) {
            if (nums[cur1] <= nums[cur2]) {
                temp[i++] = nums[cur2++];
            } else {
                temp[i++] = nums[cur1++];
            }
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

        return ret;
    }
}
