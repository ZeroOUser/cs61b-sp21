import org.junit.Test;
import static org.junit.Assert.*;
public class DLListTest {
    @Test
    public void addFirstTest() {
        DLList<Integer> l = new DLList<>();
        l.addFirst(1);
        l.addFirst(2);
        String expected = "2, 1", actual = l.toString();
        int expectedSize = 2, actualSize = l.size();
        assertEquals(expected, actual);
        assertEquals(expectedSize, actualSize);


        l.removeFirst();
        l.addFirst(1);
        expected = "1, 1";
        actual = l.toString();
        expectedSize = 2;
        actualSize = l.size();
        assertEquals(expected, actual);
        assertEquals(expectedSize, actualSize);

    }

    @Test
    public void getFirstTest() {
        DLList<Integer> l = new DLList<>(1, 2, 3, 4);
        l.removeFirst();
        Integer actual = l.getFirst(), expected = 2;
        assertEquals(expected, actual);

        l = new DLList<>();
        actual = l.getFirst();
        expected = null;
        assertEquals(expected, actual);
    }

    @Test
    public void addLastTest() {
        DLList<Integer> l = new DLList<>();
        l.addLast(5);
        l.addLast(4);
        String expected = "5, 4", actual = l.toString();
        int expectedSize = 2, actualSize = l.size();
        assertEquals(expected, actual);
        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void removeLastTest() {
        DLList<Integer> l = new DLList<>();
        String actual, expected;
        int actualSize, expectedSize;

        l.addLast(5);
        l.removeLast();
        l.removeLast();
        actual = l.toString();
        expected = "";
        actualSize = l.size();
        expectedSize = 0;
        assertEquals(expected, actual);
        assertEquals(expectedSize, actualSize);


        l.addLast(1);
        l.addLast(2);
        l.removeLast();
        actual = l.toString();
        expected = "1";
        actualSize = l.size();
        expectedSize = 1;
        assertEquals(expected, actual);
        assertEquals(expectedSize, actualSize);



        l.addLast(2);
        l.addLast(3);
        l.removeLast();
        actual = l.toString();
        expected = "1, 2";
        actualSize = l.size();
        expectedSize = 2;
        assertEquals(expected, actual);
        assertEquals(expectedSize, actualSize);
    }


}
