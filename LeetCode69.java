public class LeetCode69 {
    public int mySqrt(int x) {
        long l=0;
        long r=x;

        while(l<r) {
            long mid=(l+r+1)/2;
            if(mid*mid<=x) {
                l=mid;
            } else {
                r=mid-1;
            }
        }

        return (int)l;
    }
}
