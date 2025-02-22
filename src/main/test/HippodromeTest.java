import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class HippodromeTest {
    Hippodrome hippodromeTest;

    @Test
    void testHippodromeConstructorParamIsNullThrEx() {
        assertThrows(IllegalArgumentException.class, () -> {
            hippodromeTest = new Hippodrome(null);
        });
    }

    @Test
    void testHippodromeConstructorParamIsNullThrExText() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            hippodromeTest = new Hippodrome(null);
        });
        assertEquals("Horses cannot be null.", exception.getMessage());
    }

    @Test
    void testHippodromeConstructorParamIsEmptyThrEx() {

        assertThrows(IllegalArgumentException.class, () -> {
           hippodromeTest = new Hippodrome(new ArrayList<>());
        });
    }

    @Test
    void testHippodromeConstructorParamIsEmptyThrExText() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            hippodromeTest = new Hippodrome(new ArrayList<>());
        });
        assertEquals("Horses cannot be empty.", exception.getMessage());
    }

    @Test
    void testHippodromeGetHorses() {
        List<Horse> horses = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            horses.add(new Horse("Horse" + i, 25 + i, 100 + i));
        }
        Hippodrome hippodrome = new Hippodrome(horses);
        List<Horse> result = hippodrome.getHorses();
        assertEquals(horses, result);
    }

    @Test
    void testHippodromeMove() {
        List<Horse> horses = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            horses.add(mock(Horse.class));
        }
        Hippodrome hippodrome = new Hippodrome(horses);
        hippodrome.move();
        for (Horse horse : horses) {
            verify(horse).move();
        }
    }

    @Test
    void testHippodromeGetWinnerUnmodList() {
       Horse horse1 = new Horse("Alice", 45, 100);
       Horse horse2 = new Horse("Martin", 50, 120);
       Horse horse3 = new Horse("Bob", 55, 150);

       Hippodrome hippodrome = new Hippodrome(Arrays.asList(horse1, horse2, horse3));
       assertEquals(horse3, hippodrome.getWinner());
    }
}