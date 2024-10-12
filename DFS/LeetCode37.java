public class LeetCode37 {
    boolean[][] row, col;
    boolean[][][] square;

    public void solveSudoku(char[][] board) {
        row = new boolean[9][10];
        col = new boolean[9][10];
        square = new boolean[3][3][10];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    row[i][num] = true;
                    col[j][num] = true;
                    square[i / 3][j / 3][num] = true;
                }

            }
        }
        dfs(board);
    }

    public boolean dfs(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (int num = 1; num <= 9; num++) {
                        if (!row[i][num] && !col[j][num] && !square[i / 3][j / 3][num]) {
                            board[i][j] = (char) ('0' + num);
                            row[i][num] = true;
                            col[j][num] = true;
                            square[i / 3][j / 3][num] = true;
                            // 这个dfs会把剩下的所以空都给填了 所以当它返回为true时就意味着已经完成全部填写
                            // 此时自然就是完成了全部操作了
                            if (dfs(board) == true) {
                                return true;
                            }
                            board[i][j] = '.';
                            row[i][num] = false;
                            col[j][num] = false;
                            square[i / 3][j / 3][num] = false;
                        }

                    }
                    // 当你尝试所以数字都不能满足条件 自然返回false
                    return false;
                }

            }
        }
        // 说明已经填满不需要你再去填
        return true;
    }
}
