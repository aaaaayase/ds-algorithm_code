public class LeetCode69 {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int right = x, left = 1;
        while (left < right) {
            long mid = left + (right - left + 1) / 2;
            if (mid * mid <= x) {
                left = (int) mid;
            } else {
                right = (int) mid - 1;
            }
        }
        return left;
    }
}
