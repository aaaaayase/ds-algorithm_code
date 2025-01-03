import java.util.*;
/**
 * @author yun
 * @date 2025/1/3 10:03
 * @desciption: 拼接平方数
 */

public class Main1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int a=in.nextInt();
        int b=in.nextInt();
        List<Integer> list=new ArrayList<>();
        for(int i=a;i<=b;i++) {
            if(check(i)) {
                list.add(i);
            }
        }
        for(int i=0;i<list.size();i++) {
            System.out.println(list.get(i));
        }

    }

    public static boolean check(int num) {
        if(num==0) {
            return false;
        }

        int temp=(int)Math.sqrt(num);
        if(temp*temp!=num) {
            return false;
        }

        int val=num;
        int len=0;
        while(val!=0) {
            val/=10;
            len++;
        }

        for(int i=1;i<len;i++) {
            int num1=num/((int)Math.pow(10,i));
            int num2=num%((int)Math.pow(10,i));
            int temp1=(int)Math.sqrt(num1);
            int temp2=(int)Math.sqrt(num2);
            if(num1!=0&&temp1*temp1==num1&&num2!=0&&temp2*temp2==num2) {
                return true;
            }
        }

        return false;
    }

}