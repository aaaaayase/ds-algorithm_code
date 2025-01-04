import java.util.Scanner;

/**
 * @author yun
 * @date 2025/1/4 9:42
 * @desciption: 乘法表
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int P = in.nextInt();
        for (int i = 1; i <= P - 1; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(transfer(i, P) + "*" + transfer(j, P) + "=" + transfer(i * j, P) + " ");
            }
            System.out.println();
        }
    }

    public static String transfer(int num, int base) {
        StringBuilder str = new StringBuilder();

        while (num != 0) {
            int remain = num % base;
            if (remain >= 10) {
                str.insert(0, (char) ('A' + remain - 10));
            } else {
                str.insert(0, (char) (remain + '0'));
            }

            num /= base;
        }

        return str.toString();
    }
}
