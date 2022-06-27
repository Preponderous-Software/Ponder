package preponderous.ponder.cache;

import java.util.Set;
import java.util.function.Predicate;

public interface Cache<K, V> {

    V get(K key);
    void set(K key, V value);
    boolean containsKey(K key);
    void remove(K key);
    void removeMatching(Predicate<V> predicate);
    Set<K> keys();
    void clear();

}
