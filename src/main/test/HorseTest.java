import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import static org.junit.jupiter.api.Assertions.*;

class HorseTest {
    Horse horse1;


    //----Tests for the constructor
    @Test
    void horseConstrParamIsNullThrEx() {
        assertThrows(IllegalArgumentException.class, () -> {
            horse1 = new Horse(null, 45, 100);
        });
    }

    @Test
    void horseConstructParamIsNullThrExText() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            horse1 = new Horse(null, 45, 100);
        });
        assertEquals("Name cannot be null.", exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void horseConstrParamIsBlankThrEx(String name) {
        assertThrows(IllegalArgumentException.class, () -> {
            horse1 = new Horse(name, 45, 100);
        });
    }

    @Test
    void horseConstructParamIsBlankThrText() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            horse1 = new Horse("", 45, 100);
        });
        assertEquals("Name cannot be blank.", exception.getMessage());
    }

    @Test
    void horseConstructParam2IsNegNumb() {
        assertThrows(IllegalArgumentException.class, () -> {
            horse1 = new Horse("Alice", -10, 100);
        });
    }

    @Test
    void horseConstructParam2IsNegNumbThrExText() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            horse1 = new Horse("Alice", -10, 100);
        });
        assertEquals("Speed cannot be negative.", exception.getMessage());
    }

    @Test
    void horseConstructParam3IsNegNumb() {
        assertThrows(IllegalArgumentException.class, () -> {
            horse1 = new Horse("Alice", 45, -80);
        });
    }

    @Test
    void horseConstructParam3IsNegNumbThrExText() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            horse1 = new Horse("Alice", 45, -80);
        });
        assertEquals("Distance cannot be negative.", exception.getMessage());
    }


    //----Tests for class methods - getName(), getSpeed(), getDistance(), move()
    @Test
    void getName() {
        horse1 = new Horse("Alice", 45, 100);
        assertInstanceOf(String.class, horse1.getName());
    }

    @Test
    void getSpeed() {
        horse1 = new Horse("Alice", 45, 100);
        assertInstanceOf(Double.class, horse1.getSpeed());
    }

    @Test
    void getDistance() {
        horse1 = new Horse("Alice", 45);
        assertInstanceOf(Double.class, horse1.getDistance());
        assertEquals(0.0, horse1.getDistance());
    }

//    @Test
//    public void move() {
//
//    }


}
