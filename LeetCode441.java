public class LeetCode441 {
    public int arrangeCoins(int n) {
        long l = 0;
        long r = n;

        while (l < r) {

            long mid = (l + r + 1) / 2;
            if ((mid + 1) * mid / 2 <= n) {
                l = mid;
            } else {
                r = mid - 1;
            }

        }

        return (int) l;
    }
}
