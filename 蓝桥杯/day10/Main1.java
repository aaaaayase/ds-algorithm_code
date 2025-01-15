import java.util.Scanner;

/**
 * @author yun
 * @date 2025/1/15 11:22
 * @desciption: 好数
 */
public class Main1 {
    public static void main(String[] args) {

        Scanner in=new Scanner(System.in);

        int input=in.nextInt();
        int count=0;
        for(int i=1;i<=input;i++) {
            if(check(i)) {
                count++;
            }
        }
        System.out.println(count);
    }

    public static boolean check(int num) {
        int count=1;
        while(num!=0) {
            int temp=num%10;
            if((count%2==1&&temp%2==0)||(count%2==0&&temp%2==1)) {
                return false;
            }
            num/=10;
            count++;
        }

        return true;
    }
}
