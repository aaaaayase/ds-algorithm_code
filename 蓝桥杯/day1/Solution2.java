import java.util.ArrayList;
import java.util.List;

/**
 * @author yun
 * @date 2024/12/28 11:49
 * @desciption: 杨辉三角
 */
public class Solution2 {
    public List<List<Integer>> generate(int numRows) {
        if(numRows==0) {
            return null;
        }
        int[][] arr=new int[numRows+1][numRows+1];
        arr[1][1]=1;
        for(int i=2;i<=numRows;i++) {
            for(int j=1;j<=i;j++) {
                arr[i][j]=arr[i-1][j]+arr[i-1][j-1];
            }
        }

        List<List<Integer>> ret=new ArrayList<>();
        for(int i=1;i<=numRows;i++) {
            List<Integer> list=new ArrayList<>();
            for(int j=1;j<=i;j++) {
                list.add(arr[i][j]);
            }
            ret.add(list);
        }
        return ret;
    }
}
