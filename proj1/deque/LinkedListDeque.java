package deque;

public class LinkedListDeque<T> implements Deque<T> {
    private class Node {
        T item;
        Node prev;
        Node next;

        Node(T item, Node prev, Node next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        sentinel.prev = sentinel.next = sentinel;
        size = 0;
    }

    @Override
    public void addFirst(T item) {
        Node node = sentinel.next;
        sentinel.next = new Node(item, sentinel, sentinel.next);
        node.prev = sentinel.next;
        size++;
    }

    @Override
    public void addLast(T item) {
        sentinel.prev.next = sentinel.prev = new Node(item, sentinel.prev, sentinel);
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        System.out.println(toString());
    }

    @Override
    public T removeFirst() {
        if (size == 0) return null;
        Node del = sentinel.next;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size--;
        return del.item;
    }

    @Override
    public T removeLast() {
        if (size == 0) return null;
        Node del = sentinel.prev;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size--;
        return del.item;
    }

    @Override
    public T get(int index) {
        if (isIndexOut(index)) return null;
        Node node;
        if (index < size / 2) {
            node = sentinel.next;
            for (int i = 0; i < index; i++) node = node.next;
            return node.item;
        } else {
            node = sentinel.prev;
            for (int i = size - 1; i > index; i--) node = node.prev;
            return node.item;
        }
    }

    /**
     * Helper method for recursion problem in get method.
     *
     * @param curr  current node.
     * @param i     current index.
     * @param index target index.
     * @return item if exist at given index, otherwise null.
     */
    private T getRecursiveHelper(Node curr, int i, final int index) {
        if (curr == sentinel) return null;
        if (i == index) return curr.item;
        return getRecursiveHelper(curr.next, i + 1, index);
    }

    /**
     * same is get method but in recursive way.
     *
     * @param index target index.
     * @return item at specified index.
     */
    public T getRecursive(int index) {
        if (isIndexOut(index)) return null;
        return getRecursiveHelper(sentinel.next, 0, index);
    }

    /**
     * Helper method to check if index is out of scope or not.
     *
     * @param index specifiec index.
     * @return True if out.
     */
    private boolean isIndexOut(int index) {
        return index < 0 || index >= size;
    }

    @Override
    public String toString() {
        String out = "";
        Node node = sentinel.next;
        while (node != sentinel) {
            out += node.item + " ";
            node = node.next;
        }
        return out;
    }
}
