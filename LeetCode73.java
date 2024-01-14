public class LeetCode73 {
    //给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
    public void setZeroes(int[][] matrix) {
        int rows=matrix.length,cols=matrix[0].length;
        boolean[] rowRecord=new boolean[rows];
        boolean[] colRecord=new boolean[cols];

        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                if(matrix[i][j]==0) {
                    rowRecord[i]=true;
                    colRecord[j]=true;
                }
            }
        }

        for(int i=0;i<rowRecord.length;i++) {
            if(rowRecord[i]) {
                for(int j=0;j<cols;j++) {
                    matrix[i][j]=0;
                }
            }
        }

        for(int i=0;i<colRecord.length;i++) {
            if(colRecord[i]) {
                for(int j=0;j<rows;j++) {
                    matrix[j][i]=0;
                }
            }
        }
    }
}
