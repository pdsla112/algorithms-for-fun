package BinarySearchTreeImplementation;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinarySearchTreeTest {
    BinarySearchTree bst = new BinarySearchTree();
    @Test
    public void testSimpleTree() {
        bst.add(7);
        bst.add(17);
        bst.add(90);
        bst.add(101);
        bst.add(2);
        bst.add(3);
        bst.add(1);
        bst.add(-7);
        bst.add(77);
        bst.add(-12);
        int actualMin = bst.getMin();
        int expectedMin = -12;
        int actualMax = bst.getMax();
        int expectedMax = 101;
        assertEquals("Incorrect result from method.", expectedMin, actualMin);
        assertEquals("Incorrect result from method.", expectedMax, actualMax);
    }

    @Test
    public void testEmptyTree() {
        int actualMin = bst.getMin();
        int expectedMin = 0;
        int actualMax = bst.getMax();
        int expectedMax = 0;
        assertEquals("Incorrect result from getMin() method.", expectedMin, actualMin);
        assertEquals("Incorrect result from getMax() method.", expectedMax, actualMax);
    }

    @Test
    public void testSingleNodeTree() {
        bst.add(7);
        int actualMin = bst.getMin();
        int expectedMin = 7;
        int actualMax = bst.getMax();
        int expectedMax = 7;
        assertEquals("Incorrect result from getMin() method.", expectedMin, actualMin);
        assertEquals("Incorrect result from getMax() method.", expectedMax, actualMax);
    }

    @Test
    public void testDeleteSimpleTree() {
        bst.add(7);
        bst.add(17);
        bst.add(90);
        bst.add(101);
        bst.add(2);
        bst.add(3);
        bst.add(1);
        bst.add(-7);
        bst.add(77);
        bst.add(-12);

        bst.delete(-12);
        int actualMin = bst.getMin();
        int expectedMin = -7;
        assertEquals("Incorrect result from getMin() method after removing the smallest node.", expectedMin, actualMin);

//        bst.delete(101);
//        int actualMax = bst.getMax();
//        int expectedMax = 90;
//        assertEquals("Incorrect result from getMax() method after removing the largest node.", expectedMax, actualMax);
    }
}
