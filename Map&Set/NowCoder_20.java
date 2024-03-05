import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class NowCoder_20 {
    //旧键盘上坏了几个键，于是在敲一段文字的时候，对应的字符就不会出现。现在给出应该输入的一段文字、以及实际被输入的文字，请你列出
    //肯定坏掉的那些键。
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String a = in.nextLine().toUpperCase();
            String b = in.nextLine().toUpperCase();

            Set<Character> set=new HashSet<>();
            for (int i = 0; i < b.length(); i++) {
                set.add(b.charAt(i));
            }

            Set<Character> setBroken=new HashSet<>();
            for (int i=0;i<a.length();i++) {
                if(!set.contains(a.charAt(i))&&!setBroken.contains(a.charAt(i))) {
                    System.out.print(a.charAt(i));
                    setBroken.add(a.charAt(i));
                }
            }




        }
    }
}
