/**
 * @author yun
 * @date 2024/12/2 11:51
 * @desciption: 合并两个排序的链表
 */
public class NowCoder_BM4 {
    public ListNode Merge (ListNode pHead1, ListNode pHead2) {
        // write code here
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (pHead1 != null || pHead2 != null) {
            if (pHead1 != null && pHead2 != null) {
                if (pHead1.val <= pHead2.val) {
                    cur.next = pHead1;
                    pHead1 = pHead1.next;
                } else {
                    cur.next = pHead2;
                    pHead2 = pHead2.next;
                }
                cur = cur.next;
            } else if(pHead1!=null) {
                cur.next=pHead1;
                pHead1=null;
            } else {
                cur.next=pHead2;
                pHead2=null;
            }


        }
        return dummy.next;
    }
}
