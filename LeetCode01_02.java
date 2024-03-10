public class LeetCode01_02 {
    public boolean CheckPermutation(String s1, String s2) {

        //给定两个由小写字母组成的字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
        int[] arr=new int[26];
        for(char ch:s1.toCharArray()) {
            arr[ch-'a']+=1;
        }

        for(char ch:s2.toCharArray()) {
            arr[ch-'a']-=1;
        }

        for(int num:arr) {
            if(num!=0) {
                return false;
            }
        }


        return true;
    }
}
