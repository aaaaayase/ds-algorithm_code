package day8;

public class demo1 {

    private static class ListNode {
        public int val;
        public ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }
    }

    //给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) {
            return null;
        }
        ListNode cur=head.next;
        ListNode pre=head;
        while(cur!=null) {

            if(cur.val==pre.val) {
                ListNode curNext=cur.next;
                pre.next=curNext;
                cur=curNext;
            } else {
                pre=cur;
                cur=cur.next;
            }


        }



        return head;
    }
}
