public class HashBuck {

    static class Node {
        public int key;
        public int val;

        public Node next;

        public Node(int key, int val) {
            this.val = val;
            this.key = key;
        }

    }

    public Node arr[] = new Node[10];
    public static final double LOAD_FACTOR = 0.75;
    public int usedSize;

    public void push(int key, int val) {
        int index = key % arr.length;
        Node cur = arr[index];
        Node node = new Node(key, val);
        if (arr[index] == null) {
            arr[index] = node;
            usedSize++;
            return;
        }

        while (cur != null) {
            if (cur.key == key) {
                cur.val = val;
                return;
            }
            cur = cur.next;
        }

        node.next = arr[index];
        arr[index] = node;
        usedSize++;

        if (getLoadFactor() >= LOAD_FACTOR) {
            reSize();
        }

    }

    private void reSize() {
        Node[] newArr = new Node[2 * arr.length];
        for (int i = 0; i < arr.length; i++) {
            Node cur = arr[i];
            while (cur != null) {
                int index=cur.key/newArr.length;
                Node curNext = cur.next;
                cur.next=newArr[index];
                newArr[index]=cur;
                cur=curNext;
            }

        }
        arr=newArr;
    }

    public int getValue(int key) {
        int index=key/arr.length;
        Node cur=arr[index];
        while (cur!=null) {
            if(key==cur.key) {
                return cur.val;
            }
            cur=cur.next;
        }
        return -1;
    }

    public double getLoadFactor() {
        return usedSize * 1.0 / arr.length;
    }
}
