import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import static org.junit.jupiter.api.Assertions.*;

class HorseTest {
    Horse horseTest;

    //----Tests for the constructor
    @Test
    void testHorseConstructorParamIsNullThrEx() {
        assertThrows(IllegalArgumentException.class, () -> {
            horseTest = new Horse(null, 45, 100);
        });
    }

    @Test
    void testHorseConstructorParamIsNullThrExText() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            horseTest = new Horse(null, 45, 100);
        });
        assertEquals("Name cannot be null.", exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void testHorseConstructorParamIsBlankThrEx(String name) {
        assertThrows(IllegalArgumentException.class, () -> {
            horseTest = new Horse(name, 45, 100);
        });
    }

    @Test
    void testHorseConstructorParamIsBlankThrText() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            horseTest = new Horse("", 45, 100);
        });
        assertEquals("Name cannot be blank.", exception.getMessage());
    }

    @Test
    void testHorseConstructorParam2IsNegNumb() {
        assertThrows(IllegalArgumentException.class, () -> {
            horseTest = new Horse("Alice", -10, 100);
        });
    }

    @Test
    void testHorseConstructorParam2IsNegNumbThrExText() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            horseTest = new Horse("Alice", -10, 100);
        });
        assertEquals("Speed cannot be negative.", exception.getMessage());
    }

    @Test
    void testHorseConstructorParam3IsNegNumb() {
        assertThrows(IllegalArgumentException.class, () -> {
            horseTest = new Horse("Alice", 45, -80);
        });
    }

    @Test
    void testHorseConstructorParam3IsNegNumbThrExText() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            horseTest = new Horse("Alice", 45, -80);
        });
        assertEquals("Distance cannot be negative.", exception.getMessage());
    }


    //----Tests for class methods - getName(), getSpeed(), getDistance(), move()
    @Test
    void testHorseGetName() {
        horseTest = new Horse("Alice", 45, 100);
        assertInstanceOf(String.class, horseTest.getName());
    }

    @Test
    void testHorseGetSpeed() {
        horseTest = new Horse("Alice", 45, 100);
        assertInstanceOf(Double.class, horseTest.getSpeed());
    }

    @Test
    void testHorseGetDistance() {
        horseTest = new Horse("Alice", 45);
        assertInstanceOf(Double.class, horseTest.getDistance());
        assertEquals(0.0, horseTest.getDistance());
    }

//    @Test
//    public void move() {
//
//    }


}
