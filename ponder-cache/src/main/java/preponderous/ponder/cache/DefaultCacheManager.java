package preponderous.ponder.cache;

public final class DefaultCacheManager implements CacheManager {
    @Override
    public <K, V> Cache<K, V> createCache(String name, Class<K> keyType, Class<V> valueType, long capacity) {
        return new DefaultCache<>(capacity);
    }

    @Override
    public <K, V> Cache<K, V> createCache(CacheConfiguration<K, V> config) {
        return new DefaultCache<>(config.getCapacity());
    }
}
