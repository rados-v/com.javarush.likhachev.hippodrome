import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HippodromeTest {
    Hippodrome hippodromeTest;

    @Test
    void hippodromeConstrParamIsNullThrEx() {
        assertThrows(IllegalArgumentException.class, () -> {
            hippodromeTest = new Hippodrome(null);
        });
    }

    @Test
    void hippodromeConstrParamIsNullThrExText() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            hippodromeTest = new Hippodrome(null);
        });
        assertEquals("Horses cannot be null.", exception.getMessage());
    }

    @Test
    void getHorses() {
    }

    @Test
    void move() {
    }

    @Test
    void getWinner() {
    }
}