package dansplugins.dansapi.implementation.toolbox.tools;

import dansplugins.dansapi.specification.toolbox.tools.IArgumentParser;

import java.util.ArrayList;

public class ArgumentParser implements IArgumentParser {

    @Override
    public String[] dropFirstArgument(String[] args) {
        // TODO: implement
        return new String[0];
    }

    @Override
    public ArrayList<String> getArgumentsInsideDoubleQuotes(String[] args) {
        // TODO: implement
        return null;
    }
}
