package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DinosaurTest {

    private Dinosaur discoveredDinosaur;
    private Dinosaur testDinosaur;
    private DietType testDiet;
    private Location testLocation;
    private MesozoicEra testEra;

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
        discoveredDinosaur.addSize(13);
        assertEquals(13, discoveredDinosaur.getSize());
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
        discoveredDinosaur.isOriginDinosaur("Brotonsaurus");
        assertTrue(discoveredDinosaur.isOriginDinosaur("Brontosaurus"));
        discoveredDinosaur.isOriginDinosaur("Triceratops");
        assertTrue(discoveredDinosaur.isOriginDinosaur("Triceratops"));
        discoveredDinosaur.isOriginDinosaur("Troodon");
        assertTrue(discoveredDinosaur.isOriginDinosaur("Troodon"));
        discoveredDinosaur.isOriginDinosaur("Hadrosaurus");
        assertTrue(discoveredDinosaur.isOriginDinosaur("Hadrosaurus"));
        discoveredDinosaur.isOriginDinosaur("Stegosaurus");
        assertTrue(discoveredDinosaur.isOriginDinosaur("Stegosaurus"));
        discoveredDinosaur.isOriginDinosaur("Albertosaurus");
        assertFalse(discoveredDinosaur.isOriginDinosaur("Albertosaurus"));
    }

    @Test
    void testAddDiet() {
        testDiet = new DietType();
        discoveredDinosaur.addDiet("Herbivore");
        assertEquals("Herbivore", discoveredDinosaur.getDiet());
        testDiet = new DietType();
        discoveredDinosaur.addDiet("Carnivore");
        assertEquals("Carnivore", discoveredDinosaur.getDiet());
        testDiet = new DietType();
        discoveredDinosaur.addDiet("Omnivore");
        assertEquals("Omnivore", discoveredDinosaur.getDiet());
    }

    @Test
    void testAddEra() {
        testEra = new MesozoicEra();
        discoveredDinosaur.addEra("Cretaceous");
        assertEquals("Cretaceous", discoveredDinosaur.getEra());
    }

    @Test
    void testGetDinoPage() {
        discoveredDinosaur.returnDinosaurPage();
        assertEquals("Albertosaurus", discoveredDinosaur.returnDinosaurPage());
    }

    @Test
    void testDietConstructor() {
        testDiet = new DietType();
        List<Dinosaur> diet1 = testDiet.returnDiet("Carnivore");
        assertTrue(diet1.isEmpty());
    }

    @Test
    void testAddToDietGroup() {
        testDiet = new DietType();
        testDiet.addToDietGroup(testDinosaur,"Carnivore");
        List<Dinosaur> diet1 = testDiet.returnDiet("Carnivore");
        assertEquals(testDinosaur, diet1.get(0));
        assertEquals(1, diet1.size());
        testDinosaur = new Dinosaur("Daspletosaurus");
        testDiet.addToDietGroup(testDinosaur,"Carnivore");
        diet1 = testDiet.returnDiet("Carnivore");
        assertEquals(testDinosaur, diet1.get(1));
        assertEquals(2, diet1.size());

        testDiet = new DietType();
        testDinosaur = new Dinosaur("Parasaur");
        testDiet.addToDietGroup(testDinosaur,"Herbivore");
        List<Dinosaur> diet2 = testDiet.returnDiet("Herbivore");
        assertEquals(testDinosaur, diet2.get(0));
        assertEquals(1, diet2.size());

        testDiet = new DietType();
        testDinosaur = new Dinosaur("Oviraptor");
        testDiet.addToDietGroup(testDinosaur,"Omnivore");
        List<Dinosaur> diet3 = testDiet.returnDiet("Omnivore");
        assertEquals(testDinosaur, diet3.get(0));
        assertEquals(1, diet3.size());

        testDiet = new DietType();
        testDinosaur = new Dinosaur("Microraptor");
        testDiet.addToDietGroup(testDinosaur,"Scavenger");
        List<Dinosaur> diet4 = testDiet.returnDiet("Scavenger");
        assertEquals(null, diet4);
    }

    @Test
    void testLocationConstructor() {
        testLocation = new Location();
        List<Dinosaur> location1 = testLocation.returnLocationOfDiscovery("Africa");
        assertTrue(location1.isEmpty());
    }

    @Test
    void testAddToLocationGroup() {
        testLocation = new Location();
        testLocation.addToLocationGroup(testDinosaur,"Africa");
        List<Dinosaur> location1 = testLocation.returnLocationOfDiscovery("Africa");
        assertEquals(testDinosaur, location1.get(0));
        assertEquals(1, location1.size());
        testDinosaur = new Dinosaur("Carnotaurus");
        testLocation.addToLocationGroup(testDinosaur,"Africa");
        location1 = testLocation.returnLocationOfDiscovery("Africa");
        assertEquals(testDinosaur, location1.get(1));
        assertEquals(2, location1.size());
        testDinosaur = new Dinosaur("Tarbosaurus");
        testLocation.addToLocationGroup(testDinosaur,"Africa");
        location1 = testLocation.returnLocationOfDiscovery("Africa");
        assertEquals(testDinosaur, location1.get(2));
        assertEquals(3, location1.size());
        testDinosaur = new Dinosaur("Acrocanthosuarus");
        testLocation.addToLocationGroup(testDinosaur,"Africa");
        location1 = testLocation.returnLocationOfDiscovery("Africa");
        assertEquals(testDinosaur, location1.get(3));
        assertEquals(4, location1.size());


        testLocation = new Location();
        testLocation.addToLocationGroup(testDinosaur,"Asia");
        List<Dinosaur> location2 = testLocation.returnLocationOfDiscovery("Asia");
        assertEquals(testDinosaur, location2.get(0));
        assertEquals(1, location2.size());

        testLocation = new Location();
        testLocation.addToLocationGroup(testDinosaur,"North America");
        List<Dinosaur> location3 = testLocation.returnLocationOfDiscovery("North America");
        assertEquals(testDinosaur, location3.get(0));
        assertEquals(1, location3.size());

        testLocation = new Location();
        testLocation.addToLocationGroup(testDinosaur,"Europe");
        List<Dinosaur> location4 = testLocation.returnLocationOfDiscovery("Europe");
        assertEquals(testDinosaur, location4.get(0));
        assertEquals(1, location4.size());

        testLocation = new Location();
        testDinosaur = new Dinosaur("Yutyrannus");
        testLocation.addToLocationGroup(testDinosaur,"South America");
        List<Dinosaur> location5 = testLocation.returnLocationOfDiscovery("South America");
        assertEquals(testDinosaur, location5.get(0));
        assertEquals(1, location5.size());

        testLocation = new Location();
        testDinosaur = new Dinosaur("Nodosuarus");
        testLocation.addToLocationGroup(testDinosaur,"Australia");
        List<Dinosaur> location7 = testLocation.returnLocationOfDiscovery( "Australia");
        assertEquals(testDinosaur, location7.get(0));
        assertEquals(1, location5.size());

        testLocation = new Location();
        testDinosaur = new Dinosaur("Cryolophosuaurus");
        testLocation.addToLocationGroup(testDinosaur,"Antarctica");
        List<Dinosaur> location6 = testLocation.returnLocationOfDiscovery("Antarctica");
        assertEquals(null, location6);
    }

    @Test
    void testEraConstructor() {
        testEra = new MesozoicEra();
        List<Dinosaur> era1 = testEra.returnMesozoicEra("Jurassic");
        assertTrue(era1.isEmpty());
    }

    @Test
    void testAddToEraGroup() {
        testEra = new MesozoicEra();
        testEra.addToEraGroup(testDinosaur,"Jurassic");
        List<Dinosaur> era1 = testEra.returnMesozoicEra("Jurassic");
        assertEquals(testDinosaur, era1.get(0));
        assertEquals(1, era1.size());
        testDinosaur = new Dinosaur("Camerasaurus");
        testEra.addToEraGroup(testDinosaur,"Jurassic");
        era1 = testEra.returnMesozoicEra("Jurassic");
        assertEquals(testDinosaur, era1.get(1));
        assertEquals(2, era1.size());

        testEra = new MesozoicEra();
        testDinosaur = new Dinosaur("Allosaurus");
        testEra.addToEraGroup(testDinosaur,"Cretaceous");
        List<Dinosaur> era2 = testEra.returnMesozoicEra("Cretaceous");
        assertEquals(testDinosaur, era2.get(0));
        assertEquals(1, era2.size());

        testEra = new MesozoicEra();
        testDinosaur = new Dinosaur("Lystrosaurus");
        testEra.addToEraGroup(testDinosaur,"Triassic");
        List<Dinosaur> era3 = testEra.returnMesozoicEra("Triassic");
        assertEquals(testDinosaur, era3.get(0));
        assertEquals(1, era3.size());

        testEra = new MesozoicEra();
        testDinosaur = new Dinosaur("Doromaeosaurus");
        testEra.addToEraGroup(testDinosaur,"22th Century");
        List<Dinosaur> era4 = testEra.returnMesozoicEra("22th Century");
        assertEquals(null, era4);
    }


}