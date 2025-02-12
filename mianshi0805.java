/**
 * @author yun
 * @date 2025/2/12 22:48
 * @desciption: 面试题 08.05. 递归乘法
 */
public class mianshi0805 {
    public int multiply(int A, int B) {
        int min = Math.max(A, B);
        int max = Math.min(A, B);
        int ans = 0;
        for (int i = 0; min != 0; i++) {
            // 取出末尾的二进制数字
            int temp = min & 1;
            if (temp == 1) {
                ans += max << i;
            }
            min >>= 1;
        }
        return ans;
    }
}
