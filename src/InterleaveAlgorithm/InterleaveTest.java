package InterleaveAlgorithm;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class InterleaveTest {
    @Test
    public void testInterleaveRegularString() {
        String string1 = "Hello";
        String string2 = "World";
        String expected = "HWeolrllod";
        String actual = interleave(string1, string2);
        assertEquals("Incorrect result from method.", expected, actual);
    }

    @Test
    public void testInterleaveEmptyString() {
        String string1 = "";
        String string2 = "";
        String string3 = "a";
        String string4 = "abc";
        String expected1 = "";
        String actual1 = interleave(string1, string2);
        String expected2 = "a";
        String actual2 = interleave(string1, string3);
        String expected3 = "abc";
        String actual3 = interleave(string1, string4);
        assertEquals("Incorrect result from method.", expected1, actual1);
        assertEquals("Incorrect result from method.", expected2, actual2);
        assertEquals("Incorrect result from method.", expected3, actual3);
    }

    @Test
    public void testInterleaveSingleString() {
        String string1 = "a";
        String string2 = "b";
        String expected = "ab";
        String actual = interleave(string1, string2);
        assertEquals("Incorrect result from method.", expected, actual);
    }

    @Test
    public void testInterleaveIntString() {
        String string1 = "1";
        String string2 = "7";
        String expected = "17";
        String actual = interleave(string1, string2);
        assertEquals("Incorrect result from method.", expected, actual);
    }

    @Test
    public void testInterleaveMixedString() {
        String string1 = "1a2b3c4d";
        String string2 = "5e6f7g8h";
        String expected = "15ae26bf37cg48dh";
        String actual = interleave(string1, string2);
        assertEquals("Incorrect result from method.", expected, actual);
    }

    @Test
    public void testInterleaveSymbols() {
        String string1 = "a@b%c/";
        String string2 = "d#e$g%.";
        String expected = "ad@#be%$cg/%.";
        String actual = interleave(string1, string2);
        assertEquals("Incorrect result from method.", expected, actual);
    }

    @Test
    public void testInterleaveSpaces() {     // This string interleave algorithm defines a space as a valid character.
        String string1 = " ";
        String string2 = "a";
        String string3 = "5 g";
        String string4 = " 4 d ";
        String expected1 = " a";
        String actual1 = interleave(string1, string2);
        String expected2 = "a5 g";
        String actual2 = interleave(string2, string3);
        String expected3 = "5  4g d ";
        String actual3 = interleave(string3, string4);
        assertEquals("Incorrect result from method.", expected1, actual1);
        assertEquals("Incorrect result from method.", expected2, actual2);
        assertEquals("Incorrect result from method.", expected3, actual3);
    }
}
