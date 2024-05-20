import java.util.Scanner;

public class NowCoder_DP42 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int v = in.nextInt();

            int[] value = new int[n];
            int[] volume = new int[n];
            for (int i = 0; i < n; i++) {
                int num1 = in.nextInt();
                int num2 = in.nextInt();
                volume[i] = num1;
                value[i] = num2;
            }

            int[][] f = new int[n + 1][v + 1];
            int[][] g = new int[n + 1][v + 1];

            for (int i = 1; i <= v; i++) {
                g[0][i] = -1;
            }

            for (int i = 1; i <= n; i++) {

                for (int j = 0; j <= v; j++) {

                    f[i][j] = f[i - 1][j];
                    if (j >= volume[i - 1]) {
                        f[i][j] = Math.max(f[i][j], f[i][j - volume[i - 1]] + value[i - 1]);
                    }

                    g[i][j] = g[i - 1][j];
                    if (j >= volume[i - 1] && g[i][j - volume[i - 1]] != -1) {
                        g[i][j] = Math.max(g[i][j], g[i][j - volume[i - 1]] + value[i - 1]);
                    }

                }
            }
            System.out.println(f[n][v]);
            System.out.println(g[n][v] == -1 ? 0 : g[n][v]);
        }
    }
}
