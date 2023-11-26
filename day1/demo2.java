package day1;

import java.util.ArrayList;
import java.util.List;

public class demo2 {
    //    杨辉三角
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        list.add(1);
        ret.add(list);

        for (int i = 1; i < numRows; i++) {
            //处理第一个
            List<Integer> curRow = new ArrayList<>();
            curRow.add(1);

            //处理中间
            List<Integer> prevRow = ret.get(i - 1);
            for (int j = 1; j < i; j++) {

                curRow.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            //处理最后
            curRow.add(1);

            //加入顺序表
            ret.add(curRow);
        }
        return ret;
    }
}
