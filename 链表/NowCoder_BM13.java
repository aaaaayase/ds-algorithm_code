/**
 * @author yun
 * @date 2024/11/30 10:23
 * @desciption: 判断一个链表是否为回文结构
 */
public class NowCoder_BM13 {
    public boolean isPail(ListNode head) {
        if (head == null || head.next == null) {
            return true;  // 空链表或只有一个节点的链表是回文的
        }

        // 快慢指针找到链表中点
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 如果链表长度是奇数，跳过中间节点
        if (fast != null) {  // 快指针不为null说明链表长度是奇数
            slow = slow.next;
        }

        // 反转后半部分链表
        ListNode secondHalf = reverse(slow);
        ListNode firstHalf = head;

        // 比较前后两部分
        boolean isPalindrome = true;
        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                isPalindrome = false;
                break;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return isPalindrome;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;  // 返回新的头节点
    }
}
