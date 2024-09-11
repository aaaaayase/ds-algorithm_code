package org.yun.dailycode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int prev = image[sr][sc];
        if (prev == color) {
            return image;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { sr, sc });

        int[] dx = { 1, -1, 0, 0 };
        int[] dy = { 0, 0, 1, -1 };

        int m = image.length, n = image[0].length;

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int i = temp[0], j = temp[1];
            image[i][j] = color;
            for (int k = 0; k < 4; k++) {
                int x = i + dx[k], y = j + dy[k];
                if (x < m && x >= 0 && y >= 0 && y < n && image[x][y] == prev) {
                    queue.add(new int[] { x, y });
                }
            }
        }

        return image;

    }
}
