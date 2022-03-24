package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DinosaurTest {

    private Dinosaur testDinosaur;
    private ImageIcon image;

    @BeforeEach
    void runBefore() {
        testDinosaur = new Dinosaur("Albertosaurus");
    }

    @Test
    void testConstructor() {
        assertEquals("Albertosaurus", testDinosaur.getName());
    }

    @Test
    void testAddDescription() {
        testDinosaur.addDescription("A cousin of tyrannosaurus found in Alberta.");
        assertEquals("A cousin of tyrannosaurus found in Alberta.", testDinosaur.getDescription());
    }

    @Test
    void testAddSize() {
        testDinosaur.addSize(12);
        assertEquals(12, testDinosaur.getSize());
        testDinosaur.addSize(13);
        assertEquals(13, testDinosaur.getSize());
    }

    @Test
    void testAddLocation() {
        testDinosaur.addLocationFound("North America");
        assertEquals("North America", testDinosaur.getLocation());
    }

    @Test
    void testAddDiet() {
        testDinosaur.addDiet("Herbivore");
        assertEquals("Herbivore", testDinosaur.getDiet());
        testDinosaur.addDiet("Carnivore");
        assertEquals("Carnivore", testDinosaur.getDiet());
        testDinosaur.addDiet("Omnivore");
        assertEquals("Omnivore", testDinosaur.getDiet());
    }

    @Test
    void testAddEra() {
        testDinosaur.addEra("Cretaceous");
        assertEquals("Cretaceous", testDinosaur.getEra());
    }

    @Test
    void testGetDinoPage() {
        testDinosaur.returnDinosaurPage();
        assertEquals("Albertosaurus", testDinosaur.returnDinosaurPage());
    }

    @Test
    void testImageFunctions() {
        testDinosaur.addImageDirectory("./images/giga.jpeg");
        testDinosaur.addImage(testDinosaur.getImageDirectory());
        testDinosaur.pasteImage(image);
        assertEquals("./images/giga.jpeg", testDinosaur.getImageDirectory());
        assertEquals(image, testDinosaur.getImage());
        image = new ImageIcon("./images/giga.jpeg");
        testDinosaur.addImage("./images/giga.jpeg");
        assertEquals("./images/giga.jpeg", testDinosaur.getImageDirectory());
    }







}