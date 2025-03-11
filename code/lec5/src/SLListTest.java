import org.junit.Test;
import static org.junit.Assert.*;

public class SLListTest {
    @Test
    public void deleteFirstTest() {
        int[] a = new int[]{1, 2, 3, 4, 5};
        SLList l = new SLList(a);
        String expected = "1, 2, 3, 4, 5";
        String actual = l.toString();
        assertEquals(expected, actual);

        l.deleteFirst();
        l.deleteFirst();
        expected = "3, 4, 5";
        actual = l.toString();
        assertEquals(expected, actual);

        l = new SLList();
        expected = "";
        actual = l.toString();
        assertEquals(expected, actual);

        l.deleteFirst();
        l.addFirst(4);
        expected = "4";
        actual = l.toString();
        assertEquals(expected, actual);
    }


    @Test
    public void addAdjacent() {
        int[] a = {1, 1, 2, 3};
        SLList l = new SLList(a);
        l.addAdjacent();
        String expected = "4, 3";
        String actual = l.toString();
        assertEquals(expected, actual);

        a = new int[]{1, 1, 2, 2, 3};
        l = new SLList(a);
        l.addAdjacent();
        expected = "4, 2, 3";
        actual = l.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void addLastAndSquareTest() {
        SLList l = new SLList();
        l.addLastAndSquare(1);
        String expected = "1";
        String actual = l.toString();
        int expectedSize = 1, actualSize = l.size();
        assertEquals(expected, actual);
        assertEquals(expectedSize, actualSize);

        l.addLastAndSquare(2);
        expected = "1, 1, 2";
        actual = l.toString();
        expectedSize = 3;
        actualSize = l.size();
        assertEquals(expected, actual);
        assertEquals(expectedSize, actualSize);

        l.addLastAndSquare(3);
        expected = "1, 1, 1, 1, 2, 4, 3";
        actual = l.toString();
        expectedSize = 7;
        actualSize = l.size();
        assertEquals(expected, actual);
        assertEquals(expectedSize, actualSize);
    }
}
