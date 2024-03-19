public class LeetCode367 {
    public boolean isPerfectSquare(int num) {
        long l = 0;
        long r = num;

        while (l < r) {
            long mid = (l + r + 1) / 2;
            if (mid * mid <= num) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }

        return (l * l) == num;

    }
}
