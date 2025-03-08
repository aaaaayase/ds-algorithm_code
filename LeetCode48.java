package rabbitmq.work;

/**
 * @author yun
 * @date 2025/3/8 10:23
 * @desciption: 48. 旋转图像
 */
public class LeetCode48 {
    public void rotate(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] temp = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                temp[i][j] = matrix[i][j];
            }
        }

        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                matrix[j][cols-i-1]=temp[i][j];
            }
        }


    }
}
