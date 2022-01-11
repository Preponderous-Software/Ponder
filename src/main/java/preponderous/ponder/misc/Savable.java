/*
  Copyright (c) 2022 Preponderous Software
  MIT License
 */
package preponderous.ponder.misc;

import java.util.Map;

/**
 * @author Daniel McCoy Stephenson
 */
public interface Savable {

    /**
     * Saves the object in the form of a map of strings to strings.
     * @return The saved data.
     */
    Map<String, String> save();

    /**
     * Takes a map of strings to strings and loads values in from it.
     * @param data The data to load.
     */
    void load(Map<String, String> data);
}
