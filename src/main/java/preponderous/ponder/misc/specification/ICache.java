package preponderous.ponder.misc.specification;

import preponderous.ponder.misc.modifiers.Cacheable;

public interface ICache {
    Cacheable lookup(Object key);
}
