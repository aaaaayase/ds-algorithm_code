public class LeetCode36 {
    boolean[][] row, col;
    boolean[][][] square;

    public boolean isValidSudoku(char[][] board) {

        row = new boolean[9][10];
        col = new boolean[9][10];
        square = new boolean[3][3][10];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    if (row[i][num] == true || col[j][num] == true || square[i / 3][j / 3][num] == true) {
                        return false;
                    } else {
                        row[i][num] = true;
                        col[j][num] = true;
                        square[i / 3][j / 3][num] = true;
                    }
                }

            }
        }
        return true;
    }
}
