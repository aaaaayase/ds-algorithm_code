import java.util.Scanner;

public class NowCoder_DP41 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int v = in.nextInt();

            int[][] things = new int[n][2];
            for (int i = 0; i < n; i++) {
                int vol = in.nextInt();
                int val = in.nextInt();

                things[i][0] = vol;
                things[i][1] = val;
            }


            int[][] f = new int[n + 1][v + 1];
            int[][] g = new int[n + 1][v + 1];

            for (int i = 1; i <= v; i++) {
                g[0][i] = -1;
            }

            for (int i = 1; i <= n; i++) {

                for (int j = 1; j <= v; j++) {
                    f[i][j] = f[i - 1][j];
                    if (j - things[i - 1][0] >= 0) {
                        f[i][j] = Math.max(f[i][j],
                                f[i - 1][j - things[i - 1][0]] + things[i - 1][1]);
                    }
                    g[i][j] = g[i - 1][j];
                    if (j - things[i - 1][0] >= 0 && g[i - 1][j - things[i - 1][0]] != -1) {
                        g[i][j] = Math.max(g[i][j],
                                g[i - 1][j - things[i - 1][0]] + things[i - 1][1]);
                    }
                }
            }

            System.out.println(f[n][v]);
            System.out.println(g[n][v] == -1 ? 0 : g[n][v]);
        }
    }


}
