import java.util.Stack;

public class LeetCode445 {
    //给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
    //
    //你可以假设除了数字 0 之外，这两个数字都不会以零开头。
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur1 = reverse(l1);
        ListNode cur2 = reverse(l2);

        return reverse(addTwoNumbersChild(cur1, cur2));
    }

    public ListNode reverse(ListNode list) {

        ListNode temp=new ListNode();
        ListNode cur=list;
        while(cur!=null) {
            ListNode curNext=cur.next;
            cur.next=temp.next;
            temp.next=cur;
            cur=curNext;
        }

        return temp.next;
    }

    public ListNode addTwoNumbersChild(ListNode l1, ListNode l2) {
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode pre1 = new ListNode();
        ListNode pre2 = new ListNode();
        pre1.next = l1;
        pre2.next = l2;
        int carry = 0;
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = new ListNode();
        ListNode cur = temp;
        while (cur1 != null && cur2 != null) {
            int sum = cur1.val + cur2.val + carry;
            if (sum >= 10) {
                carry = sum / 10;
                ListNode node = new ListNode(sum % 10);
                cur.next = node;
                cur = cur.next;
            } else {
                ListNode node = new ListNode(sum);
                cur.next = node;
                cur = cur.next;
                carry = 0;
            }
            pre1 = cur1;
            pre2 = cur2;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        while (cur1 != null) {
            if (cur1.val + carry >= 10) {
                carry = (cur1.val + carry) / 10;
                ListNode node = new ListNode((cur1.val + carry) % 10);
                cur.next = node;
                cur = cur.next;
            } else {
                ListNode node = new ListNode(cur1.val + carry);
                cur.next = node;
                cur = cur.next;
                carry = 0;
            }
            pre1 = cur1;
            cur1 = cur1.next;
        }

        while (cur2 != null) {
            if (cur2.val + carry >= 10) {
                carry = (cur2.val + carry) / 10;
                ListNode node = new ListNode((cur2.val + carry) % 10);
                cur.next = node;
                cur = cur.next;
            } else {
                ListNode node = new ListNode(cur2.val + carry);
                cur.next = node;
                cur = cur.next;
                carry = 0;
            }
            pre2 = cur2;
            cur2 = cur2.next;
        }
        if (carry != 0) {
            ListNode node = new ListNode(carry);
            cur.next = node;
            cur = cur.next;
        }
        return temp.next;
    }
}