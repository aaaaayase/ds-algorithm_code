import java.util.Comparator;
import java.util.PriorityQueue;

class big implements Comparator<Integer> {
    public int compare(Integer p, Integer q) {
        return q - p;
    }
}

public class LeetCode17_14 {
    public int[] smallestK(int[] arr, int k) {
        //return smallestKChild1(arr,k);
        return smallestKChild2(arr,k);

    }

    public int[] smallestKChild1(int[] arr, int k) {
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            priorityQueue.offer(arr[i]);
        }
        int[] temp=new int[k];

        for (int i = 0; i < k; i++) {
            temp[i]=priorityQueue.poll();
        }

        return temp;
    }

    public int[] smallestKChild2(int[] arr, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new big());
        int temp[]=new int[k];
        if(k==0) {
            return temp;
        }
        for (int i = 0; i < k; i++) {
            priorityQueue.offer(arr[i]);
        }

        for (int i = k; i < arr.length; i++) {
            int top=priorityQueue.peek();
            if(top>=arr[i]) {
                priorityQueue.poll();
                priorityQueue.offer(arr[i]);
            }
        }


        for(int i=0;i<k;i++) {
            temp[i]=priorityQueue.poll();
        }

        return temp;
    }



}
