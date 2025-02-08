/**
 * @author yun
 * @date 2025/2/8 15:03
 * @desciption: 54. 螺旋矩阵
 */
public class LeetCode54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int row=matrix.length;
        int col=matrix[0].length;

        List<Integer> ret=new ArrayList<>();
        boolean[][] vis=new boolean[row][col];
        int[][] move={{0,1},{1,0},{0,-1},{-1,0}};
        int count=0;
        int x=0,y=0;
        for(int i=0;i<row*col;i++) {
            vis[x][y]=true;
            ret.add(matrix[x][y]);
            int tempX=x+move[count%4][0];
            int tempY=y+move[count%4][1];
            if(tempX>=row||tempX<0||tempY>=col||tempY<0||vis[tempX][tempY]) {
                count++;
                tempX=x+move[count%4][0];
                tempY=y+move[count%4][1];
            }
            x=tempX;
            y=tempY;
        }
        return ret;
    }
}
