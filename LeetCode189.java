public class LeetCode189 {

    //给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
    public void rotate(int[] nums, int k) {
        //rotate1(nums,k);
        //rotate2(nums,k);
        rotate3(nums,k);
    }

    public void rotate1(int[] nums,int k) {
        int[] temp=new int[2*nums.length];
        for(int i=0;i<nums.length;i++) {
            temp[i]=nums[i];
        }

        for(int i=0;i<nums.length;i++) {
            temp[i+nums.length]=nums[i];
        }

        for(int i=0;i<nums.length;i++) {
            nums[i]=temp[i+nums.length-k%nums.length];
        }

    }

    public void rotate2(int[] nums,int k) {
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k%nums.length-1);
        reverse(nums,k%nums.length,nums.length-1);
    }

    public void reverse(int[] nums,int left,int right) {
        while(left<right) {
            int temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
            left++;
            right--;
        }
    }
    public void rotate3(int[] nums,int k) {
        for(int i=0;i<k%nums.length;i++) {
            int temp=nums[nums.length-1];
            for(int j=nums.length-2;j>=0;j--) {
                nums[j+1]=nums[j];
            }
            nums[0]=temp;
        }

    }
}
