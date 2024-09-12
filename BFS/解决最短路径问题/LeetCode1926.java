package org.yun.dailycode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode1926 {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length, n = maze[0].length;
        boolean[][] vis = new boolean[m][n];
        int ret = 0;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{entrance[0], entrance[1]});
        vis[entrance[0]][entrance[1]] = true;
        while (!queue.isEmpty()) {
            ret++;
            int sz = queue.size();
            while (sz-- != 0) {
                int[] tmp = queue.poll();
                int a = tmp[0], b = tmp[1];
                for (int i = 0; i < 4; i++) {
                    int x = a + dx[i];
                    int y = b + dy[i];
                    if (x >= 0 && x < m && y >= 0 && y < n && !vis[x][y] && maze[x][y] == '.') {
                        queue.add(new int[]{x, y});
                        vis[x][y] = true;
                        if (x == 0 || x == m - 1 || y == 0 || y == n - 1) {
                            return ret;
                        }

                    }

                }
            }
        }
        return -1;
    }
}
