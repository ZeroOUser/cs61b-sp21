public class ALList<T> {
    private T[] a;
    private int size;

    /** creates an empty list */
    public ALList() {
        this(100);
    }

    /** creates a list with initial capacity */
    public ALList(int size) {
        a = (T[])new Object[size];
    }

    /** creates a specified items list */
    public ALList(T ...argList) {
        this(argList.length);
        for (int i = 0; i < argList.length; i++) addLast(argList[i]);
    }

    @Override
    public String toString() {
        if (size == 0) return "";
        String out = String.valueOf(a[0]);
        for (int i = 1; i < size; i++) out += ", " + a[i];
        return out;
    }

    /** return size of list */
    public int size() {
        return size;
    }

    /** add data item to last of the last */
    public void addLast(T data) {
        if (size == a.length) resize(a.length * 2);
        a[size++] = data;
    }

    /** remove the last item from the list */
    public void removeLast() {
        if (size == 0) return;
        a[--size] = null;
        if ((double)size / a.length < .25) resize(a.length / 2);
    }

    /** get the last item from the list */
    public T getLast() {
        return get(size - 1);
    }

    /** get the ith item from the list */
    public T get(int i) throws IndexOutOfBoundsException{
        if (i < 0 || i >= size) throw new IndexOutOfBoundsException();
        return a[i];
    }


    private void resize(int newSize) {
        T[] n = (T[])new Object[newSize];
        System.arraycopy(a, 0, n, 0, size);
        a = n;
    }

    public static void main(String ...args) {
        ALList<Integer> l = new ALList<>(1, 2, 3, 4);
    }
}
