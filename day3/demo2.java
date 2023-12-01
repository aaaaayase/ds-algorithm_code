package day3;

public class demo2 {
    private static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    //现有一链表的头指针 ListNode* pHead，给一定值x，
    //编写一段代码将所有小于x的结点排在其余结点之前，且不能改变原来的数据顺序，返回重新排列后的链表的头指针。
    public ListNode partition(ListNode pHead, int x) {
        // write code here
        ListNode as = null;
        ListNode ae = null;
        ListNode bs = null;
        ListNode be = null;

        if (pHead == null) {
            return null;
        }

        ListNode cur = pHead;

        while (cur != null) {
            if (cur.val < x) {
                if (as == null) {
                    as = cur;
                    ae = cur;
                } else {
                    ae.next = cur;
                    ae = cur;
                }
            } else {
                if (bs == null) {
                    bs = cur;
                    be = cur;
                } else {
                    be.next = cur;
                    be = cur;
                }
            }
            cur = cur.next;
        }
        if (as == null) {
            return bs;
        }
        ae.next = bs;
        if (bs != null) {
            be.next = null;
        }
        return as;


    }


}
