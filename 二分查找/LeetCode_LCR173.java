public class LeetCode_LCR173 {
    public int takeAttendance(int[] records) {
        int left = 0, right = records.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (records[mid] - mid == 0) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return records[right] == right ? right + 1 : right;
    }
}
