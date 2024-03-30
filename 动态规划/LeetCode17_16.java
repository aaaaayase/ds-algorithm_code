public class LeetCode17_16 {
    //一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。
    // 在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。
    // 给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
    public int massage(int[] nums) {
        int n = nums.length;
        if(n==0) {
            return 0;
        }

        int[] f = new int[n];
        int[] g = new int[n];

        f[0] = nums[0];

        for (int i = 1; i < n; i++) {
            f[i] = g[i - 1] + nums[i];
            g[i] = Math.max(f[i - 1], g[i - 1]);
        }

        return Math.max(g[n - 1], f[n - 1]);
    }
}
