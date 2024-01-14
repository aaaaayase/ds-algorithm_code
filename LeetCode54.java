import java.util.ArrayList;
import java.util.List;

public class LeetCode54 {
    //给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ret=new ArrayList<Integer>();
        if(matrix==null || matrix.length==0 || matrix[0].length==0) {
            return ret;
        }
        int rows=matrix.length,cols=matrix[0].length;
        boolean[][] visited=new boolean[rows][cols];
        int total=rows*cols;
        int row=0,col=0;
        int[][] direct={{1,0},{0,1},{-1,0},{0,-1}};
        int directIndex=0;
        for(int i=0;i<total;i++) {
            ret.add(matrix[row][col]);
            visited[row][col]=true;
            int nextRow=row+direct[directIndex][1],nextCol=col+direct[directIndex][0];
            if(nextCol<0 || nextCol>=cols || nextRow<0 || nextRow>=rows || visited[nextRow][nextCol]) {
                directIndex=(directIndex+1)%4;
            }
            row=row+direct[directIndex][1];
            col=col+direct[directIndex][0];
        }
        return ret;

    }
}
