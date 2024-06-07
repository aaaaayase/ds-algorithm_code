public class LeetCode1089 {
    public void duplicateZeros(int[] arr) {
        int left = 0, right = -1;
        for (; left < arr.length; left++) {
            if (arr[left] == 0) {
                right += 2;
            } else {
                right++;
            }
            if (right >= arr.length - 1) {
                break;
            }
        }

        if (right == arr.length) {
            arr[arr.length - 1] = 0;
            right = arr.length - 2;
            left--;
        }
        int cur = left, dest = right;
        for (; cur >= 0; cur--) {
            if (arr[cur] == 0) {
                arr[dest] = 0;
                arr[dest - 1] = 0;
                dest -= 2;
            } else {
                arr[dest] = arr[cur];
                dest--;
            }
        }
    }
}
