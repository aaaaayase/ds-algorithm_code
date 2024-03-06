public class NowCoder_NC32 {
    //实现函数 int sqrt(int x).
    //计算并返回 x 的平方根（向下取整）
    public int sqrt (int x) {
        // write code here


        //return (int)Math.sqrt(x);

        if (x <= 0) {
            return 0;
        }

        int i = 1;
        for (; i <= x; i++) {
            if (i <= x / i && i + 1 > x / (i + 1)) {
                break;
            }
        }
        return i;

    }
}
