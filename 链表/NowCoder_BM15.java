/**
 * @author yun
 * @date 2024/12/6 20:09
 * @desciption: 删除有序链表中重复的元素
 */
public class NowCoder_BM15 {
    public ListNode deleteDuplicates(ListNode head) {
        // write code here
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = head;
        ListNode cur = head.next;

        while (cur != null) {
            ListNode curN = cur.next;
            if (cur.val == pre.val) {
                pre.next = curN;
            } else {
                pre = cur;
            }

            cur = curN;
        }

        return head;
    }
}
