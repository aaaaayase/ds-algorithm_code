package org.yun.dailycode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode130 {
    int m, n;
    int[] dx = { 1, -1, 0, 0 };
    int[] dy = { 0, 0, 1, -1 };

    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;

        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') {
                bfs(board, 0, i);
            }
            if (board[m - 1][i] == 'O') {
                bfs(board, m - 1, i);
            }
        }

        for (int i = 1; i < m - 1; i++) {
            if (board[i][0] == 'O') {
                bfs(board, i, 0);
            }
            if (board[i][n - 1] == 'O') {
                bfs(board, i, n - 1);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'Y') {
                    board[i][j] = 'O';
                }
            }
        }

    }

    public void bfs(char[][] board, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { i, j });
        board[i][j] = 'Y';
        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int a = tmp[0], b = tmp[1];
            for (int k = 0; k < 4; k++) {
                int x = a + dx[k], y = b + dy[k];
                if (x >= 0 && x < m && y >= 0 && y < n&& board[x][y] == 'O') {
                    queue.add(new int[] { x, y });
                    board[x][y] = 'Y';
                }
            }
        }
    }
}
