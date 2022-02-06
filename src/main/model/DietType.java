package model;

import java.util.ArrayList;
import java.util.List;

public class DietType {
    //This shows the list of countries of where the dinosaur fossil was discovered in!

    //fields
    private List<Dinosaur> carnivore;
    private List<Dinosaur> herbivore;
    private List<Dinosaur> omnivore;

    // REQUIRES: The string must not be empty.
    // EFFECTS: Constructs the diet category of dinosaurs
    public DietType() {
        carnivore = new ArrayList<>();
        herbivore = new ArrayList<>();
        omnivore = new ArrayList<>();
    }

    // REQUIRES: The string must not be empty and this nameOfDino cannot be the name of origin dinosaur.
    // MODIFIES: this
    // EFFECTS: Add the parameter dino to the given group of diet.
    public void addToDietGroup(Dinosaur nameOfDino, String diet) {
        if (diet.equals("Carnivore")) {
            carnivore.add(nameOfDino);
        } else if (diet.equals("Herbivore")) {
            herbivore.add(nameOfDino);
        } else if (diet.equals("Omnivore")) {
            omnivore.add(nameOfDino);
        } else {
            System.out.println("Invalid Diet Type...");
        }
    }

    //Getter for Diet
    public List<Dinosaur> returnDiet(String dietType) {
        if (dietType.equals("Carnivore")) {
            System.out.println("List of Dinosaurs that are Carnivores: " + carnivore);
            return carnivore;
        } else if (dietType.equals("Herbivore")) {
            System.out.println("List of Dinosaurs that are Herbivores: " + herbivore);
            return herbivore;
        } else if (dietType.equals("Omnivore")) {
            System.out.println("List of Dinosaurs that are Omnivores: " + omnivore);
            return omnivore;
        } else {
            System.out.println("Invalid Diet Type...");
            return null;
        }
    }

     /* // REQUIRES: The string must not be empty and the dinosaur must be the origin dinosaur.
    // EFFECTS: Filters and returns all the dinosaurs in the index to
    // those that originate from the input dinosaur.
    public List<Dinosaur> filterByLocation(Location nameOfLocation) {
        return null; //STUB
    } */
}
