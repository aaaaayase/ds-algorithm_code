public class LeetCode1219 {
    int ret;
    boolean[][] vis;
    int[] dx = { 1, -1, 0, 0 };
    int[] dy = { 0, 0, 1, -1 };
    int m;
    int n;

    public int getMaximumGold(int[][] grid) {

        m = grid.length;
        n = grid[0].length;

        vis = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    vis[i][j] = true;
                    dfs(grid, i, j, grid[i][j]);
                    vis[i][j] = false;
                }
            }
        }

        return ret;
    }

    public void dfs(int[][] grid, int i, int j, int path) {

        ret = Math.max(ret, path);

        for (int k = 0; k < 4; k++) {
            int x = i + dx[k], y = j + dy[k];
            if (x >= 0 && x < m && y >= 0 && y < n && !vis[x][y] && grid[x][y] != 0) {
                path += grid[x][y];
                vis[x][y] = true;
                dfs(grid, x, y, path);
                vis[x][y] = false;
                path -= grid[x][y];
            }
        }
    }
}
