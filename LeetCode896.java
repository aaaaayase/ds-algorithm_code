public class LeetCode896 {
    //如果数组是单调递增或单调递减的，那么它是 单调 的。
    //
    //如果对于所有 i <= j，nums[i] <= nums[j]，那么数组 nums 是单调递增的。 如果对于所有 i <= j，nums[i]> = nums[j]，那么数组 nums 是单调递减的。
    //
    //当给定的数组 nums 是单调数组时返回 true，否则返回 false。
    public boolean isMonotonic(int[] nums) {

        return isMonotonic2(nums);
    }


    public boolean isMonotonic1(int[] nums) {
        if(nums.length==1) {
            return true;
        }
        boolean flg=true;
        int k=1;
        while(k<nums.length&&nums[0]==nums[k]) {
            k++;
        }
        if(k==nums.length) {
            return true;
        }
        if(nums[k]-nums[0]>0) {
            for(int i=1;i<nums.length;i++) {
                if(nums[i]-nums[i-1]<0) {
                    flg=false;
                }
            }
        } else if(nums[k]-nums[0]<0){
            for(int i=1;i<nums.length;i++) {
                if(nums[i]-nums[i-1]>0) {
                    flg=false;
                }
            }
        }


        return flg;
    }

    public boolean isMonotonic2(int[] nums) {
        boolean inc=true,der=true;
        for(int i=1;i<nums.length;i++) {
            if(nums[i]-nums[i-1]<0) {
                inc=false;
            }

            if(nums[i]-nums[i-1]>0) {
                der=false;
            }

        }
        return inc||der;
    }
}
