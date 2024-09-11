package org.yun.dailycode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode130 {
    int m, n;
    boolean[][] vis;
    int[] dx = { 1, -1, 0, 0 };
    int[] dy = { 0, 0, 1, -1 };

    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;
        vis = new boolean[m][n];

        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O' && !vis[0][i]) {
                bfs(board, 0, i);
            }
            if (board[m - 1][i] == 'O' && !vis[m - 1][i]) {
                bfs(board, m - 1, i);
            }
        }

        for (int i = 1; i < m - 1; i++) {
            if (board[i][0] == 'O' && !vis[i][0]) {
                bfs(board, i, 0);
            }
            if (board[i][n - 1] == 'O' && !vis[i][n - 1]) {
                bfs(board, i, n - 1);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'Y') {
                    board[i][j] = 'O';
                }
            }
        }

    }

    public void bfs(char[][] board, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { i, j });
        vis[i][j] = true;
        board[i][j] = 'Y';
        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int a = tmp[0], b = tmp[1];
            for (int k = 0; k < 4; k++) {
                int x = a + dx[k], y = b + dy[k];
                if (x >= 0 && x < m && y >= 0 && y < n && !vis[x][y] && board[x][y] == 'O') {
                    queue.add(new int[] { x, y });
                    vis[x][y] = true;
                    board[x][y] = 'Y';
                }
            }
        }
    }
}
