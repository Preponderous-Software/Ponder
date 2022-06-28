package preponderous.ponder.cache;

public interface CacheManager {

    <K, V> Cache<K, V> createCache(
            String name,
            Class<K> keyType,
            Class<V> valueType,
            long capacity
    );

    <K, V> Cache<K, V> createCache(CacheConfiguration<K, V> config);

}
