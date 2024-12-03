/**
 * @author yun
 * @date 2024/12/3 18:00
 * @desciption:
 */
public class NowCoder_BM12 {
    public ListNode sortInList (ListNode head) {
        // write code here
        PriorityQueue<ListNode> heap=new PriorityQueue<>((a,b)->{
            return a.val-b.val;
        });

        ListNode dummy=new ListNode(0);
        ListNode cur=head;
        while(cur!=null) {
            heap.offer(cur);
            cur=cur.next;
        }

        int size=heap.size();
        cur=dummy;
        while(size!=0) {
            ListNode temp=heap.poll();
            cur.next=temp;
            cur=cur.next;
            size--;
        }

        cur.next=null;

        return dummy.next;

    }
}
