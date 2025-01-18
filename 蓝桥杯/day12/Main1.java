import java.util.Scanner;

/**
 * @author yun
 * @date 2025/1/15 11:22
 * @desciption: 特殊年份
 */
public class Main1 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int[] nums = new int[5];

        for (int i = 0; i < 5; i++) {
            nums[i] = in.nextInt();
        }
        int count = 0;
        for (int i = 0; i < 5; i++) {
            int a = nums[i] % 10;
            int b = nums[i] / 10 % 10;
            int c = nums[i] / 100 % 10;
            int d = nums[i] / 1000;
            if (a - 1 == c && b == d) {
                count++;

            }
        }
        System.out.println(count);
    }
}
