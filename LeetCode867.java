public class LeetCode867 {
    //给你一个二维整数数组 matrix， 返回 matrix 的 转置矩阵 。
    //
    //矩阵的 转置 是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
    public int[][] transpose(int[][] matrix) {
        int[][] newMatrix=new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {

            for (int i1 = 0; i1 < matrix[i].length; i1++) {
                newMatrix[i1][i]=matrix[i][i1];
            }
        }

        return newMatrix;
    }
}
