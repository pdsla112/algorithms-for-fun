package StupidSortAlgorithm;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class StupidSortTest {
    @Rule
    public Timeout globalTimeout = Timeout.millis(2000);

    StupidSort stupidSort = new StupidSort();

    @Test
    public <T extends Comparable<T>> void testStupidSortEmpty() {
        List<T> unsorted = Collections.emptyList();
        List<T> sorted = stupidSort.stupidSort(unsorted);
        List<T> expected = Collections.emptyList();
        assertEquals("Incorrect result from method.", expected, sorted);
    }

    @Test
    public void testStupidSortSingleInteger() {
        List<Integer> unsorted = new ArrayList<>();
        unsorted.add(7);
        List<Integer> sorted = stupidSort.stupidSort(unsorted);
        List<Integer> expected = new ArrayList<>();
        expected.add(7);
        assertEquals("Incorrect result from method.", expected, sorted);
    }

    @Test
    public void testStupidSortSingleCharacter() {
        List<Character> unsorted = new ArrayList<>();
        unsorted.add('a');
        List<Character> sorted = stupidSort.stupidSort(unsorted);
        List<Character> expected = new ArrayList<>();
        expected.add('a');
        assertEquals("Incorrect result from method.", expected, sorted);
    }

    @Test
    public void testStupidSortSingleString() {
        List<String> unsorted = new ArrayList<>();
        unsorted.add("Peach");
        List<String> sorted = stupidSort.stupidSort(unsorted);
        List<String> expected = new ArrayList<>();
        expected.add("Peach");
        assertEquals("Incorrect result from method.", expected, sorted);
    }

    @Test
    public void testStupidSortMultipleIntegers() {
        List<Integer> unsorted = new ArrayList<>();
        unsorted.add(7);
        unsorted.add(6);
        unsorted.add(8);
        unsorted.add(9);
        unsorted.add(0);
        List<Integer> sorted = stupidSort.stupidSort(unsorted);
        List<Integer> expected = new ArrayList<>();
        expected.add(0);
        expected.add(6);
        expected.add(7);
        expected.add(8);
        expected.add(9);
        assertEquals("Incorrect result from method.", expected, sorted);
    }

    @Test
    public void testStupidSortMultipleCharacters() {
        List<Character> unsorted = new ArrayList<>();
        unsorted.add('A');
        unsorted.add('p');
        unsorted.add('p');
        unsorted.add('l');
        unsorted.add('e');
        unsorted.add('S');
        List<Character> sorted = stupidSort.stupidSort(unsorted);
        List<Character> expected = new ArrayList<>();
        expected.add('A');
        expected.add('S');
        expected.add('e');
        expected.add('l');
        expected.add('p');
        expected.add('p');
        assertEquals("Incorrect result from method.", expected, sorted);
    }

    @Test
    public void testStupidSortMultipleStrings() {
        List<String> unsorted = new ArrayList<>();
        unsorted.add("Cantaloupe");
        unsorted.add("strawberry./");
        unsorted.add("peach");
        unsorted.add("Apple");
        unsorted.add("kiwi");
        unsorted.add("rock melon.");
        unsorted.add("raspberry");
        List<String> sorted = stupidSort.stupidSort(unsorted);
        List<String> expected = new ArrayList<>();
        expected.add("Apple");
        expected.add("Cantaloupe");
        expected.add("kiwi");
        expected.add("peach");
        expected.add("raspberry");
        expected.add("rock melon.");
        expected.add("strawberry./");
        assertEquals("Incorrect result from method", expected, sorted);
    }
}
