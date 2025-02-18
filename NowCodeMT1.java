package rabbitmq.simple;

/**
 * @author yun
 * @date 2025/2/18 22:52
 * @desciption: MT1 最大差值
 */
public class NowCodeMT1 {
    public int getDis (int[] A, int n) {
        // write code here
        int ret=0;
        int min=A[0];
        for (int i = 1; i < A.length; i++) {
            min=Math.min(min,A[i]);
            ret=Math.max(ret,A[i]-min);
        }

        return ret;
    }
}
