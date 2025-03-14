package deque;

public class ArrayDeque<T> implements Deque<T> {
    private T[] items;
    private int size;
    private int first, last;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        first = last = 0;
    }

    @Override
    public void addFirst(T item) {
        if (size == items.length) resize(items.length * 2);
        first = (first - 1 + items.length) % items.length;
        items[first] = item;
        size++;
    }

    @Override
    public void addLast(T item) {
        if (size == items.length) resize(items.length * 2);
        items[last] = item;
        last = (last + 1) % items.length;
        size++;
    }

    /**
     * resize the array items to specific size and copies its contents.
     *
     * @param capacity the new size.
     */
    private void resize(int capacity) {
        T[] n = (T[]) new Object[capacity];
        copy(items, n, first, size); // there is another approach
        items = n;
        first = 0;
        last = size;
    }

    /**
     * copies the n items from array a to array b starting at position first.
     *
     * @param a     first array copies from.
     * @param b     second array copies to.
     * @param first starting position.
     * @param n     num of items.
     */
    private void copy(T[] a, T[] b, int first, int n) {
        for (int i = 0; i < n; i++) {
            b[i] = a[first];
            first = (first + 1) % a.length;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(items[(first + i) % items.length] + " ");
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        if (size == 0) return null;
        if (size < items.length / 4 && size > 4) resize(items.length / 4);
        T ret = items[first];
        items[first] = null;
        first = (first + 1) % items.length;
        size--;
        return ret;
    }

    @Override
    public T removeLast() {
        if (size == 0) return null;
        if (size < items.length / 4 && size > 4) resize(items.length / 4);
        last = (last - 1 + items.length) % items.length;
        T ret = items[last];
        items[last] = null;
        size--;
        return ret;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) return null;
        return items[(first + index) % items.length];
    }

    @Override
    public String toString() {
        String out = "";
        for (int i = 0; i < size; i++) {
            out += items[(first + i) % items.length] + " ";
        }
        return out;
    }
}
