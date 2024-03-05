public class HashBuck1 <K,V> {

    static class Node <K,V> {
        public K key;
        public V val;

        public Node<K,V> next;

        public Node(K key,V val) {
            this.val=val;
            this.key=key;
        }
    }

    public int usedSize;

    public static final double LOAD_FACTOR=0.75;

    public Node<K,V>[] arr=(Node<K,V>[])new Node[10];

    public void push(K key,V val) {
        int hash=key.hashCode();
        int index=hash/arr.length;

        Node<K,V> cur=arr[index];
        if(cur==null) {
            arr[index]=cur;
            usedSize++;
            return ;
        }

        while (cur!=null) {
            if(cur.key.equals(key)) {
                cur.val=val;
                return ;
            }
            cur=cur.next;
        }

        cur.next=arr[index];
        arr[index]=cur;
        usedSize++;

        if(getLoadFactor()>=LOAD_FACTOR) {
            reSize();
        }


    }

    public void reSize() {
        Node<K,V>[] newArr=(Node<K,V>[])new Node[2*arr.length];
        for (int i = 0; i < arr.length; i++) {
            Node<K,V> cur=arr[i];

            while (cur!=null) {
                int index=cur.key.hashCode()/newArr.length;
                Node<K,V> curNext=cur.next;

                cur.next=newArr[index];
                newArr[index]=cur;

                cur=curNext;
            }

        }

        arr=newArr;

    }

    public V getValue(K key) {
        int index=key.hashCode()/arr.length;
        Node<K,V> cur=arr[index];

        while (cur!=null) {
            if(cur.key.equals(key)) {
                return cur.val;
            }
            cur=cur.next;
        }
        return null;


    }

    public double getLoadFactor() {

        return usedSize/arr.length;
    }

}
