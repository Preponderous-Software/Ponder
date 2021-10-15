package preponderous.ponder.misc;

import preponderous.ponder.misc.specification.modifiers.Cacheable;
import preponderous.ponder.misc.specification.ICache;

import java.util.ArrayList;
import java.util.HashSet;

public class Cache implements ICache {

    private HashSet<Cacheable> cache = new HashSet<>();
    private ArrayList<Cacheable> storage;
    
    public Cache(ArrayList<Cacheable> storage) {
        this.storage = storage;
    }

    @Override
    public Cacheable lookup(Object key) {
        Cacheable object = checkCache(key);
        if (object == null) {
            return checkStorage(key);
        }
        return object;
    }

    private Cacheable checkCache(Object key) {
        for (Cacheable object : cache) {
            if (object.getKey().equals(key)) {
                return object;
            }
        }
        return null;
    }

    private Cacheable checkStorage(Object key) {
        Cacheable object = null;
        for (Cacheable o : storage) {
            if (o.getKey().equals(key)) {
                object = o;
            }
        }
        if (object != null) {
            cache.add(object);
        }
        return object;
    }
}
