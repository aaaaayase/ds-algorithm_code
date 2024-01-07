public class LeetCode66 {

    //给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
    //
    //最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
    //
    //你可以假设除了整数 0 之外，这个整数不会以零开头。
    public int[] plusOne(int[] digits) {
        int len=digits.length;
        int count=0;
        for(int i=0;i<len;i++) {
            if(digits[i]==9) {
                count++;
            }
        }
        int[] arr=new int[len+1];
        if(count==len) {
            arr[0]=1;
            return arr;
        } else {
            if(digits[len-1]<9) {
                digits[len-1]+=1;
            } else {
                while(digits[len-1]==9) {
                    digits[len-1]=0;
                    len--;
                }
                digits[len-1]+=1;
            }
            return digits;
        }

    }


}
