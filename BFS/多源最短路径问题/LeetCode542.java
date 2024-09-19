import java.util.LinkedList;
import java.util.Queue;

public class LeetCode542 {
    public int[][] updateMatrix(int[][] mat) {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        int m = mat.length;
        int n = mat[0].length;

        int[][] dis = new int[m][n];
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    dis[i][j] = 0;
                    q.add(new int[]{i, j});
                } else {
                    dis[i][j] = -1;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int a = temp[0], b = temp[1];
            for (int i = 0; i < 4; i++) {
                int x = a + dx[i], y = b + dy[i];
                if (x >= 0 && x < m && y >= 0 && y < n && dis[x][y] == -1) {
                    dis[x][y] = dis[a][b] + 1;
                    q.add(new int[]{x, y});
                }
            }
        }

        return dis;
    }

}
