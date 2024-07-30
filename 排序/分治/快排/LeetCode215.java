import java.util.Random;

public class LeetCode215 {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    public int quickSelect(int[] arr, int l, int r, int k) {
        if (l >= r) {
            return arr[l];
        }
        int left = l - 1, right = r + 1, i = l;
        int key = arr[new Random().nextInt(r - l + 1) + l];
        while (i < right) {
            if (arr[i] < key) {
                swap(arr, ++left, i++);
            } else if (key == arr[i]) {
                i++;
            } else {
                swap(arr, --right, i);
            }
        }

        int b = right - left - 1;
        int c = r - right + 1;

        if (c >= k) {
            return quickSelect(arr, right, r, k);
        } else if (b + c >= k) {
            return key;
        } else {
            return quickSelect(arr, l, left, k - b - c);
        }
    }

    public void swap(int[] arr, int n1, int n2) {
        int temp = arr[n1];
        arr[n1] = arr[n2];
        arr[n2] = temp;
    }
}
