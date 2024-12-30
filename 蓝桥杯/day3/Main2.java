import java.util.Scanner;

public class Main2 {
    public static long[] sum;
    public static int x;
    public static int y;
    public static int n;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        sum = new long[n + 1];
        x = in.nextInt();
        for (int i = 1; i <= n - 1; i++) {
            sum[i] = sum[i - 1] + in.nextInt();
        }

        // 跳跃能力y需要满足的条件就是在y的区间内的石子高度需要大于等于2x
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(right);
    }

    public static boolean check(int y) {
        for (int i = y; i <= n - 1; i++) {
            if (sum[i] - sum[i - y] < 2L * x) {
                return false;
            }
        }
        return true;
    }

}