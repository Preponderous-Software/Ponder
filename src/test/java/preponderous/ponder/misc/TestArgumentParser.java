package preponderous.ponder.misc;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestArgumentParser {

    @Test
    public void testDroppingFirstArgument() {
        ArgumentParser argumentParser = new ArgumentParser();

        String[] args = {"test1", "test2", "test3"};
        args = argumentParser.dropFirstArgument(args);
        String[] expected = {"test2", "test3"};

        assertArrayEquals(expected, args);
    }

    @Test
    public void testGettingArgumentsInsideDoubleQuotes() {
        ArgumentParser argumentParser = new ArgumentParser();

        String[] args = {"command", "\"first", "argument\" \"the", "second", "argument\""};
        List<String> doubleQuoteArgs = argumentParser.getArgumentsInsideDoubleQuotes(args);

        assertEquals(2, doubleQuoteArgs.size());
        assertEquals("first argument", doubleQuoteArgs.get(0));
        assertEquals("the second argument", doubleQuoteArgs.get(1));

    }
}