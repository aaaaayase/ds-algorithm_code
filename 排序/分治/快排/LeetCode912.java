public class LeetCode912 {
    public int[] sortArray(int[] nums) {
        qsort(nums, 0, nums.length - 1);
        return nums;
    }

    public void qsort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int i = l;
        int key = arr[l];
        int left = l - 1, right = r + 1;
        while (i < right) {
            if (arr[i] < key) {
                swap(arr, ++left, i++);
            } else if (arr[i] == key) {
                i++;
            } else {
                swap(arr, --right, i);
            }
        }
        qsort(arr, l, left);
        qsort(arr, right, r);
    }

    public void swap(int[] arr, int n1, int n2) {
        int temp = arr[n1];
        arr[n1] = arr[n2];
        arr[n2] = temp;
    }
}
