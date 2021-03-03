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
        int actualMin = bst.getMin();
        int expectedMin = -7;
//        int actualMax = bst.getMax();
//        int expectedMax = 101;
        assertEquals("Incorrect result from method.", expectedMin, actualMin);
//        assertEquals("Incorrect result from method.", expectedMax, actualMax);
    }
}
