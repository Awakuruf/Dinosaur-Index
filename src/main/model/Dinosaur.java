package model;

import org.json.JSONObject;
import persistence.Writable;

import javax.swing.*;
import java.awt.*;

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
    private ImageIcon image;
    private String imageDirectory;


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
        imageDirectory = "./images/unknown dino.jpg";
        image = new ImageIcon(imageDirectory);
        Image tempImage = image.getImage();
        Image newImage = tempImage.getScaledInstance(125, 125, java.awt.Image.SCALE_SMOOTH);
        image = new ImageIcon(newImage);
        EventLog.getInstance().logEvent(new Event("New Dinosaur discovered: " + this.getName() + "!"));
    }

    // REQUIRES: The string must not be empty.
    // MODIFIES: this
    // EFFECTS: Adds the description of the dinosaur such as its trait and behaviour.
    public void addDescription(String description) {
        this.description = description;
        EventLog.getInstance().logEvent(new Event("Added description to " + this.getName()));
    }

    // REQUIRES: The string must not be empty.
    // MODIFIES: this
    // EFFECTS: Add the location of where the fossil was found.
    public void addLocationFound(String location) {
        this.location = location;
        EventLog.getInstance().logEvent(new Event(
                "Added " + location + " to location of discovery for " + this.getName()));
    }

    // REQUIRES: The length must be > 0.
    // MODIFIES: this
    // EFFECTS: Adds the size of the dinosaur in meters.
    public void addSize(Integer length) {
        this.size = length;
        EventLog.getInstance().logEvent(new Event(
                "Added " + length + "m as a size for " + this.getName()));
    }


    // REQUIRES: The string must not be empty.
    // MODIFIES: this
    // EFFECTS: Add what kind of diet the dinosaur had
    public void addDiet(String typeOfDiet) {
        this.diet = typeOfDiet;
        EventLog.getInstance().logEvent(new Event("Added " + typeOfDiet + " as a type of diet for " + this.getName()));
    }

    // REQUIRES: The string must not be empty.
    // MODIFIES: this
    // EFFECTS: Adds the period of mesozoic era this dinosaur lived in.
    public void addEra(String era) {
        this.era = era;
        EventLog.getInstance().logEvent(new Event(
                "Added " + era + " as the Mesozoic Era " + this.getName() + " lived in"));
    }

    // REQUIRES: The string must not be empty.
    // MODIFIES: this
    // EFFECTS: Add the image directory of the dinosaur.
    public void addImage(String imageLink) {
        this.image = new ImageIcon(imageLink);
        EventLog.getInstance().logEvent(new Event("Added Image Link to " + this.getName()));
    }

    // REQUIRES: The string must not be empty.
    // MODIFIES: this
    // EFFECTS: Add the image of the dinosaur.
    public void pasteImage(ImageIcon image) {
        this.image = image;
        EventLog.getInstance().logEvent(new Event("Viewed the Dino Page of: " + this.getName()));
    }

    // REQUIRES: The string must not be empty.
    // MODIFIES: this
    // EFFECTS: Add the image directory to this dinosaur's image.
    public void addImageDirectory(String directory) {
        this.imageDirectory = directory;
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
        EventLog.getInstance().logEvent(new Event("Returned DinoIndex Page for: " + this.getName()));
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

    //EFFECT: Getter for Image
    public ImageIcon getImage() {
        return image;
    }

    //EFFECT: Getter for Image Directory.
    public String getImageDirectory() {
        return imageDirectory;
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
        json.put("image", imageDirectory);
        return json;
    }


}
