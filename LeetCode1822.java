public class LeetCode1822 {
    //已知函数 signFunc(x) 将会根据 x 的正负返回特定值：
    //
    //如果 x 是正数，返回 1 。
    //如果 x 是负数，返回 -1 。
    //如果 x 是等于 0 ，返回 0 。
    //给你一个整数数组 nums 。令 product 为数组 nums 中所有元素值的乘积。
    //
    //返回 signFunc(product) 。
    public int arraySign(int[] nums) {
        int sum=1;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]==0) {
                return signFunc(0);
            } else if(nums[i]<0) {
                sum*=-1;
            }
        }
        return signFunc(sum);
    }

    public int signFunc(int n) {
        if(n<0) {
            return -1;
        } else if(n==0) {
            return 0;
        } else {
            return 1;
        }
    }
}
