package deque;

import org.junit.Test;

public class ArrayDequeTest extends DequeTest {
    public ArrayDequeTest() {
        super(new ArrayDeque<Integer>());
    }
    @Test
    public void addFirstTest() {
        super.addFirstTest();
    }

    @Test
    public void addLastTest() {
        super.addLastTest();
    }

    @Test
    public void addFirstLastTest() {
        super.addFirstLastTest();
    }
    @Test
    public void removeFirstTest() {
        super.removeFirstTest();
    }

    @Test
    public void removeLastTest() {
        super.removeLastTest();
    }

    @Test
    public void getTest() {
        super.getTest();
    }
}
