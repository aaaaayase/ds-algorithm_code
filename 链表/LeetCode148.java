import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class LeetCode148 {
    private class ListNode {
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

    public class nodeComparetor implements Comparator<ListNode> {
        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val - o2.val;
        }
    }

    //给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
    public ListNode sortList(ListNode head) {

        ListNode cur = head;
        List<ListNode> list = new ArrayList<>();
        if (head == null) {
            return null;
        }

        while (cur != null) {
            list.add(cur);
            cur = cur.next;
        }
        ListNode[] arr = new ListNode[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }

        Arrays.sort(arr, new nodeComparetor());
        ListNode temp = new ListNode();
        cur = temp;
        for (int i = 0; i < arr.length; i++) {
            cur.next = arr[i];
            cur = cur.next;
        }
        cur.next = null;
        return temp.next;

    }


}
