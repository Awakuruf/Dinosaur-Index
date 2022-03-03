package model;

import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.List;

public class Dinosaur implements Writable {
    //Add your dinosaurs or look up the dinosaur either by name or filtering!
    //Dinosaur includes these properties: Description, Location of where the fossil was discovered,
    //size, diet and which mesozoic era it existed in.

    //Fields
    private String nameOfDinosaur;
    private String description;
    private String diet;
    private Integer size;
    private String location;
    private String era;


    // REQUIRES: The string must not be empty.
    // EFFECTS: Constructs a dinosaur with the discovered name.
    // Properties that hasn't been discovered remain as null.
    public Dinosaur(String name) {
        this.nameOfDinosaur = name;
        description = "No Description inputted";
        size = 0;
        diet = "No Diet inputted";
        location = "No Location of Discovery inputted";
        era = "No Mesozoic Era inputted";
    }

    // REQUIRES: The string must not be empty.
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
    public void addDiet(String typeOfDiet) {
        this.diet = typeOfDiet;
    }

    // REQUIRES: The string must not be empty.
    // MODIFIES: this
    // EFFECTS: Adds the period of mesozoic era this dinosaur lived in.
    public void addEra(String era) {
        this.era = era;
    }

    // REQUIRES: The dinosaur must exist in the index before called.
    // EFFECTS: Returns all the information under the designated dinosaur.
    public String returnDinosaurPage() {
        System.out.println("Name:" + nameOfDinosaur);
        System.out.println("Description:" + description);
        System.out.println("Size:" + size);
        System.out.println("Location of Discovery:" + location);
        System.out.println("Diet:" + diet);
        System.out.println("Mesozoic Period: " + era);
        return nameOfDinosaur;
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

    //EFFECTS: Returns Dinosaur as a JSON Object
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", nameOfDinosaur);
        json.put("diet", diet);
        json.put("era", era);
        json.put("location", location);
        json.put("size", size);
        json.put("description", description);
        return json;
    }


}
