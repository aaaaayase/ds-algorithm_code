import java.util.Scanner;

public class Main2 {
    static int[] months={0,31,28,31,30,31,30,31,31,30,31,30,31};
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int N=in.nextInt();
        int i=N+1;
        int num1 = -1, num2 = -1;

        while (num1 == -1 || num2 == -1) {
            if (checkValid(i)) {
                if (num1 == -1 && checkHW(i)) num1 = i;
                if (num2 == -1 && checkAB(i)) num2 = i;
            }
            i++;
        }

        System.out.println(num1);
        System.out.print(num2);

    }

    public static boolean checkHW(int num) {
        String n=String.valueOf(num);
        char[] s=n.toCharArray();
        int left=0;
        int right=s.length-1;
        while(left<=right) {
            if(s[left]==s[right]) {
                left++;
                right--;
            } else {
                return false;
            }
        }

        return true;
    }
    // ABABBABA
    public static boolean checkAB(int num) {
        if(!checkHW(num)) {
            return false;
        }
        String n=String.valueOf(num);
        char[] s=n.toCharArray();
        char ch1=s[0];
        char ch2=s[1];

        if(ch1==s[2]&&ch1==s[5]&&ch1==s[7]
                &&ch2==s[3]&&ch2==s[4]&&ch2==s[6]) {
            return true;
        }
        return false;
    }

    public static boolean checkValid(int num) {
        String n=String.valueOf(num);
        char[] s=n.toCharArray();
        int year=(s[0]-'0')*1000+(s[1]-'0')*100+(s[2]-'0')*10+(s[3]-'0');
        int month=(s[4]-'0')*10+s[5]-'0';
        int day=(s[6]-'0')*10+s[7]-'0';
        if(day==0||month<=0||month>12) {
            return false;
        }
        if(month!=2&&months[month]<day) {
            return false;
        }
        if(month==2) {
            if((year%400==0||(year%100!=0&&year%4==0))) {
                if(day>29) {
                    return false;
                }

            } else {
                if(day>28) {
                    return false;
                }
            }
        }


        return true;
    }

}