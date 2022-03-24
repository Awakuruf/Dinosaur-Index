package model;

import javax.swing.*;
import java.awt.*;

public abstract class DefaultDinos {
    protected static DinosaurList catalogue = new DinosaurList("kappa");
    private Dinosaur tyrano;
    private Dinosaur trike;
    private Dinosaur stego;
    private Dinosaur eoraptor;
    private Dinosaur giga;
    private Dinosaur coel;

    // MODIFIES: this
    // EFFECTS: Creates the first embedded dinosaur that represent each section of index.
    protected void makeDinosaur1() {
        tyrano = new Dinosaur("Tyrannosaurus");
        tyrano.addLocationFound("North America");
        tyrano.addDescription("Tyrant King Lizard");
        tyrano.addSize(12);
        tyrano.addDiet("Carnivore");
        tyrano.addEra("Cretaceous");
        tyrano.addImageDirectory("./images/trex.jpeg");
        tyrano.addImage(tyrano.getImageDirectory());
    }

    // MODIFIES: this
    // EFFECTS: Creates the second embedded dinosaur that represent each section of index.
    protected void makeDinosaurs2() {
        trike = new Dinosaur("Triceratops");
        trike.addEra("Cretaceous");
        trike.addSize(9);
        trike.addDescription("Three Horned Lizard");
        trike.addLocationFound("North America");
        trike.addDiet("Herbivore");
        trike.addImageDirectory("./images/trike.jpg");
        trike.addImage(trike.getImageDirectory());
    }

    // MODIFIES: this
    // EFFECTS: Creates the third embedded dinosaur that represent each section of index.
    protected void makeDinosaurs3() {
        eoraptor = new Dinosaur("Eoraptor");
        eoraptor.addEra("Triassic");
        eoraptor.addSize(3);
        eoraptor.addDescription("First ever raptor to exist on earth.");
        eoraptor.addLocationFound("Asia");
        eoraptor.addDiet("Omnivore");
        eoraptor.addImageDirectory("./images/eoraptor.jpeg");
        eoraptor.addImage(eoraptor.getImageDirectory());
    }

    // MODIFIES: this
    // EFFECTS: Creates the fourth embedded dinosaur that represent each section of index.
    protected void makeDinosaurs4() {
        stego = new Dinosaur("Stegosaurus");
        stego.addEra("Jurassic");
        stego.addSize(10);
        stego.addDescription("Spiked dinosaur, existed in Jurassic Period");
        stego.addLocationFound("Africa");
        stego.addDiet("Herbivore");
        stego.addImageDirectory("./images/stego.jpeg");
        stego.addImage(stego.getImageDirectory());
    }

    // MODIFIES: this
    // EFFECTS: Creates the fifth embedded dinosaur that represent each section of index.
    protected void makeDinosaurs5() {
        giga = new Dinosaur("Giganotosaurus");
        giga.addEra("Cretaceous");
        giga.addSize(14);
        giga.addDescription("Biggest type of Tyranosaur");
        giga.addLocationFound("South America");
        giga.addDiet("Carnivore");
        giga.addImageDirectory("./images/giga.jpeg");
        giga.addImage(giga.getImageDirectory());
    }

    // MODIFIES: this
    // EFFECTS: Creates the sixth embedded dinosaur that represent each section of index.
    protected void makeDinosaurs6() {
        coel = new Dinosaur("Coelophysis");
        coel.addEra("Triassic");
        coel.addSize(2);
        coel.addDescription("The first ever living Dinosaur dated back 1000 million years ago.");
        coel.addLocationFound("Africa // North America");
        coel.addDiet("Omnivore");
        coel.addImageDirectory("./images/coel.jpg");
        coel.addImage(coel.getImageDirectory());
    }

    protected void setDefaultDinoIndex() {
        makeDinosaur1();
        makeDinosaurs2();
        makeDinosaurs3();
        makeDinosaurs4();
        makeDinosaurs5();
        makeDinosaurs6();
        catalogue.addToCatalogueOfDino(tyrano);
        catalogue.addToCatalogueOfDino(trike);
        catalogue.addToCatalogueOfDino(coel);
        catalogue.addToCatalogueOfDino(stego);
        catalogue.addToCatalogueOfDino(eoraptor);
        catalogue.addToCatalogueOfDino(giga);
    }




}
