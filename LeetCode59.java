/**
 * @author yun
 * @date 2025/2/13 23:03
 * @desciption: 59. 螺旋矩阵 II
 */
public class LeetCode59 {
    public int[][] generateMatrix(int n) {
        int total = n * n;
        int[][] ret = new int[n][n];
        int[][] advance = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        boolean[][] check = new boolean[n][n];
        int x = 0, y = 0;
        if (n == 1) {
            return new int[][]{{1}};
        }
        ret[0][0] = 1;
        check[0][0] = true;
        int count = 0;
        for (int i = 2; i <= total; i++) {
            int tempX = x + advance[count % 4][0];
            int tempY = y + advance[count % 4][1];
            if (tempX >= 0 && tempX < n && tempY >= 0 && tempY < n && !check[tempX][tempY]) {
                ret[tempX][tempY] = i;
                check[tempX][tempY] = true;
                x = tempX;
                y = tempY;
            } else {
                count++;
                x += advance[count % 4][0];
                y += advance[count % 4][1];
                check[x][y] = true;
                ret[x][y] = i;
            }
        }
        return ret;
    }
}
