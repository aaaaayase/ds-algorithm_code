package org.yun.dailycode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode200 {
    int m, n;
    boolean[][] vis;
    int[] dx = { 0, 0, 1, -1 };
    int[] dy = { 1, -1, 0, 0 };

    public int numIslands(char[][] grid) {
        int ret = 0;
        m = grid.length;
        n = grid[0].length;

        vis = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !vis[i][j]) {
                    dfs(grid, i, j);
                    ret++;
                }
            }
        }

        return ret;
    }

    public void bfs(char[][] grid, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { i, j });
        vis[i][j]=true;
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int a = temp[0], b = temp[1];
            for (int k = 0; k < 4; k++) {
                int x = a + dx[k], y = b + dy[k];
                if (x >= 0 && x < m && y >= 0 && y < n && !vis[x][y] && grid[x][y] == '1') {
                    queue.add(new int[] { x, y });
                    vis[x][y]=true;
                }
            }
        }

    }
}
