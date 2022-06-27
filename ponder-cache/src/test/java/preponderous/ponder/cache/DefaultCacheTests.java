package preponderous.ponder.cache;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public final class DefaultCacheTests {

    @Test
    public void initializesAtEmptyState() {
        Cache<String, String> underTest = new DefaultCache<>(1);
        assertTrue(underTest.keys().isEmpty());
    }

    @Test
    public void insertedValueCanBeRetrieved() {
        Cache<String, String> underTest = new DefaultCache<>(1);
        underTest.set("key", "value");
        assertEquals("value", underTest.get("key"));
    }

    @Test
    public void oldestEntryRemovedWhenCapacitySurpassed() {
        Cache<String, String> underTest = new DefaultCache<>(1);
        underTest.set("key1", "value1");
        underTest.set("key2", "value2");
        assertTrue(underTest.containsKey("key2"));
        assertFalse(underTest.containsKey("key1"));
    }

}
