package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DinosaurListTest {
    private DinosaurList testDinoCatalogue;
    private Dinosaur testDinosaur;
    private ArrayList<Dinosaur> dinosaurs;
    private ArrayList<Dinosaur> filterdList;

    @BeforeEach
    void runBefore() {
        testDinoCatalogue = new DinosaurList();
        testDinosaur = new Dinosaur("Test-Dino");
        dinosaurs = new ArrayList<>();
    }

    @Test
    void testConstructor() {
        dinosaurs = new ArrayList<>();
        assertTrue(dinosaurs.isEmpty());
        assertEquals(0,dinosaurs.size());
    }

    @Test
    void testAddToCatalogue() {
        testDinoCatalogue.addToCatalogueOfDino(testDinosaur);
        dinosaurs.add(testDinosaur);
        assertEquals(testDinosaur, dinosaurs.get(0));
        assertEquals(1, dinosaurs.size());
        testDinoCatalogue.addToCatalogueOfDino(testDinosaur);
        dinosaurs.add(testDinosaur);
        assertEquals(testDinosaur, dinosaurs.get(1));
        assertEquals(2, dinosaurs.size());
    }

    @Test
    void testFilterByDiet() {
        testDinoCatalogue.filterByDiet("Carnivore");
        assertTrue(dinosaurs.isEmpty());
        testDinosaur = new Dinosaur("Albertosaurus");
        testDinosaur.addDiet("Carnivore");
        testDinoCatalogue.addToCatalogueOfDino(testDinosaur);
        dinosaurs.add(testDinosaur);
        testDinoCatalogue.filterByDiet("Carnivore");
        filterdList = new ArrayList<>();
        filterdList.add(testDinosaur);
        assertEquals(1, filterdList.size());
        assertEquals(testDinosaur, filterdList.get(0));
        testDinosaur = new Dinosaur("Deinonychus");
        testDinosaur.addDiet("Carnivore");
        dinosaurs.add(testDinosaur);
        testDinoCatalogue.filterByDiet("Carnivore");
        filterdList.add(testDinosaur);
        assertEquals(2, filterdList.size());
        assertEquals(testDinosaur, filterdList.get(1));
        testDinosaur = new Dinosaur("Parasaur");
        testDinosaur.addDiet("Herbivore");
        testDinoCatalogue.filterByDiet("Carnivore");
        assertEquals(2, filterdList.size());
    }

    @Test
    void testFilterByEra() {
        testDinoCatalogue.filterByEra("Jurassic");
        assertTrue(dinosaurs.isEmpty());
        testDinosaur = new Dinosaur("Allosaurus");
        testDinoCatalogue.addToCatalogueOfDino(testDinosaur);
        dinosaurs.add(testDinosaur);
        testDinosaur.addEra("Jurassic");
        testDinoCatalogue.filterByEra("Jurassic");
        filterdList = new ArrayList<>();
        filterdList.add(testDinosaur);
        assertEquals(testDinosaur, filterdList.get(0));
        assertEquals(1, filterdList.size());
        testDinosaur = new Dinosaur("Daspletosaurus");
        testDinoCatalogue.addToCatalogueOfDino(testDinosaur);
        dinosaurs.add(testDinosaur);
        testDinosaur.addEra("Cretaceous");
        testDinoCatalogue.filterByEra("Jurassic");
        assertEquals(1, filterdList.size());
        testDinosaur = new Dinosaur("Daspletosaurus");
        testDinoCatalogue.addToCatalogueOfDino(testDinosaur);
        dinosaurs.add(testDinosaur);
        testDinosaur.addEra("Jurassic");
        testDinoCatalogue.filterByEra("Jurassic");
        filterdList.add(testDinosaur);
        assertEquals(testDinosaur, filterdList.get(1));
        assertEquals(2, filterdList.size());

    }

    @Test
    void testFilterByLocation() {
        testDinoCatalogue.filterByLocation("Asia");
        assertTrue(dinosaurs.isEmpty());
        testDinosaur = new Dinosaur("Allosaurus");
        testDinoCatalogue.addToCatalogueOfDino(testDinosaur);
        dinosaurs.add(testDinosaur);
        testDinosaur.addLocationFound("Asia");
        testDinoCatalogue.filterByLocation("Asia");
        filterdList = new ArrayList<>();
        filterdList.add(testDinosaur);
        assertEquals(testDinosaur, filterdList.get(0));
        assertEquals(1, filterdList.size());
        testDinosaur = new Dinosaur("Daspletosaurus");
        testDinoCatalogue.addToCatalogueOfDino(testDinosaur);
        dinosaurs.add(testDinosaur);
        testDinosaur.addLocationFound("North America");
        testDinoCatalogue.filterByLocation("Asia");
        assertEquals(1, filterdList.size());
        testDinosaur = new Dinosaur("Pachycephalosaurus");
        testDinoCatalogue.addToCatalogueOfDino(testDinosaur);
        dinosaurs.add(testDinosaur);
        testDinosaur.addLocationFound("Asia");
        testDinoCatalogue.filterByLocation("Asia");
        filterdList.add(testDinosaur);
        assertEquals(testDinosaur, filterdList.get(1));
        assertEquals(2, filterdList.size());
        assertEquals(3, dinosaurs.size());
    }

    @Test
    void testPrintDinoNames() {
        assertTrue(dinosaurs.isEmpty());
        testDinoCatalogue.printDinoNames();
        ArrayList<String> listOfNames = new ArrayList<>();
        assertTrue(listOfNames.isEmpty());
        testDinoCatalogue.addToCatalogueOfDino(testDinosaur);
        dinosaurs.add(testDinosaur);
        listOfNames.add(testDinosaur.getName());
        assertEquals(1, listOfNames.size());
        assertEquals(listOfNames, testDinoCatalogue.printDinoNames());
        assertEquals(testDinosaur.getName(), listOfNames.get(0));
        testDinosaur = new Dinosaur("Albertosaurus");
        testDinoCatalogue.addToCatalogueOfDino(testDinosaur);
        dinosaurs.add(testDinosaur);
        listOfNames.add(testDinosaur.getName());
        assertEquals(2, listOfNames.size());
        assertEquals(listOfNames, testDinoCatalogue.printDinoNames());
        assertEquals(testDinosaur.getName(),listOfNames.get(1));
    }

    @Test
    void testPrintFilteredNames() {
        assertTrue(dinosaurs.isEmpty());
        testDinoCatalogue.printFilteredNames(dinosaurs);
        ArrayList<String> filteredNames = new ArrayList<>();
        assertTrue(filteredNames.isEmpty());
        testDinoCatalogue.addToCatalogueOfDino(testDinosaur);
        dinosaurs.add(testDinosaur);
        testDinoCatalogue.printFilteredNames(dinosaurs);
        filteredNames.add(testDinosaur.getName());
        assertEquals(1, filteredNames.size());
        assertEquals(testDinosaur.getName(), filteredNames.get(0));
        assertEquals(filteredNames, testDinoCatalogue.printFilteredNames(dinosaurs));
        testDinosaur = new Dinosaur("Daspletosaurus");
        dinosaurs.add(testDinosaur);
        testDinoCatalogue.printFilteredNames(dinosaurs);
        filteredNames.add(testDinosaur.getName());
        assertEquals(2, filteredNames.size());
        assertEquals(testDinosaur.getName(), filteredNames.get(1));
        assertEquals(filteredNames, testDinoCatalogue.printFilteredNames(dinosaurs));
    }

    @Test
    void testFilterDinoInfo() {
        assertTrue(dinosaurs.isEmpty());
        testDinoCatalogue.addToCatalogueOfDino(testDinosaur);
        dinosaurs.add(testDinosaur);
        testDinoCatalogue.filterDinoInfo(testDinosaur.getName());
        assertEquals(testDinosaur.returnDinosaurPage(), testDinoCatalogue.filterDinoInfo(testDinosaur.getName()));
    }
}
