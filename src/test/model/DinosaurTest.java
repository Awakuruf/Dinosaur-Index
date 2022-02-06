package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DinosaurTest {

    private Dinosaur discoveredDinosaur;
    private Location location;
    private MesozoicEra era;
    private DietType diet;

    @BeforeEach
    void runBefore() {
        discoveredDinosaur = new Dinosaur("Albertosaurus");
    }

    @Test
    void testConstructor() {
        assertEquals("Albertosaurus", discoveredDinosaur.getName());
    }

    @Test
    void testAddDescription() {
        discoveredDinosaur.addDescription("A cousin of tyrannosaurus found in Alberta.");
        assertEquals("A cousin of tyrannosaurus found in Alberta.", discoveredDinosaur.getDescription());
    }

    @Test
    void testAddSize() {
        discoveredDinosaur.addSize(12);
        assertEquals(12, discoveredDinosaur.getSize());
    }

    @Test
    void testAddLocation() {
        discoveredDinosaur.addLocationFound("North America");
        assertEquals("North America", discoveredDinosaur.getLocation());
    }

    @Test
    void testIsOriginDinosaur() {
        discoveredDinosaur.isOriginDinosaur("Parasaurorophs");
        assertFalse(discoveredDinosaur.isOriginDinosaur("Parasaurorophs"));
        discoveredDinosaur.isOriginDinosaur("Tyrannosaurus");
        assertTrue(discoveredDinosaur.isOriginDinosaur("Tyrannosaurus"));
        discoveredDinosaur.isOriginDinosaur("Albertosaurus");
        assertFalse(discoveredDinosaur.isOriginDinosaur("Albertosaurus"));
    }

    @Test
    void testAddDiet() {
        diet = new DietType();
        discoveredDinosaur.addDiet("Herbivore");
        assertEquals("Herbivore", discoveredDinosaur.getDiet());
    }

    @Test
    void testName(){
        assertFalse((discoveredDinosaur.getName()).isEmpty());
    }
}