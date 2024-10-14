public class LeetCode79 {
    int[] dx = { 1, -1, 0, 0 };
    int[] dy = { 0, 0, 1, -1 };
    boolean[][] vis;
    int len;
    int n;
    int m;
    String word;

    public boolean exist(char[][] board, String _word) {

        m = board.length;
        n = board[0].length;

        vis = new boolean[m][n];
        word = _word;
        len = word.length();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word.charAt(0) == board[i][j]) {
                    vis[i][j] = true;
                    if (dfs(board, i, j, 1)) {
                        return true;
                    }
                    vis[i][j] = false;
                }

            }
        }

        return false;
    }

    public boolean dfs(char[][] board, int i, int j, int pos) {
        if (pos == len) {
            return true;
        }

        for (int k = 0; k < 4; k++) {
            int x = i + dx[k], y = j + dy[k];
            if (x >= 0 && x < m && y >= 0 && y < n && !vis[x][y] && board[x][y] == word.charAt(pos)) {
                vis[x][y] = true;
                if (dfs(board, x, y, pos + 1)) {
                    return true;
                }
                vis[x][y] = false;
            }
        }

        return false;

    }
}
