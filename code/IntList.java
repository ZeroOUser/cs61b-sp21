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
        IntList tmp = this;
        int size = 0;
        while (tmp != null) {
            tmp = tmp.rest;
            size++;
        }
        return size;
    }
}
