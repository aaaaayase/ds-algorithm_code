public class LeetCode258 {

    //给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。返回这个结果。
    public int addDigits(int num) {
        while(num>=10) {
            num=support(num);
        }
        return num;
    }

    public int support(int num) {
        int temp = 0;
        int sum = 0;
        while (num != 0) {
            temp = num % 10;
            sum += temp;
            num /= 10;
        }
        return sum;
    }
}
