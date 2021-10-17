package preponderous.ponder.misc.specification;

import preponderous.ponder.modifiers.Cacheable;

public interface ICache {
    Cacheable lookup(Object key);
}
