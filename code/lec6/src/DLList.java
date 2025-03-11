public class DLList <T>{
    private class Node {
        T data;
        Node prev, next;
        Node(Node prev, Node next) {
            this.prev = prev;
            this.next = next;
        }
        Node(T data, Node prev, Node next) {
            this(prev, next);
            this.data = data;

        }
    }
    private Node sentinel;
    private int size;
    public DLList() {
        sentinel = new Node(null, null, null);
        sentinel.prev = sentinel.next = sentinel;
        size = 0;
    }
    public DLList(int size, T data) {
        this();
        this.size = size;
        Node node = sentinel;
        while(size-- > 0) node = node.next = new Node(data, node, sentinel);
    }
    public DLList(T ...argList) {
        this();
        for (int i = argList.length - 1; i >= 0; i--) addFirst(argList[i]);
    }
    public void addFirst(T data) {
        Node p = sentinel.next = new Node(data, sentinel, sentinel.next);
        p.next.prev = p;
        size++;
    }
    public void removeFirst() {
        Node del = sentinel.next;
        del.next.prev = del.prev;
        del.prev.next = del.next;
        size--;
    }
    public T getFirst() {
        return sentinel.next.data;
    }

    public void addLast(T data) {
        Node n = sentinel.prev;
        sentinel.prev = new Node(data, sentinel.prev, sentinel);
        n.next = sentinel.prev;
        size++;
    }
    public void removeLast() {
        if (size == 0) return; // to prevent minus size
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size--;
    }
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        Node node = sentinel.next;
        if (node == sentinel) return "";
        String out = String.valueOf(node.data);
        node = node.next;
        while (node != sentinel) {
            out += ", " + String.valueOf(node.data);
            node = node.next;
        }
        return out;
    }

    public static void main(String[] args) {
        DLList<Integer> l = new DLList<>();
        l.addLast(5);
        l.removeLast();
        l.removeLast();
        System.out.println(l);
        l.addLast(1);
        l.addLast(2);
        System.out.println(l);
        l.removeLast();
        System.out.println(l);
        l.addLast(2);
        l.addLast(3);
        l.removeLast();
        System.out.println(l);
    }
}
