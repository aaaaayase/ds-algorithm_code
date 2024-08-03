import java.util.ArrayList;
import java.util.List;

public class LeetCode315 {
    int n;
    int[] ret;
    int[] index;
    int[] temp;
    int[] tempIndex;

    public List<Integer> countSmaller(int[] nums) {
        n = nums.length;
        ret = new int[n];
        index = new int[n];
        temp = new int[n];
        tempIndex = new int[n];
        for (int i = 0; i < n; i++) {
            index[i] = i;
        }
        mergeSort(nums, 0, n - 1);

        List<Integer> list = new ArrayList<>();
        for (int x : ret) {
            list.add(x);
        }
        return list;
    }

    public void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = (left + right) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);

        int cur1 = left, cur2 = mid + 1;
        int i = 0;
        while (cur1 <= mid && cur2 <= right) {
            if (nums[cur1] > nums[cur2]) {
                ret[index[cur1]] += (right - cur2 + 1);
                temp[i] = nums[cur1];
                tempIndex[i++] = index[cur1++];
            } else {
                temp[i] = nums[cur2];
                tempIndex[i++] = index[cur2++];
            }
        }

        while (cur1 <= mid) {
            temp[i] = nums[cur1];
            tempIndex[i++] = index[cur1++];
        }

        while (cur2 <= right) {
            temp[i] = nums[cur2];
            tempIndex[i++] = index[cur2++];
        }

        for (int j = left; j <= right; j++) {
            nums[j] = temp[j - left];
            index[j] = tempIndex[j - left];
        }
    }
}
