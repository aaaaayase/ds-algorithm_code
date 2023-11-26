package day1;


public class demo1 {
    /*
       二分查找基础版
       param:arr-待查找升序数组
             target-待查找目标值
       returns:
             找到返回索引
             找不到返回-1
     */
    public static int binarySearchBasic(int arr[], int target) {


        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {

            int mid = (left + right) >>> 1;
            if (arr[mid] < target) {
                left = mid + 1;
            } else if (target < arr[mid]) {
                right = mid - 1;
            } else {

                return mid;
            }
        }
        return -1;
    }

    /*
       二分查找改动版
       param:arr-待查找升序数组
             target-待查找目标值
       returns:
             找到返回索引
             找不到返回-1
     */
    public static int binarySearchAlternative(int arr[], int target) {


        int left = 0;
        int right = arr.length; // 1
        while (left < right) { // 2

            int mid = (left + right) >>> 1;
            if (arr[mid] < target) {
                left = mid + 1;
            } else if (target < arr[mid]) {
                right = mid; // 3
            } else {

                return mid;
            }
        }
        return -1;
    }

}
