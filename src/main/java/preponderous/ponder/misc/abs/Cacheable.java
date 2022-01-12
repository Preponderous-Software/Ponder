/*
  Copyright (c) 2022 Preponderous Software
  MIT License
 */
package preponderous.ponder.misc.abs;

/**
 * @author Daniel McCoy Stephenson
 */
public interface Cacheable {

    /**
     * This can be used to get the key associated with the cacheable object.
     * @return The key associated with the cacheable object.
     */
    Object getKey();
}