import java.util.Arrays;

public class LeetCode1046 {
    //有一堆石头，每块石头的重量都是正整数。
    //
    //每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
    //
    //如果 x == y，那么两块石头都会被完全粉碎；
    //如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
    //最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
    public int lastStoneWeight(int[] stones) {

        while(stones.length!=1) {
            int index=stones.length-1;
            mergeSort(stones);
            stones[index-1]=stones[index]-stones[index-1];
            stones=Arrays.copyOf(stones,stones.length-1);
        }
        return stones[0];
    }


    public void mergeSort(int[] arr) {
        merge(arr,0,arr.length-1);
    }

    public void merge(int[] arr,int start,int end) {
        if(start>=end) {
            return ;
        }

        int mid=start+(end-start)/2;
        merge(arr,start,mid);
        merge(arr,mid+1,end);
        mergeFunc(arr,start,end,mid);
    }

    public void mergeFunc(int[] arr,int left,int right,int mid) {

        int s1=left;
        int s2=mid+1;
        int e1=mid;
        int e2=right;
        int index=0;
        int[] newArr=new int[right-left+1];
        while(s1<=e1&&s2<=e2) {
            if(arr[s1]<=arr[s2]) {
                newArr[index]=arr[s1];
                s1++;
                index++;
            } else {
                newArr[index]=arr[s2];
                s2++;
                index++;
            }
        }

        while(s1<=e1) {
            newArr[index++]=arr[s1++];
        }

        while(s2<=e2) {
            newArr[index++]=arr[s2++];
        }

        for(int i=0;i<newArr.length;i++) {
            arr[i+left]=newArr[i];
        }
    }


}
