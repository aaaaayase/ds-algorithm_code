import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine(); // 清除换行符
        int num1 = 0, num2 = 0;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int[] arr = new int[100001]; // ID 范围为 [1, 100000]
        for (int i = 0; i < n; i++) {
            String line = input.nextLine();
            String[] nums = line.split(" ");
            for (String num : nums) {
                int temp = Integer.parseInt(num);
                if (++arr[temp] == 2) {
                    num2 = temp; // 找到重号
                }
                min = Math.min(min, temp);
                max = Math.max(max, temp);
            }
        }

        for (int i = min; i <= max; i++) {
            if (arr[i] == 0) {
                num1 = i;
                break;
            }
        }

        input.close();


        System.out.println(num1 + " " + num2);
    }
}
