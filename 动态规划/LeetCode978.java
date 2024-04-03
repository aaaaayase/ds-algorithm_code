public class LeetCode978 {
    //给定一个整数数组 arr ，返回 arr 的 最大湍流子数组的长度 。
    //
    //如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是 湍流子数组 。
    //
    //更正式地来说，当 arr 的子数组 A[i], A[i+1], ..., A[j] 满足仅满足下列条件时，我们称其为湍流子数组：
    //
    //若 i <= k < j ：
    //当 k 为奇数时， A[k] > A[k+1]，且
    //当 k 为偶数时，A[k] < A[k+1]；
    //或 若 i <= k < j ：
    //当 k 为偶数时，A[k] > A[k+1] ，且
    //当 k 为奇数时， A[k] < A[k+1]。

    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;

        //以向上为结束的最长湍流子数组
        int[] f = new int[n];
        int[] g = new int[n];


        for (int i = 0; i < n; i++) {
            f[i] = 1;
            g[i] = 1;
        }

        int max = 1;

        for (int i = 1; i < n; i++) {

            if (arr[i] > arr[i - 1]) {
                f[i] = g[i - 1] + 1;
            } else if (arr[i] < arr[i - 1]) {
                g[i] = f[i - 1] + 1;
            }

            if (Math.max(f[i], g[i]) > max) {
                max = Math.max(f[i], g[i]);
            }

        }

        return max;
    }
}