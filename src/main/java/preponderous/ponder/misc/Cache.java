/*
  Copyright (c) 2022 Preponderous Software
  MIT License
 */
package preponderous.ponder.misc;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author Daniel McCoy Stephenson
 */
public class Cache {
    private HashSet<Cacheable> cache = new HashSet<>();
    private ArrayList<Cacheable> storage;

    /**
     * Constructor to initialize the Cache.
     *
     * @param storage   {@link ArrayList} of {@link Cacheable} objects.
     */
    public Cache(ArrayList<Cacheable> storage) {
        this.storage = storage;
    }

    /**
     * Method to look up a cacheable object and cache it if it isn't in the cache.
     *
     * @param key   Object to use as a key when searching.
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
     * @param key   Object to use as a key when searching.
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
     * @param key   Object to use as a key when searching.
     */
    private Cacheable checkStorage(Object key) {
        Cacheable objectToReturn = null;
        for (Cacheable object : storage) {
            if (object.getKey().equals(key)) {
                objectToReturn = object;
            }
        }
        addToCache(objectToReturn);
        return objectToReturn;
    }

    private void addToCache(Cacheable object) {
        if (object != null) {
            cache.add(object);
        }
    }
}