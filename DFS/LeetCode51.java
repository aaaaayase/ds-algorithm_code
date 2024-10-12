import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode51 {
    List<List<String>> ret;
    char[][] path;
    int n;
    boolean[] checkCol, check1, check2;

    public List<List<String>> solveNQueens(int _n) {

        n = _n;
        ret = new ArrayList<>();
        path = new char[n][n];
        checkCol = new boolean[n];
        check1 = new boolean[2 * n];
        check2 = new boolean[2 * n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(path[i], '.');
        }

        dfs(0);

        return ret;
    }

    public void dfs(int row) {
        if (row == n) {
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                temp.add(new String(path[i]));
            }
            ret.add(temp);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (checkCol[i] == false && check1[row - i + n] == false && check2[row + i] == false) {
                path[row][i] = 'Q';
                checkCol[i] = true;
                check1[row - i + n] = true;
                check2[row + i] = true;
                dfs(row + 1);
                path[row][i] = '.';
                checkCol[i] = false;
                check1[row - i + n] = false;
                check2[row + i] = false;
            }

        }
    }
}
