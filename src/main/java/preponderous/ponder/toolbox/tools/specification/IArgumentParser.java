package preponderous.ponder.toolbox.tools.specification;

import java.util.ArrayList;

public interface IArgumentParser {
    String[] dropFirstArgument(String[] args);
    ArrayList<String> getArgumentsInsideDoubleQuotes(String[] args);
}
