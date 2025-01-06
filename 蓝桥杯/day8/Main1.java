import java.util.Scanner;

/**
 * @author yun
 * @date 2025/1/6 9:59
 * @desciption: 刷题统计
 */

public class Main1 {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);

        long a=in.nextLong();
        long b=in.nextLong();
        long n=in.nextLong();

        long sum=0;
        long day=0;
        while(sum<n) {
            for(int i=0;sum<n&&i<5;i++) {
                sum+=a;
                day++;
            }
            for(int i=0;sum<n&&i<2;i++) {
                sum+=b;
                day++;
            }
        }

        System.out.println(day);
    }

}
