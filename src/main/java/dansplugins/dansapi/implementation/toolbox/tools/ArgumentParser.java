package dansplugins.dansapi.implementation.toolbox.tools;

import dansplugins.dansapi.implementation.services.ConfigService;
import dansplugins.dansapi.specification.services.IConfigService;
import dansplugins.dansapi.specification.toolbox.tools.IArgumentParser;

import java.util.ArrayList;

public class ArgumentParser implements IArgumentParser {

    private static ArgumentParser instance;

    private ArgumentParser() {

    }

    public static ArgumentParser getInstance() {
        if (instance == null) {
            instance = new ArgumentParser();
        }
        return instance;
    }

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
