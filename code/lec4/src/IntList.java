public class IntList {
    private int first;
    private IntList rest;
    public IntList(int first, IntList rest) {
        this.first = first;
        this.rest = rest;
    }
    public int size() {
        if (rest == null) return 1;
        return 1 + this.rest.size();
    }
    public int iterativeSize() {
        IntList head = this;
        int size = 0;
        while (head != null) {
            head = head.rest;
            size++;
        }
        return size;
    }
    public static IntList of(int ...argList) {
        if (argList.length == 0) return null;
        IntList head = null;
        for (int i = argList.length - 1; i >= 0; i--) {
            head = new IntList(argList[i], head);
        }
        return head;
    }

    public int get(int i) throws IndexOutOfBoundsException {
        if (i >= size()) throw new IndexOutOfBoundsException();
        if (i == 0) return this.first;
        return this.rest.get(i - 1);
    }
    public int iterativeGet(int i) throws IndexOutOfBoundsException {
        if (i >= size()) throw new IndexOutOfBoundsException();
        IntList node = this;
        while (--i >= 0) node = node.rest;
        return node.first;
    }

    /* Exercises */

    public String toString() {
        if (rest == null) return String.valueOf(first);
        return String.valueOf(first) + ", " + rest.toString();
    }

    public static IntList incrList(IntList list, final int x) {
        if (list == null) return null;
        return new IntList(list.first + x, incrList(list.rest, x));
    }

    public static IntList iterativeIncrList(IntList list, int x) {
        if (list == null) return null;
        IntList cp = new IntList(list.first + x, null), node = cp;
        while (list.rest != null) {
            list = list.rest;
            node.rest = new IntList(list.first + x, null);
            node = node.rest;
        }
        return cp;
    }

    public static IntList decrList(IntList list, final int x) {
        if (list == null) return null;
        list.first = list.first - x;
        decrList(list.rest, x);
        return list;
    }
}
