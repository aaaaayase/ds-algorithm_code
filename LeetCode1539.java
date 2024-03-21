public class LeetCode1539 {
    //给你一个 严格升序排列 的正整数数组 arr 和一个整数 k 。
    //
    //请你找到这个数组里第 k 个缺失的正整数。
    public int findKthPositive(int[] arr, int k) {
        int num = 1;
        int count = 0;
        int i = 0;
        while (i < arr.length) {
            if (count == k) {
                return num - 1;
            }
            if (num < arr[i]) {
                num++;
                count++;
            } else if (num == arr[i]) {
                num++;
                i++;
            }
        }

        if (i == arr.length) {
            count++;
            while (count != k) {
                num++;
                count++;

            }
        }

        return num;
    }
}
