package dansplugins.dansapi.specification.toolbox.tools;

import java.util.ArrayList;

public interface IArgumentParser {
    String[] dropFirstArgument(String[] args);
    ArrayList<String> getArgumentsInsideDoubleQuotes(String[] args);
}
