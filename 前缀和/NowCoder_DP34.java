import java.util.Scanner;

public class NowCoder_DP34 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        long[] nums = new long[n + 1];
        long[] dp = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            nums[i] = in.nextInt();
            dp[i] = dp[i - 1] + nums[i];
        }

        for (int i = 0; i < q; i++) {
            int l = in.nextInt();
            int r = in.nextInt();

            System.out.println(dp[r] - dp[l] + nums[l]);
        }
    }
}
