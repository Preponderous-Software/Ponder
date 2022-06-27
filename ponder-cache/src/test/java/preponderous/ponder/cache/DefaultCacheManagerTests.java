package preponderous.ponder.cache;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public final class DefaultCacheManagerTests {

    @Test
    public void createsCacheGivenParameters() {
        CacheManager underTest = new DefaultCacheManager();
        Cache<String, String> result = underTest.createCache("cache", String.class, String.class, 20);
        assertNotNull(result);
    }

    @Test
    public void createsCacheGivenConfiguration() {
        CacheManager underTest = new DefaultCacheManager();
        Cache<String, String> result = underTest.createCache(new CacheConfiguration<>("cache", 20));
        assertNotNull(result);
    }

}
