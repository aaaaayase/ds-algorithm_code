public class LeetCode1281 {
    //给你一个整数 n，请你帮忙计算并返回该整数「各位数字之积」与「各位数字之和」的差。
    public int subtractProductAndSum(int n) {
        return support(n);
    }

    public int support(int n) {
        int mut = 1;
        int sum = 0;
        while (n != 0) {
            int temp = n % 10;
            sum += temp;
            mut *= temp;
            n /= 10;
        }
        return mut-sum;
    }
}
