import org.junit.Test;
import static org.junit.Assert.*;

public class ALListTest {

    @Test
    public void addLastTest() {
        ALList<Integer> l = new ALList<>();
        int expectedSize, actualSize;
        String expected, actual;

        l.addLast(1);
        l.addLast(2);
        l.addLast(3);
        expected = "1, 2, 3";
        actual = l.toString();
        expectedSize = 3;
        actualSize = l.size();
        assertEquals(expected, actual);
        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void removeLastTest() {
        ALList<Integer> l = new ALList<>(1, 2, 3);
        int expectedSize, actualSize;
        String expected, actual;

        l.addLast(4);
        l.removeLast();
        expected = "1, 2, 3";
        actual = l.toString();
        expectedSize = 3;
        actualSize = l.size();
        assertEquals(expected, actual);
        assertEquals(expectedSize, actualSize);

        l.removeLast();
        expected = "1, 2";
        actual = l.toString();
        expectedSize = 2;
        actualSize = l.size();
        assertEquals(expected, actual);
        assertEquals(expectedSize, actualSize);

    }

    @Test
    public void getTest() {
        ALList<Integer> l = new ALList<>(1, 2, 3);
        int expected, actual;

        for (int i = 0; i < 3; i++) {
            expected = i + 1;
            actual = l.get(i);
            assertEquals(expected, actual);
        }

        l.removeLast();
        l.addLast(5);
        expected = 5;
        actual = l.get(2);
        assertEquals(expected, actual);
    }
}
