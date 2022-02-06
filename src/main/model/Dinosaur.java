package model;

import java.util.ArrayList;
import java.util.List;

public class Dinosaur {
    //Add your dinosaurs or look up the dinosaur either by name or filtering!
    //Dinosaur includes these properties: Description, Location of where the fossil was discovered,
    //family tree it belongs to, size, diet and which mesozoic era it existed in.

    //Fields
    private String nameOfDinosaur;
    private String description;
    private String  diet;
    private Integer size;
    private String location;
    private String era;



    // REQUIRES: The string must not be empty.
    // EFFECTS: Constructs a dinosaur with the discovered name.
    // Properties that hasn't been discovered remain as null.
    public Dinosaur(String name) {
        this.nameOfDinosaur = name;
        description = null;
        size = null;
        diet = null;
        location = null;
        era = null;
    }

    // REQUIRES: The string must not be empty.
    // MODIFIES: this
    // EFFECTS: Returns true if the Dinosaur is the origin dinosaur of the family tree and creates
    // a list of dinosaurs that represents its family tree.
    public Boolean isOriginDinosaur(String name) {
        if (name.equals("Tyrannosaurus")) {
            ArrayList<Dinosaur> trexFamilyLine = new ArrayList<Dinosaur>();
            return true;
        } else if (name.equals("Brontosaurus")) {
            ArrayList<Dinosaur> brontoFamilyLine = new ArrayList<Dinosaur>();
            return true;
        } else if (name.equals("Stegosaurus")) {
            ArrayList<Dinosaur> stegoFamilyLine = new ArrayList<Dinosaur>();
            return true;
        } else if (name.equals("Triceratops")) {
            ArrayList<Dinosaur> trikeFamilyLine = new ArrayList<Dinosaur>();
            return true;
        } else if (name.equals("Troodon")) {
            ArrayList<Dinosaur> troodonFamilyLine = new ArrayList<Dinosaur>();
            return true;
        } else if (name.equals("Hadrosaurus")) {
            ArrayList<Dinosaur> hardosaurusFamilyLine = new ArrayList<Dinosaur>();
            return true;
        } else {
            return false;
        }
    }

    // REQUIRES: The string must not be empty and this dinosaur cannot be the origin dinosaur.
    // MODIFIES: this
    // EFFECTS: Adds the description of the dinosaur such as its trait and behaviour.
    public void addDescription(String description) {
        this.description = description;
    }

    // REQUIRES: The string must not be empty.
    // MODIFIES: this
    // EFFECTS: Add the location of where the fossil was found.
    public void addLocationFound(String location) {
        this.location = location;
    }

    // REQUIRES: The length must be > 0.
    // MODIFIES: this
    // EFFECTS: Adds the size of the dinosaur in meters.
    public void addSize(int length) {
        this.size = length;
    }


    // REQUIRES: The string must not be empty.
    // MODIFIES: this
    // EFFECTS: Add what kind of diet the dinosaur had
    public void addDiet(String typeofdiet) {
        this.diet = typeofdiet;
    }

    /* // REQUIRES: The string must not be empty and the originDinosaur must be the name of originDinosaur
    // EFFECTS: makes a family tree if the given dinosaur is an origin dinosaur
    public ArrayList<String> makeFamilyTree(String originDinosaur) {
        nameOfOrigin = originDinosaur;
        this.dinosaurTree = new ArrayList<String>();
    } */

    /* // REQUIRES: The string must not be empty and the dinosaur must be the origin dinosaur.
    // EFFECTS: Filters and returns all the dinosaurs in the index to
    // those that originate from the input dinosaur.
    public List<Dinosaur> filterByFamilyTree(Dinosaur nameOfDino) {
        return null; //STUB
    } */

    // REQUIRES: The string must not be empty.
    // MODIFIES: this
    // EFFECTS: Adds the period of mesozoic era this dinosaur lived in.
    public void addEra(String era) {
        this.era = era;
    }

    // REQUIRES: The dinosaur page must be created.
    // MODIFIES: this
    // EFFECTS: Returns all the information under the designated dinosaur.
    public void returnDinosaurPage() {
        System.out.println("Name:" + nameOfDinosaur);
        System.out.println("Description:" + description);
        System.out.println("Size:" + size);
        System.out.println("Location of Discovery:" + location);
        System.out.println("Family Tree of Dinosaur: Unknown");
        System.out.println("Diet:" + diet);
        System.out.println("Mesozoic Period: " + era);
        System.out.println("Is an Origin Dinosaur of the tree:" + isOriginDinosaur(nameOfDinosaur));
    }

    //EFFECT: Getter for Description
    public String getDescription() {
        return description;
    }

    //EFFECT: Getter for Name
    public String getName() {
        return nameOfDinosaur;
    }

    //EFFECT: Getter for Size
    public int getSize() {
        return size;
    }

    //EFFECT: Getter for Location
    public String getLocation() {
        return location;
    }

    //EFFECT: Getter for Diet
    public String getDiet() {
        return diet;
    }

    //EFFECT: Getter for Era
    public String getEra() {
        return era;
    }



}
