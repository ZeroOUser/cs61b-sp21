public class SLList {
    private class Node {
        int data;
        Node next;
        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
    private Node head;
    private int size; // caching technique
    public SLList() {
        // Sentinel node
        // It doesn't matter what value in this node bcz we will never use this.
        head = new Node(0, null);
        size = 0;
    }
    public SLList(int data, int size) {
        this();
        this.size = size;
        while (size-- > 0) head.next = new Node(data, head.next);
    }
    public void addFirst(int data) {
        head.next = new Node(data, head.next);
        size++;
    }
    public int getFirst() throws IndexOutOfBoundsException {
        if (head.next == null) {
            throw new IndexOutOfBoundsException();
        }
        return head.next.data;
    }

    public void addLast(int data) {
        size++;
        Node node = head;
        while (node.next != null) node = node.next;
        node.next = new Node(data, null);
    }
//    public int size() {
//        int size = 0;
//        Node node = head;
//        while(node != null) {
//            node = node.next;
//            size++;
//        }
//        return size;
//    }
    public int size() {
        return size;
    }

    private static String toString(Node node) {
        if (node.next ==  null) return String.valueOf(node.data);
        return node.data + ", " + toString(node.next);
    }
    @Override
    public String toString() {
        if (head.next == null) return "";
        return toString(head.next);
    }

    public static void main(String[] args) {
        SLList list = new SLList();
//        list.addFirst(5);
//        list.addLast(6);
        System.out.println(list);
        System.out.println(list.size());
        System.out.println(list.getFirst());
    }

    /* Exercises */
    public void deleteFirst() {
        if (head.next == null) return;
        head.next = head.next.next;
        size--;
    }

    // Constructor that takes array as argument and make list of of its elements
    public SLList(int[] a) {
        this();
        for (int i = a.length - 1; i >= 0; i--) addFirst(a[i]);
    }

    public void addAdjacent() {
        if (head.next == null) return;
        Node node = head.next;
        while (node.next != null) {
            if (node.data == node.next.data) {
                node.data *= 2;
                node.next = node.next.next;
                size--;
            }
            else node = node.next;
        }
    }

    public void addLastAndSquare(int data) {
        Node node = head;
        while(node.next != null) {
            node = node.next;
            addNode(node, node.data * node.data);
            node = node.next;
        }
        addNode(node, data);
    }

    // helper method
    private void addNode(Node node, int data) {
        node.next = new Node(data, node.next);
        size++;
    }
}
