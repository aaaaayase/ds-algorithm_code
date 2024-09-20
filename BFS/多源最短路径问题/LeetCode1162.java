import java.util.LinkedList;
import java.util.Queue;

public class LeetCode1162 {
    public int maxDistance(int[][] grid) {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        int m = grid.length;
        int n = grid[0].length;

        int[][] dis = new int[m][n];

        Queue<int[]> q = new LinkedList<>();
        boolean flg1 = false;
        boolean flg2 = false;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dis[i][j] = -1;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    flg1 = true;
                    q.add(new int[]{i, j});
                    dis[i][j] = 0;
                } else {
                    flg2 = true;
                }

            }
        }

        if (!(flg1 && flg2)) {
            return -1;
        }

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int a = temp[0], b = temp[1];

            for (int i = 0; i < 4; i++) {
                int x = a + dx[i];
                int y = b + dy[i];
                if (x >= 0 && x < m && y >= 0 && y < n && dis[x][y] == -1) {
                    dis[x][y] = dis[a][b] + 1;
                    q.add(new int[]{x, y});
                }
            }
        }
        int ret = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    ret = Math.max(ret, dis[i][j]);
                }
            }

        }

        return ret;
    }

}
