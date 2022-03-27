package preponderous.ponder.tests;

import org.junit.Assert;
import org.junit.Test;
import preponderous.ponder.misc.ArgumentParser;

import java.util.ArrayList;

public class TestArgumentParser {

    @Test
    public void testDroppingFirstArgument() {
        ArgumentParser argumentParser = new ArgumentParser();

        String[] args = {"test1", "test2", "test3"};
        args = argumentParser.dropFirstArgument(args);
        String[] expected = {"test2", "test3"};

        Assert.assertArrayEquals(expected, args);
    }

    @Test
    public void testGettingArgumentsInsideDoubleQuotes() {
        ArgumentParser argumentParser = new ArgumentParser();

        String[] args = {"command", "\"first", "argument\" \"the", "second", "argument\""};
        ArrayList<String> doubleQuoteArgs = argumentParser.getArgumentsInsideDoubleQuotes(args);

        Assert.assertEquals(2, doubleQuoteArgs.size());
        Assert.assertEquals("first argument", doubleQuoteArgs.get(0));
        Assert.assertEquals("the second argument", doubleQuoteArgs.get(1));

    }
}