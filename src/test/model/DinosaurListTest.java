package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DinosaurListTest {
    private DinosaurList testDinoCatalogue;
    private Dinosaur testDinosaur;

    @BeforeEach
    void runBefore() {
        testDinoCatalogue = new DinosaurList("DinoIndex #1");
        testDinosaur = new Dinosaur("Test-Dino");
    }

    @Test
    void testConstructor() {
        assertTrue(testDinoCatalogue.returnCatalogueOfDinosaur().isEmpty());
        assertEquals(0,testDinoCatalogue.returnCatalogueOfDinosaur().size());
    }

    @Test
    void testAddToCatalogue() {
        testDinoCatalogue.addToCatalogueOfDino(testDinosaur);
        assertEquals(testDinosaur, testDinoCatalogue.returnCatalogueOfDinosaur().get(0));
        assertEquals(1, testDinoCatalogue.returnCatalogueOfDinosaur().size());
        testDinoCatalogue.addToCatalogueOfDino(testDinosaur);
        assertEquals(testDinosaur, testDinoCatalogue.returnCatalogueOfDinosaur().get(1));
        assertEquals(2, testDinoCatalogue.returnCatalogueOfDinosaur().size());
    }

    @Test
    void testFilterByDiet() {
        testDinoCatalogue.addToCatalogueOfDino(testDinosaur);
        testDinoCatalogue.filterByDiet("Carnivore");
        assertFalse(testDinoCatalogue.returnCatalogueOfDinosaur().isEmpty());
        testDinosaur = new Dinosaur("Albertosaurus");
        testDinoCatalogue.addToCatalogueOfDino(testDinosaur);
        testDinosaur.addDiet("Carnivore");
        testDinoCatalogue.filterByDiet("Carnivore");
        assertEquals(1 , testDinoCatalogue.filterByDiet("Carnivore").size());
        assertEquals(testDinosaur, testDinoCatalogue.filterByDiet("Carnivore").get(0));
        testDinosaur = new Dinosaur("Deinonychus");
        testDinoCatalogue.addToCatalogueOfDino(testDinosaur);
        testDinosaur.addDiet("Carnivore");
        testDinoCatalogue.filterByDiet("Carnivore");
        assertEquals(2, testDinoCatalogue.filterByDiet("Carnivore").size());
        assertEquals(testDinosaur, testDinoCatalogue.filterByDiet("Carnivore").get(1));
        testDinosaur = new Dinosaur("Parasaur");
        testDinoCatalogue.addToCatalogueOfDino(testDinosaur);
        testDinosaur.addDiet("Herbivore");
        assertEquals(2, testDinoCatalogue.filterByDiet("Carnivore").size());
        assertEquals(1, testDinoCatalogue.filterByDiet("Herbivore").size());
        assertEquals(testDinosaur, testDinoCatalogue.filterByDiet("Herbivore").get(0));
    }

    @Test
    void testNullFilterDiet() {
        testDinoCatalogue.addToCatalogueOfDino(testDinosaur);
        assertEquals(0, testDinoCatalogue.filterByDiet("Carnivore").size());
        assertEquals("No Diet inputted", testDinosaur.getDiet());
        assertTrue(testDinoCatalogue.filterByDiet("Carnivore").isEmpty());
    }

    @Test
    void testFilterByEra() {
        testDinoCatalogue.filterByEra("Jurassic");
        assertTrue(testDinoCatalogue.returnCatalogueOfDinosaur().isEmpty());
        testDinosaur = new Dinosaur("Allosaurus");
        testDinoCatalogue.addToCatalogueOfDino(testDinosaur);
        testDinosaur.addEra("Jurassic");
        testDinoCatalogue.filterByEra("Jurassic");
        assertEquals(testDinosaur, testDinoCatalogue.filterByEra("Jurassic").get(0));
        assertEquals(1, testDinoCatalogue.filterByEra("Jurassic").size());
        testDinosaur = new Dinosaur("Daspletosaurus");
        testDinoCatalogue.addToCatalogueOfDino(testDinosaur);
        testDinosaur.addEra("Cretaceous");
        testDinoCatalogue.filterByEra("Jurassic");
        assertEquals(1, testDinoCatalogue.filterByEra("Jurassic").size());
        testDinosaur = new Dinosaur("Carcardontosaurus");
        testDinoCatalogue.addToCatalogueOfDino(testDinosaur);
        testDinosaur.addEra("Jurassic");
        testDinoCatalogue.filterByEra("Jurassic");
        assertEquals(testDinosaur, testDinoCatalogue.filterByEra("Jurassic").get(1));
        assertEquals(2, testDinoCatalogue.filterByEra("Jurassic").size());
    }

    @Test
    void testNoFilterEra() {
        testDinoCatalogue.addToCatalogueOfDino(testDinosaur);
        assertEquals("No Mesozoic Era inputted", testDinosaur.getEra());
        assertTrue(testDinoCatalogue.filterByEra("Jurassic").isEmpty());
    }

    @Test
    void testFilterByLocation() {
        testDinoCatalogue.filterByLocation("Asia");
        assertTrue(testDinoCatalogue.filterByLocation("Asia").isEmpty());
        testDinosaur = new Dinosaur("Allosaurus");
        testDinoCatalogue.addToCatalogueOfDino(testDinosaur);
        testDinosaur.addLocationFound("Asia");
        testDinoCatalogue.filterByLocation("Asia");
        assertEquals(testDinosaur, testDinoCatalogue.filterByLocation("Asia").get(0));
        assertEquals(1, testDinoCatalogue.filterByLocation("Asia").size());
        testDinosaur = new Dinosaur("Daspletosaurus");
        testDinoCatalogue.addToCatalogueOfDino(testDinosaur);
        testDinosaur.addLocationFound("North America");
        testDinoCatalogue.filterByLocation("Asia");
        assertEquals(1, testDinoCatalogue.filterByLocation("Asia").size());
        testDinosaur = new Dinosaur("Pachycephalosaurus");
        testDinoCatalogue.addToCatalogueOfDino(testDinosaur);
        testDinosaur.addLocationFound("Asia");
        testDinoCatalogue.filterByLocation("Asia");
        assertEquals(testDinosaur, testDinoCatalogue.filterByLocation("Asia").get(1));
        assertEquals(2, testDinoCatalogue.filterByLocation("Asia").size());
        assertEquals(3, testDinoCatalogue.returnCatalogueOfDinosaur().size());
    }

    @Test
    void testNullFilterLocation() {
        testDinoCatalogue.addToCatalogueOfDino(testDinosaur);
        assertEquals("No Location of Discovery inputted", testDinosaur.getLocation());
        assertTrue(testDinoCatalogue.filterByLocation("Asia").isEmpty());
    }

    @Test
    void testPrintDinoNames() {
        assertTrue(testDinoCatalogue.printDinoNames().isEmpty());
        testDinoCatalogue.printDinoNames();
        assertTrue(testDinoCatalogue.printDinoNames().isEmpty());
        testDinoCatalogue.addToCatalogueOfDino(testDinosaur);
        testDinoCatalogue.printDinoNames().add(testDinosaur.getName());
        assertEquals(1, testDinoCatalogue.printDinoNames().size());
        assertEquals(testDinosaur.getName(), testDinoCatalogue.printDinoNames().get(0));
        testDinosaur = new Dinosaur("Albertosaurus");
        testDinoCatalogue.addToCatalogueOfDino(testDinosaur);
        assertEquals(2, testDinoCatalogue.printDinoNames().size());
        assertEquals(testDinosaur.getName(),testDinoCatalogue.printDinoNames().get(1));
    }

    @Test
    void testPrintFilteredNames() {
        assertTrue(testDinoCatalogue.returnCatalogueOfDinosaur().isEmpty());
        testDinoCatalogue.printFilteredNames(testDinoCatalogue.returnCatalogueOfDinosaur());
        testDinoCatalogue.addToCatalogueOfDino(testDinosaur);
        testDinoCatalogue.printFilteredNames(testDinoCatalogue.returnCatalogueOfDinosaur()).add(testDinosaur.getName());
        testDinoCatalogue.printFilteredNames(testDinoCatalogue.returnCatalogueOfDinosaur());
        assertEquals(1, testDinoCatalogue.printFilteredNames(testDinoCatalogue.returnCatalogueOfDinosaur()).size());
        assertEquals(testDinosaur.getName(), testDinoCatalogue.printFilteredNames(testDinoCatalogue.returnCatalogueOfDinosaur()).get(0));
        testDinosaur = new Dinosaur("Daspletosaurus");
        testDinoCatalogue.addToCatalogueOfDino(testDinosaur);
        testDinoCatalogue.printFilteredNames(testDinoCatalogue.returnCatalogueOfDinosaur());
        testDinoCatalogue.printFilteredNames(testDinoCatalogue.returnCatalogueOfDinosaur()).add(testDinosaur.getName());
        assertEquals(2, testDinoCatalogue.printFilteredNames(testDinoCatalogue.returnCatalogueOfDinosaur()).size());
        assertEquals(testDinosaur.getName(), testDinoCatalogue.printFilteredNames(testDinoCatalogue.returnCatalogueOfDinosaur()).get(1));
    }

    @Test
    void testFilterDinoInfo() {
        assertTrue(testDinoCatalogue.returnCatalogueOfDinosaur().isEmpty());
        testDinoCatalogue.addToCatalogueOfDino(testDinosaur);
        testDinoCatalogue.filterDinoInfo(testDinosaur.getName());
        assertEquals(testDinosaur.returnDinosaurPage(), testDinoCatalogue.filterDinoInfo(testDinosaur.getName()));
        testDinoCatalogue.filterDinoInfo("Velociraptor");
        assertEquals(null, testDinoCatalogue.filterDinoInfo("Velociraptor"));
    }
}
