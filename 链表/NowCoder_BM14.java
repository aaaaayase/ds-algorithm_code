/**
 * @author yun
 * @date 2024/11/30 10:23
 * @desciption: 链表的奇偶重排
 */
public class NowCoder_BM14 {
    public ListNode oddEvenList(ListNode head) {
        // write code here
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);

        ListNode cur1 = dummy1;
        ListNode cur2 = dummy2;
        ListNode cur = head;
        ListNode curN = null;
        int count = 1;

        while (cur != null) {
            curN = cur.next;
            if (count % 2 == 1) {
                cur.next = null;
                cur1.next = cur;
                cur1 = cur1.next;
            } else {
                cur.next = null;
                cur2.next = cur;
                cur2 = cur2.next;
            }
            count++;
            cur = curN;
        }

        cur1.next = dummy2.next;
        dummy2.next = null;

        return dummy1.next;
    }
}
