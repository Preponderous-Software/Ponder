package preponderous.ponder.misc.specification;

import preponderous.ponder.misc.specification.modifiers.Cacheable;

public interface ICache {
    Cacheable lookup(Object key);
}
