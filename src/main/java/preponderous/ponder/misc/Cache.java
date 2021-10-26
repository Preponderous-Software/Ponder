package preponderous.ponder.misc;

import preponderous.ponder.modifiers.Cacheable;

import java.util.ArrayList;
import java.util.HashSet;

public class Cache {

    private HashSet<Cacheable> cache = new HashSet<>();
    private ArrayList<Cacheable> storage;

    /**
     * Constructor to initialize the Cache.
     *
     */
    public Cache(ArrayList<Cacheable> storage) {
        this.storage = storage;
    }

    /**
     * Method to look up an cacheable object and cache it if it isn't in the cache.
     *
     */
    public Cacheable lookup(Object key) {
        Cacheable object = checkCache(key);
        if (object == null) {
            return checkStorage(key);
        }
        return object;
    }


    /**
     * Method to check if a cacheable object is in the cache.
     *
     */
    private Cacheable checkCache(Object key) {
        for (Cacheable object : cache) {
            if (object.getKey().equals(key)) {
                return object;
            }
        }
        return null;
    }

    /**
     * Method to check if a cacheable object is in storage.
     *
     */
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
