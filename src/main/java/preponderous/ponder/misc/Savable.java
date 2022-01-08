package preponderous.ponder.misc;

import java.util.Map;

/**
 * @author Daniel McCoy Stephenson
 */
public interface Savable {
    Map<String, String> save();
    void load(Map<String, String> data);
}
