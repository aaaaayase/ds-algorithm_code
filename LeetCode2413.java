public class LeetCode2413 {
    //给你一个正整数 n ，返回 2 和 n 的最小公倍数（正整数）。
    public int smallestEvenMultiple(int n) {
        int max = (2 >= n ? 2 : n);
        while (true) {
            if (max % 2 == 0 && max % n == 0) {
                return max;
            }
            max++;
        }
    }
}
