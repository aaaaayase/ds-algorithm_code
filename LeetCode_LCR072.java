/**
 * @author yun
 * @date 2025/2/6 15:09
 * @desciption: LCR 072. x 的平方根
 */
public class LeetCode_LCR072 {
    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        int ans = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long) mid * mid > x) {
                right = mid - 1;
            } else {
                ans = mid;
                left = mid + 1;
            }

        }
        return ans;
    }
}
