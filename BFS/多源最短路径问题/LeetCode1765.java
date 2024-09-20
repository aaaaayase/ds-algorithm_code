import java.util.LinkedList;
import java.util.Queue;

public class LeetCode1765 {
    public int[][] highestPeak(int[][] isWater) {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        int m = isWater.length;
        int n = isWater[0].length;

        int[][] ret = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ret[i][j] = -1;
            }
        }

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    q.add(new int[]{i, j});
                    ret[i][j] = 0;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int a = temp[0], b = temp[1];
            for (int i = 0; i < 4; i++) {
                int x = a + dx[i], y = b + dy[i];
                if (x >= 0 && x < m && y >= 0 && y < n && ret[x][y] == -1) {
                    ret[x][y] = ret[a][b] + 1;
                    q.add(new int[]{x, y});
                }
            }
        }

        return ret;
    }
}
