public class LeetCode50 {
    //实现 pow(x, n) ，即计算 x 的整数 n 次幂函数。
    public double myPow(double x, int n) {

        long N = n;

        return N > 0 ? multiple(x, n) : 1.0 / multiple(x, -n);
    }

    public double multiple(double x, int n) {
        if (n == 0) {
            return 1;
        }

        double half = multiple(x, n / 2);

        return n % 2 != 0 ? x * half * half : half * half;
    }
}
