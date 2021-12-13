import org.junit.Test;

import static org.junit.Assert.*;

public class StringProcessorTest {

    @Test
    public void testLineCopy() {
        String string = "$$$ "; int copy = 3;
        String actual = StringProcessor.repeatString(string, copy);
        String expected = "$$$ $$$ $$$ ";
        assertEquals(expected, actual);
    }

    @org.junit.Test
    public void testLineCopyZero() {
        String string = "$$$ "; int copy = 0;
        String actual = StringProcessor.repeatString(string, copy);
        String expected = "";
        assertEquals(expected, actual);
    }

    @org.junit.Test
    public void testLineCopyNegative() throws IllegalArgumentException {
        try {
            String string = "$$$ "; int copy = -1;
            String actual = StringProcessor.repeatString(string, copy);
            fail("Expected IllegalArgumentException");
        } catch(IllegalArgumentException thrown){
            assertNotEquals("", thrown.getMessage());
        }
    }

    @org.junit.Test
    public void testLineOccurrence() {
        String origStr = "розовые розы розовеют на морозе";
        String subStr = "роз";
        int actual = StringProcessor.containNum(origStr, subStr);
        int expected = 4;
        assertEquals(expected, actual);
    }

    @org.junit.Test
    public void testLineOccurrenceNull() throws NullPointerException {
        try {
            String origStr = "розовые розы розовеют на морозе";
            String subStr = null;
            int actual = StringProcessor.containNum(origStr, subStr);
            fail("Expected NullPointerException");
        } catch(NullPointerException thrown){
            assertNotEquals("", thrown.getMessage());
        }
    }

    @org.junit.Test
    public void testReplace123() {
        String origString = "123404404404";
        String actual = StringProcessor.replaceSubString(origString);
        String expected = "одиндватри404404404";
        assertEquals(expected, actual);
    }

    @org.junit.Test
    public void testReplace123Not123() {
        String origString = "AbcФлд&*&#576";
        String actual = StringProcessor.replaceSubString(origString);
        String expected = "AbcФлд&*&#576";
        assertEquals(expected, actual);
    }

    @org.junit.Test
    public void testReplace123Random() {
        String origString = "825410730";
        String actual = StringProcessor.replaceSubString(origString);
        String expected = "8два54один07три0";
        assertEquals(expected, actual);
    }

    @org.junit.Test
    public void testDelSecondSymbolEmpty() {
        StringBuilder binaryString = new StringBuilder("");
        StringProcessor.deleteSecondChar(binaryString);
        String actual = new String(binaryString);
        String expected = "";
        assertEquals(expected, actual);
    }

    @org.junit.Test
    public void testDelSecondSymbolDifferent() {
        StringBuilder binaryString = new StringBuilder("3343gfd890рмл%^*%&456");
        StringProcessor.deleteSecondChar(binaryString);
        String actual = new String(binaryString);
        String expected = "34gd9рл^%46";
        assertEquals(expected, actual);
    }

    @org.junit.Test
    public void testDelSecondSymbolSpaces() {
        StringBuilder binaryString = new StringBuilder("3 3 3 3 3 3 3 3 3");
        StringProcessor.deleteSecondChar(binaryString);
        String actual = new String(binaryString);
        String expected = "333333333";
        assertEquals(expected, actual);
    }
}

