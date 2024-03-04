package mylinkedlist;

public class MyLinkedList {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode pre;

        public ListNode(int val) {
            this.val = val;
        }
    }

    ListNode head;
    ListNode last;

    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        if (head == null) {
            head = node;
            last = node;
        } else {
            node.next = head;
            head.pre = node;
            head = node;
        }
    }

    //尾插法
    public void addLast(int data) {
        ListNode node = new ListNode(data);
        if (head == null) {
            head = node;
            last = node;
        } else {
            last.next = node;
            node.pre = last;
            last = node;
        }
    }

    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index, int data) {

        if (index < 0 || index > size()) {
            throw new IndexOutException("index:" + index);
        }
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index == size()) {
            addLast(data);
            return;
        }
        ListNode node = new ListNode(data);
        ListNode cur = head;
        while (index != 0) {
            cur = cur.next;
            index--;
        }

        node.next = cur;
        node.pre = cur.pre;
        cur.pre.next = node;
        cur.pre = node;
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
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == key) {
                if (cur == head) {
                    head = head.next;
                    //只有一个节点并且需要删除
                    if (head != null) {
                        head.pre = null;
                    } else {
                        last = null;
                    }
                } else {
                    //删除中间节点
                    cur.pre.next = cur.next;
                    //后一个节点是否为最后一个节点
                    if (cur.next != null) {
                        cur.next.pre = cur.pre;
                    } else {
                        last = last.pre;
                    }
                }
                return;
            }
            cur = cur.next;

        }


    }

    //删除所有值为key的节点
    public void removeAllKey(int key) {
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == key) {
                if (cur == head) {
                    head = head.next;
                    //只有一个节点并且需要删除
                    if (head != null) {
                        head.pre = null;
                    } else {
                        last = null;
                    }
                } else {
                    //删除中间节点
                    cur.pre.next = cur.next;
                    //后一个节点是否为最后一个节点
                    if (cur.next != null) {
                        cur.next.pre = cur.pre;
                    } else {
                        last = last.pre;
                    }
                }

            }
            cur = cur.next;

        }
    }

    //得到单链表的长度
    public int size() {
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        return len;
    }

    public void display() {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }

    public void clear() {
//        this.head=null;
//        this.last=null;
        ListNode cur = head;
        while (cur != null) {
            ListNode curNext = cur.next;
            cur.pre = null;
            cur.next = null;
            cur = curNext;
        }
        head = null;
        last = null;
    }
}



