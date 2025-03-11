package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import timingtest.AList;

import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove() {
        int n = 3, i;
        int expected, actual;
        int expectedSize, actualSize;

        BuggyAList<Integer> buggyL = new BuggyAList<>();
        AListNoResizing<Integer> correctL = new AListNoResizing<>();
        for (i = 0; i < 3; i++) {
            buggyL.addLast(i);
            correctL.addLast(i);
        }

        for (i = 0; i < 3; i++) {
            actual = buggyL.removeLast();
            expected = correctL.removeLast();
            actualSize = buggyL.size();
            expectedSize = correctL.size();
            assertEquals(expected, actual);
            assertEquals(expectedSize, actualSize);
        }
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> correctL = new AListNoResizing<>();
        BuggyAList<Integer> actualL = new BuggyAList<>();
        final int N = 5000;
        for (int i = 0; i < N; i++) {
            int opNum = StdRandom.uniform(0, 4);
            if (opNum == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                correctL.addLast(randVal);
                actualL.addLast(randVal);
            }
            else if (opNum == 1){
                // size
                int expected = correctL.size(), actual = actualL.size();
                assertEquals(expected, actual);
            }
            else if (opNum == 2) {
                // getLast
                int expectedLast = -1, actualLast = -1;
                if (correctL.size() > 0) {
                    expectedLast = correctL.getLast();
                }
                if (actualL.size() > 0) {
                    actualLast = actualL.getLast();
                }
                assertEquals(expectedLast, actualLast);
            }
            else {
                // removeLast
                int expectedLast = -1, actualLast = -1;
                if (correctL.size() > 0) {
                    expectedLast = correctL.removeLast();
                }
                if (actualL.size() > 0) {
                    actualLast = actualL.removeLast();
                }
                assertEquals(expectedLast, actualLast);
            }

        }
    }
}
