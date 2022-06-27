package preponderous.ponder.cache;

public final class CacheConfiguration<K, V> {
    private final String name;
    private final long capacity;

    public CacheConfiguration(String name, long capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public CacheConfiguration(String name) {
        this(name, 20L);
    }

    public String getName() {
        return name;
    }

    public long getCapacity() {
        return capacity;
    }
}
