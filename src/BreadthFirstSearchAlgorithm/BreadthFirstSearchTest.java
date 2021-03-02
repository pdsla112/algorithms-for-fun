package BreadthFirstSearchAlgorithm;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;

public class BreadthFirstSearchTest {
    @Rule
    public Timeout globalTimeout = Timeout.millis(2000);

    @Test
    public void testCreationOfTree() {
        BreadthFirstSearchTree testTree = new BreadthFirstSearchTree(6);
        testTree.addEdge(0, 1);
        testTree.addEdge(0, 2);
        testTree.addEdge(1, 3);
        testTree.addEdge(1, 4);
        testTree.addEdge(2, 4);
        testTree.addEdge(3, 4);
        testTree.addEdge(3, 5);
        testTree.addEdge(4, 5);

        int actualNumVertices = testTree.getNumVertices();
        int expectedNumVertices = 6;
        assertEquals("Incorrect number of vertices.", expectedNumVertices, actualNumVertices);

        ArrayList<Integer> actualVertices = testTree.getVertices();
        ArrayList<Integer> expectedVertices = new ArrayList<>();
        expectedVertices.add(0);
        expectedVertices.add(1);
        expectedVertices.add(2);
        expectedVertices.add(3);
        expectedVertices.add(4);
        expectedVertices.add(5);
        assertEquals("Incorrect array of vertices returned.", expectedVertices, actualVertices);
    }

    @Test
    public void testSimpleTreeBFS() {
        BreadthFirstSearchTree testTree = new BreadthFirstSearchTree(3);
        testTree.addEdge(0, 1);
        testTree.addEdge(0, 2);

        ArrayList<Integer> actual1 = testTree.BFS(1);
        ArrayList<Integer> expected1 = new ArrayList<>();
        expected1.add(1);
        assertEquals("Incorrect result from Breadth-First Search.", expected1, actual1);

        ArrayList<Integer> actual2 = testTree.BFS(0);
        ArrayList<Integer> expected2 = new ArrayList<>();
        expected2.add(0);
        expected2.add(1);
        expected2.add(2);
        assertEquals("Incorrect result from Breadth-First Search.", expected2, actual2);
    }

    @Test
    public void testIntermediateTreeBFS() {
        BreadthFirstSearchTree testTree = new BreadthFirstSearchTree(4);
        testTree.addEdge(0, 1);
        testTree.addEdge(0, 2);
        testTree.addEdge(1, 3);

        ArrayList<Integer> actual1 = testTree.BFS(1);
        ArrayList<Integer> expected1 = new ArrayList<>();
        expected1.add(1);
        expected1.add(3);
        assertEquals("Incorrect result from Breadth-First Search", expected1, actual1);

        ArrayList<Integer> actual2 = testTree.BFS(0);
        ArrayList<Integer> expected2 = new ArrayList<>();
        expected2.add(0);
        expected2.add(1);
        expected2.add(2);
        expected2.add(3);
        assertEquals("Incorrect result from Breadth-First Search.", expected2, actual2);
    }

    @Test
    public void testAdvancedTreeBFS() {
        BreadthFirstSearchTree testTree = new BreadthFirstSearchTree(6);
        testTree.addEdge(0, 1);
        testTree.addEdge(0, 2);
        testTree.addEdge(1, 3);
        testTree.addEdge(1, 4);
        testTree.addEdge(2, 4);
        testTree.addEdge(3, 4);
        testTree.addEdge(3, 5);
        testTree.addEdge(4, 5);

        ArrayList<Integer> actual1 = testTree.BFS(1);
        ArrayList<Integer> expected1 = new ArrayList<>();
        expected1.add(1);
        expected1.add(3);
        expected1.add(4);
        expected1.add(5);
        assertEquals("Incorrect result from Breadth-First Search", expected1, actual1);

        ArrayList<Integer> actual2 = testTree.BFS(0);
        ArrayList<Integer> expected2 = new ArrayList<>();
        expected2.add(0);
        expected2.add(1);
        expected2.add(2);
        expected2.add(3);
        expected2.add(4);
        expected2.add(5);
        assertEquals("Incorrect result from Breadth-First Search.", expected2, actual2);
    }

    @Test
    public void testJumbledTree() {
        BreadthFirstSearchTree testTree = new BreadthFirstSearchTree(4);
        testTree.addEdge(0, 1);
        testTree.addEdge(0, 2);
        testTree.addEdge(1, 2);
        testTree.addEdge(2, 0);
        testTree.addEdge(2, 3);
        testTree.addEdge(3, 3);

        ArrayList<Integer> actual1 = testTree.BFS(2);
        ArrayList<Integer> expected1 = new ArrayList<>();
        expected1.add(2);
        expected1.add(0);
        expected1.add(3);
        expected1.add(1);
        assertEquals("Incorrect result from Breadth-First Search.", expected1, actual1);

        ArrayList<Integer> actual2 = testTree.BFS(3);
        ArrayList<Integer> expected2 = new ArrayList<>();
        expected2.add(3);
        assertEquals("Incorrect result from Breadth-First Search.", expected2, actual2);
    }
}
