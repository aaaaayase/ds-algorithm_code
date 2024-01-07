public class LeetCode7 {

    //给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
    //
    //如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
    //
    //假设环境不允许存储 64 位整数（有符号或无符号）。
    public int reverse(int x) {
        int reverseNum=0;
        while (x!=0) {
            int digit=x%10;
            if(reverseNum>Integer.MAX_VALUE/10 || (reverseNum==Integer.MAX_VALUE/10&&digit>7)) {
                return 0;
            }

            if(reverseNum<Integer.MIN_VALUE/10 || (reverseNum==Integer.MIN_VALUE/10&&digit<-8)) {
                return 0;
            }
            reverseNum=reverseNum*10+digit;
            x/=10;
        }

        return reverseNum;
    }

}
