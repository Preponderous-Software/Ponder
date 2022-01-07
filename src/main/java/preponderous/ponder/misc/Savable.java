package preponderous.ponder.misc;

import java.util.Map;

/**
 * @author Daniel Stephenson
 */
public interface Savable {
    Map<String, String> save();
    void load(Map<String, String> data);
}