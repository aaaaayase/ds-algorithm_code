public class LeetCode980 {
    int m, n;
    boolean[][] vis;
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    int step;
    int count;

    public int uniquePathsIII(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        vis = new boolean[m][n];
        step = 2;

        int bx = 0, by = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    step++;
                } else if (grid[i][j] == 1) {
                    bx = i;
                    by = j;
                }
            }

        }

        vis[bx][by] = true;
        dfs(grid, bx, by, 1);
        vis[bx][by] = false;

        return count;

    }

    public void dfs(int[][] grid, int i, int j, int len) {
        if (grid[i][j] == 2) {
            if (len == step) {
                count++;
            }
            return;
        }

        for (int k = 0; k < 4; k++) {
            int x = i + dx[k], y = j + dy[k];
            if (x >= 0 && x < m && y >= 0 && y < n && !vis[x][y] && grid[x][y] != -1) {
                vis[x][y] = true;
                dfs(grid, x, y, len + 1);
                vis[x][y] = false;
            }
        }
    }
}
