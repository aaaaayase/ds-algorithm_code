package rabbitmq.work;

/**
 * @author yun
 * @date 2025/3/8 10:38
 * @desciption: 240. 搜索二维矩阵 II
 */
public class LeetCode240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length;
        int x = 0, y = cols - 1;
        while (x < rows && y >= 0) {
            if (matrix[x][y] > target) {
                y--;
            } else if (matrix[x][y] < target) {
                x++;
            } else {
                return true;
            }

        }
        return false;
    }
}
