package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class TorpedoStoreTest {

    @Test
    void fire_Success() {
        // Arrange
        TorpedoStore store = new TorpedoStore(1);

        // Act
        boolean result = store.fire(1);

        // Assert
        assertEquals(true, result);
    }

    @Test 
    void fire_EmptyStore(){
        TorpedoStore store = new TorpedoStore(0, 0.0);

        assertThrows(IllegalArgumentException.class, () -> {
            store.fire(1);
        });
    }

    @Test 
    void fire_AlwaysFails () {
        TorpedoStore store = new TorpedoStore(10, 1.0);

        boolean result = store.fire(1);

        assertFalse(result);
        assertEquals(10, store.getTorpedoCount());
    }

    @Test 
    void test_Initialization() {

        TorpedoStore store = new TorpedoStore(5, 0.0);
        assertEquals(5, store.getTorpedoCount());
    }
}
