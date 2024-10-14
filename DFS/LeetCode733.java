public class LeetCode733 {
    int m;
    int n;
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    int pre;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        m = image.length;
        n = image[0].length;

        if (image[sr][sc] == color) {
            return image;
        }

        pre = image[sr][sc];
        dfs(image, sr, sc, color);

        return image;
    }

    public void dfs(int[][] image, int i, int j, int color) {
        image[i][j] = color;
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k], y = j + dy[k];
            if (x >= 0 && x < m && y >= 0 && y < n && pre == image[x][y]) {
                dfs(image, x, y, color);
            }

        }

    }
}
