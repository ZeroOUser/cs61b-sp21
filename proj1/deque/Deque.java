package deque;

public interface Deque<T> {
    /**
     * adds an item of type T to the front of deque.
     *
     * @param item the item that will be added to the front.
     */
    void addFirst(T item);

    /**
     * adds an item of type T to back of deque.
     *
     * @param item the item that will be added to back.
     */
    void addLast(T item);

    /**
     * check if deque is empty or not.
     *
     * @return true if deque is empty.
     */
    default boolean isEmpty() {
        return size() == 0;
    }

    /**
     * returns number of items in the deque.
     *
     * @return size of deque.
     */
    int size();

    /**
     * print the items in the deque from first to last followed by space.
     */
    void printDeque();

    /**
     * removes and returns the front item of deque.
     *
     * @return item front item of deque.
     */
    T removeFirst();

    /**
     * removes and returns the last item of deque.
     *
     * @return item last item of deque.
     */
    T removeLast();

    /**
     * returns the item at given index, of no such item returns null.
     *
     * @param index index of item.
     * @return item at given index, or null.
     */
    T get(int index);

//    Iterator<T> iterator();

    @Override
    boolean equals(Object o);
}
