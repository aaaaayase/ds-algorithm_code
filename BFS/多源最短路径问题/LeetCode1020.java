import java.util.LinkedList;
import java.util.Queue;

public class LeetCode1020 {
    public int numEnclaves(int[][] grid) {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        int m = grid.length, n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    if (grid[i][j] == 1) {
                        vis[i][j] = true;
                        queue.add(new int[]{i, j});
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int a = temp[0], b = temp[1];
            for (int i = 0; i < 4; i++) {
                int x = a + dx[i], y = b + dy[i];
                if (x >= 0 && x < m && y >= 0 && y < n && !vis[x][y] && grid[x][y] == 1) {
                    vis[x][y] = true;
                    queue.add(new int[]{x, y});
                }
            }
        }
        int ret = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !vis[i][j]) {
                    ret++;
                }
            }
        }

        return ret;
    }
}
