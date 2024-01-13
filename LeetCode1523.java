public class LeetCode1523 {
    //给你两个非负整数 low 和 high 。请你返回 low 和 high 之间（包括二者）奇数的数目。
    public int countOdds(int low, int high) {

        //return countOdds1(low,high);
        return countOdds2(low,high);
    }

    public int countOdds2(int low,int high) {
        return (high+1)/2-low/2;
    }
    public int countOdds1(int low, int high) {
        int count=0;
        if(low%2==0) {
            low+=1;
        }

        for(int i=low;i<=high;i+=2) {
            count++;
        }
        return count;
    }
}
