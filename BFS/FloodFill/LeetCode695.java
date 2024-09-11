package org.yun.dailycode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode695 {
    int m, n;
    boolean[][] vis;
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        vis = new boolean[m][n];
        int ret = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !vis[i][j]) {
                    ret = Math.max(bfs(grid, i, j), ret);
                }
            }
        }

        return ret;
    }

    public int bfs(int[][] grid, int i, int j) {
        int ret = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        vis[i][j] = true;

        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int a = tmp[0], b = tmp[1];
            for (int k = 0; k < 4; k++) {
                int x = a + dx[k], y = b + dy[k];
                if (x >= 0 && x < m && y >= 0 && y < n && !vis[x][y] && grid[x][y] == 1) {
                    queue.add(new int[]{x, y});
                    vis[x][y] = true;
                    ret++;
                }
            }

        }
        return ret;
    }
}
