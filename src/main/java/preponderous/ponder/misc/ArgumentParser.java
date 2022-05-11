/*
  Copyright (c) 2022 Preponderous Software
  MIT License
 */
package preponderous.ponder.misc;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Daniel McCoy Stephenson
 * @author Callum Johnson
 */
public class ArgumentParser {

    /**
     * @param args to modify.
     * @return Modified Array of Strings.
     * @throws IllegalArgumentException if the arguments given are invalid.
     */
    public String[] dropFirstArgument(String[] args) {
        ensureArgumentsExist(args);
        String[] toReturn = new String[args.length - 1];
        System.arraycopy(args, 1, toReturn, 0, args.length - 1);
        return toReturn;
    }

    /**
     * @param args to compile and scan.
     * @return {@link List} of {@link String} which were surrounded by " or Double-Quotes.
     * @throws IllegalArgumentException if the arguments given are invalid.
     */
    public List<String> getArgumentsInsideDoubleQuotes(String[] args) {
        ensureArgumentsExist(args);
        return parseForArguments(args);
    }

    private List<String> parseForArguments(String[] args) {
        List<String> toReturn = new ArrayList<>();
        final String argumentString = String.join(" ", args);
        final Matcher matcher = Pattern.compile("\"[^\"]*\"").matcher(argumentString);
        while (matcher.find()) {
            toReturn.add(matcher.group().replace("\"", ""));
        }
        return toReturn;
    }

    private void ensureArgumentsExist(String[] args) {
        if (args == null || args.length == 0) {
            throw new IllegalArgumentException("Arguments not valid.");
        }
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            String input = "/test fly \"one\" \"two\" banana";
            args = input.split(" ");
        }
        System.out.println("Argument Parser - Test Harness");
        System.out.println("To utilise the Argument Parser Test Harness, provide some Program Arguments!");
        System.out.println(new ArgumentParser().getArgumentsInsideDoubleQuotes(args));
    }
}