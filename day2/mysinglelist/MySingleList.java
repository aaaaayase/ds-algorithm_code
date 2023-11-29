package day2.mysinglelist;

public class MySingleList {

    static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode head;

    public void createList() {
        ListNode node1 = new ListNode(12);
        ListNode node2 = new ListNode(12);
        ListNode node3 = new ListNode(12);
        ListNode node4 = new ListNode(12);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        head = node1;
    }

    //头插法
    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        node.next = head;
        head = node;
    }

    //尾插法
    public void addLast(int data) {
        ListNode node = new ListNode(data);
        ListNode cur = head;
        if (head == null) {
            head = node;
        } else {
            while (cur.next != null) {
                cur = cur.next;

            }
            cur.next = node;

        }
    }

    //任意位置插入,第一个数据节点为0号下标
    public boolean addIndex(int index, int data) {
        ListNode node = new ListNode(data);
        checkIndexAdd(index);
        if (index == 0) {
            addFirst(data);
            return true;
        }
        if (index == size()) {
            addLast(data);
        }
        int count = 0;
        ListNode cur = head;
        while (count != index - 1) {
            cur = cur.next;
        }
        node.next = cur.next;
        cur.next = node;
        return true;
    }

    private void checkIndexAdd(int index) {
        if (index < 0 || index > size()) {
            throw new MySingleListIndexOutOfException("任意位置插入的时候，index不合法！");
        }
    }

    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key) {
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;

    }

    //删除第一次出现关键字为key的节点
    public void remove(int key) {
        if (head == null) {
            return;
        }
        if (head.val == key) {
            head = head.next;
            return;
        }

        ListNode cur = head;
        while (cur.next != null) {
            if (cur.next.val == key) {
                ListNode del = cur.next;
                cur.next = del.next;
                return;
            }
            cur = cur.next;


        }

    }

    //删除所有值为key的节点
    public void removeAllKey(int key) {
        if (head == null) {
            return;
        }

        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.val == key) {

                pre.next = cur.next;
                cur = cur.next;

            } else {
                pre = cur;
                cur = cur.next;

            }


        }
        if (head.val == key) {
            head = head.next;
        }
    }

    //得到单链表的长度
    public int size() {
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            len++;
        }
        return len;
    }

    public void display() {
        if (head == null) {
            return;
        }
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + "");
            cur = cur.next;
        }
        System.out.println();
    }

    /**
     * 从指定节点开始打印
     */
    public void display(ListNode newHead) {

        ListNode cur = newHead;
        while (cur != null) {
            System.out.print(cur.val + "");
            cur = cur.next;
        }
        System.out.println();
    }

    public void clear() {
//        head=null;
        ListNode cur = head;
        ListNode temp;
        while (cur != null) {
            temp = cur.next;
            cur.next = null;
            cur = temp;
        }
        head = null;
    }
}
