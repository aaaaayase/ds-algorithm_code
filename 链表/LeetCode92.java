public class LeetCode92 {
    private static class ListNode {
        public int val;
        public ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }
    }

    //给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。
    // 请你反转从位置 left 到位置 right 的链表节点，返回反转后的链表
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null) {
            return null;
        }

        ListNode temp=new ListNode();
        temp.next=head;

        ListNode pre=temp;
        ListNode cur=head;

        while(right!=0&&cur!=null) {
            cur=cur.next;
            right--;
        }
        ListNode end=cur;

        cur=head;
        while(left!=1) {
            pre=cur;
            cur=cur.next;
            left--;
        }


        ListNode tail=cur;
        while(cur!=end) {
            ListNode curNext=cur.next;
            cur.next=pre.next;
            pre.next=cur;
            cur=curNext;
        }

        tail.next=end;

        return temp.next;


    }
}
