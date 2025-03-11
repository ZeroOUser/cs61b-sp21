import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Objects;

public class IntListTest {
    @Test
    public void testSize() {
        IntList head = IntList.of(1, 2, 3, 4, 5);
        int expectedSize = 5, outputSize = Objects.requireNonNull(head).size();
        assertEquals(expectedSize, outputSize);

        head = IntList.of(1, 2, 3, 4, 5, 6, 7, 8);
        expectedSize = 8;
        outputSize = Objects.requireNonNull(head).size();
        assertEquals(expectedSize, outputSize);

        head = IntList.of(1);
        expectedSize = 1;
        outputSize = head.size();
        assertEquals(expectedSize, outputSize);
    }

    @Test
    public void restIterativeSize() {
        IntList head = IntList.of(1, 2, 3, 4, 5);
        int expectedSize = 5, outputSize = Objects.requireNonNull(head).iterativeSize();
        assertEquals(expectedSize, outputSize);

        head = IntList.of(1, 2, 3, 4, 5, 6, 7, 8);
        expectedSize = 8;
        outputSize = Objects.requireNonNull(head).iterativeSize();
        assertEquals(expectedSize, outputSize);

        head = IntList.of(1);
        expectedSize = 1;
        outputSize = head.iterativeSize();
        assertEquals(expectedSize, outputSize);
    }

    @Test
    public void getTest() {
        IntList node = IntList.of(1, 2, 3, 4, 5, 6, 7, 8);
        int expectedOut = 5, actualOut = node.get(4);
        assertEquals(expectedOut, actualOut);

        node = IntList.of(1, 2, 3, 4, 5, 6, 7, 8);
        expectedOut = 8;
        actualOut = node.get(7);
        assertEquals(expectedOut, actualOut);

        node = IntList.of(1, 2, 3, 4, 5, 6, 7, 8);
        expectedOut = 1;
        actualOut = node.get(0);
        assertEquals(expectedOut, actualOut);
    }

    @Test
    public void iterativeGetTest() {
        IntList node = IntList.of(1, 2, 3, 4, 5, 6, 7, 8);
        int expectedOut = 5, actualOut = node.iterativeGet(4);
        assertEquals(expectedOut, actualOut);

        node = IntList.of(1, 2, 3, 4, 5, 6, 7, 8);
        expectedOut = 8;
        actualOut = node.iterativeGet(7);
        assertEquals(expectedOut, actualOut);

        node = IntList.of(1, 2, 3, 4, 5, 6, 7, 8);
        expectedOut = 1;
        actualOut = node.iterativeGet(0);
        assertEquals(expectedOut, actualOut);
    }

    @Test
    public void incrListTest() {
        IntList node = IntList.of(1, 2, 3, 4, 5, 6, 7, 8);
        String expected = "3, 4, 5, 6, 7, 8, 9, 10";
        String actual = IntList.incrList(node, 2).toString();
        assertEquals(expected, actual);
    }

    @Test
    public void iterativeIncrListTest() {
        IntList node = IntList.of(1, 2, 3, 4, 5, 6, 7, 8);
        String expected = "3, 4, 5, 6, 7, 8, 9, 10";
        String actual = IntList.iterativeIncrList(node, 2).toString();
        assertEquals(expected, actual);
    }

    @Test
    public void decrListTest() {
        IntList node = IntList.of(1, 2, 3, 4, 5, 6, 7, 8);
        String expected = "0, 1, 2, 3, 4, 5, 6, 7";
        String actual = IntList.decrList(node, 1).toString();
        assertEquals(expected, actual);
    }
}
