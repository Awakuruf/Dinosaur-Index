package model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DietTypeTest {
    private DietType testDiet;
    private Dinosaur testDinosaur;

    @Test
    void testConstructor() {
        testDiet = new DietType();
        List<Dinosaur> diet1 = testDiet.returnDiet("Carnivore");
        assertTrue(diet1.isEmpty());
    }

    @Test
    void testAddToEraGroup() {
        testDiet = new DietType();
        testDiet.addToDietGroup(testDinosaur,"Carnivore");
        List<Dinosaur> diet1 = testDiet.returnDiet("Carnivore");
        assertEquals(testDinosaur, diet1.get(0));
        assertEquals(1, diet1.size());
    }
}

