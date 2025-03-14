package deque;

import edu.princeton.cs.algs4.StdRandom;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DequeTest {
    private Deque<Integer> d;

    public DequeTest(Deque<Integer> d) {
        this.d = d;
    }

    public void addFirstTest() {
        final int MAX_ATTEMPTS = 2000;
        String expected = "", actual;
        int expectedSize = 0, actualSize;
        assertTrue("lld should be empty after initialization.", d.isEmpty());
        for (int i = 0; i < MAX_ATTEMPTS; i++) {
            d.addFirst(i);
            expected = i + " " + expected;
            actual = d.toString();
            assertEquals("lld should be {" + expected + "}", expected, actual);
            expectedSize++;
            actualSize = d.size();
            assertEquals("lld size should be " + expectedSize, expectedSize, actualSize);
        }
    }

    public void addLastTest() {
        final int MAX_ATTEMPTS = 10;
        String expected = "", actual;
        int expectedSize = 0, actualSize;
        assertTrue("lld should be empty after initialization.", d.isEmpty());
        for (int i = 0; i < MAX_ATTEMPTS; i++) {
            d.addLast(i);
            expected += i + " ";
            actual = d.toString();
            assertEquals("lld should be {" + expected + "}", expected, actual);
            expectedSize++;
            actualSize = d.size();
            assertEquals("lld size should be " + expectedSize, expectedSize, actualSize);
        }
    }

    public void addFirstLastTest() {
        final int MAX_ATTEMPTS = 10;
        String expected = "", actual;
        int expectedSize = 0, actualSize;
        for (int i = 0; i < MAX_ATTEMPTS; i++) {
            int opNum = StdRandom.uniform(0, 2);
            int randVal = StdRandom.uniform(0, 100);
            if (opNum == 0) {
                // addFirst
                d.addFirst(randVal);
                expected = randVal + " " + expected;
            } else {
                // addLast
                d.addLast(randVal);
                expected += randVal + " ";
            }
            actual = d.toString();
            assertEquals("lld should be {" + expected + "}", expected, actual);
            expectedSize++;
            actualSize = d.size();
            assertEquals("lld size should be " + expectedSize, expectedSize, actualSize);
        }
    }

    public void removeFirstTest() {
        assertTrue("removeFirst() Should return null in empty deque", d.removeFirst() == null);

        d.addFirst(2);
        assertTrue("removeFirst() should return 2.", d.removeFirst() == 2);
        assertTrue("lld should be empty.", d.isEmpty());

        d.addFirst(2);
        d.addFirst(1);
        assertTrue("removeFirst() should return 1.", d.removeFirst() == 1);
        assertTrue("lld size should be 1.", d.size() == 1);
    }

    public void removeLastTest() {
        assertTrue("removeLast() Should return null in empty deque", d.removeLast() == null);

        d.addFirst(2);
        assertTrue("removeLast() should return 2.", d.removeLast() == 2);
        assertTrue("lld should be empty.", d.isEmpty());

        d.addFirst(2);
        d.addFirst(1);
        assertTrue("removeLast() should return 1.", d.removeLast() == 2);
        assertTrue("lld size should be 1.", d.size() == 1);
    }

    public void getTest() {
        d.addLast(1);
        d.addLast(2);
        d.addLast(3);
        assertTrue("Item at index -1 should be null", d.get(-1) == null);

        for (int i = 0; i < 3; i++) {
            assertTrue("Item at index " + i + " should be " + i + 1, d.get(i) == i + 1);
        }

        assertTrue("Item at index 5 should be null", d.get(5) == null);
    }
}
