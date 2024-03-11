public class LeetCode4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
//
//算法的时间复杂度应该为 O(log (m+n)) 。
        int s1 = 0;
        int s2 = 0;

        int e1 = nums1.length - 1;
        int e2 = nums2.length - 1;

        int[] arr = new int[nums1.length + nums2.length];
        int index=0;
        while (s1 <= e1 && s2 <= e2) {
            if (nums1[s1] < nums2[s2]) {
                arr[index++]=nums1[s1++];
            } else {
                arr[index++]=nums2[s2++];
            }
        }

        while (s1<=e1) {
            arr[index++]=nums1[s1++];
        }

        while (s2<=e2) {
            arr[index++]=nums2[s2++];
        }

        if(index%2==0) {
            return (double)(arr[(index-1)/2]+arr[(index-1)/2+1])/2;
        }
        return (double)arr[(index-1)/2];
    }
}
