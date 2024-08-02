public class LeetCode_LCR170 {
    public int reversePairs(int[] record) {
        int n = record.length;
        return mergeSort(record, 0, n - 1);
    }

    public int mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return 0;
        }

        int ret = 0;
        int mid = (right + left) / 2;

        ret += mergeSort(arr, left, mid);
        ret += mergeSort(arr, mid + 1, right);

        int cur1 = left, cur2 = mid + 1, i = 0;
        int temp[] = new int[right - left + 1];
        while (cur1 <= mid && cur2 <= right) {
            if (arr[cur1] <= arr[cur2]) {
                temp[i++] = arr[cur1++];
            } else {
                ret += (mid - cur1 + 1);
                temp[i++] = arr[cur2++];
            }
        }

        while (cur1 <= mid) {
            temp[i++] = arr[cur1++];
        }

        while (cur2 <= right) {
            temp[i++] = arr[cur2++];
        }

        for (int j = left; j <= right; j++) {
            arr[j] = temp[j - left];
        }
        return ret;
    }
}
