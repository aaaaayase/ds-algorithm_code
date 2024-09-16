package org.yun.dailycode;

import java.util.*;

public class LeetCode675 {
    int m, n;

    public int cutOffTree(List<List<Integer>> forest) {
        m = forest.size();
        n = forest.get(0).size();
        List<int[]> trees = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (forest.get(i).get(j) > 1) {
                    trees.add(new int[]{i, j});
                }
            }
        }
        Collections.sort(trees, (a, b) -> {
            return forest.get(a[0]).get(a[1]) - forest.get(b[0]).get(b[1]);
        });
        int ret = 0;
        int bx = 0, by = 0;
        for (int[] tree : trees) {
            int x = tree[0], y = tree[1];
            int step = bfs(forest, bx, by, x, y);
            if (step == -1) {
                return -1;
            }
            ret += step;
            bx = x;
            by = y;
        }
        return ret;
    }

    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public int bfs(List<List<Integer>> forest, int bx, int by, int ex, int ey) {
        if (ex == bx && ey == by) {
            return 0;
        }
        int step = 0;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[m][n];
        q.add(new int[]{bx, by});
        vis[bx][by] = true;
        while (!q.isEmpty()) {
            int sz = q.size();
            step++;
            while (sz-- != 0) {
                int[] temp = q.poll();
                int a = temp[0], b = temp[1];
                for (int i = 0; i < 4; i++) {
                    int x = a + dx[i], y = b + dy[i];
                    if (x >= 0 && x < m && y >= 0 && y < n && !vis[x][y] && forest.get(x).get(y) != 0) {
                        if (x == ex && y == ey) {
                            return step;
                        }
                        q.add(new int[]{x, y});
                        vis[x][y] = true;
                    }
                }
            }
        }
        return -1;
    }
}
