package day9;

public class demo1 {

    //给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
    //
    //回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
    //
    //例如，121 是回文，而 123 不是。
    public boolean isPalindrome(int x) {
        int len = 0;
        int temp = x;
        if (x < 0) {
            return false;
        }
        while (temp != 0) {
            temp /= 10;
            len++;
        }

        int[] arr = new int[len];
        temp = len;
        while (x != 0) {
            arr[temp - 1] = x % 10;
            x /= 10;
            temp--;
        }

        int right = len - 1;
        int left = 0;

        while (left < right) {
            if (arr[left] != arr[right]) {
                return false;
            }
            right--;
            left++;
        }
        return true;
    }

}
