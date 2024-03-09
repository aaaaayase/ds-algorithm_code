public class LeetCode263 {
    //丑数 就是只包含质因数 2、3 和 5 的正整数。
    //
    //给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false 。
    public boolean isUgly(int n) {
        if(n==0) {
            return false;
        }

        while(true) {

            if(n%5!=0) {
                break;
            }
            n/=5;

        }

        while(true) {

            if(n%3!=0) {
                break;
            }
            n/=3;

        }

        while(true) {

            if(n%2!=0) {
                break;
            }
            n/=2;

        }





        if(n==1) {
            return true;
        }

        return false;

    }
}
