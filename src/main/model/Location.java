package model;

import java.util.ArrayList;
import java.util.List;

public class Location {
    //This shows the list of countries of where the dinosaur fossil was discovered in!

    //fields
    private List<Dinosaur> northAmerica;
    private List<Dinosaur> africa;
    private List<Dinosaur> asia;
    private List<Dinosaur> europe;
    private List<Dinosaur> southAmerica;
    private List<Dinosaur> australia;

    // REQUIRES: The string must not be empty.
    // EFFECTS: Constructs the period of Mesozoic Era
    public Location() {
        northAmerica = new ArrayList<>();
        asia = new ArrayList<>();
        africa = new ArrayList<>();
        europe = new ArrayList<>();
        southAmerica = new ArrayList<>();
        australia = new ArrayList<>();
    }

    // REQUIRES: The string must not be empty.
    // MODIFIES: this
    // EFFECTS: Add the parameter dino to the given period of Mesozoic Era.
    public void addToLocationGroup(Dinosaur dinosaur, String location) {
        if (location.equals("North America")) {
            northAmerica.add(dinosaur);
        } else if (location.equals("Australia")) {
            australia.add(dinosaur);
        } else if (location.equals("Europe")) {
            europe.add(dinosaur);
        } else if (location.equals("Asia")) {
            asia.add(dinosaur);
        } else if (location.equals("Africa")) {
            africa.add(dinosaur);
        } else if (location.equals("South America")) {
            southAmerica.add(dinosaur);
        } else {
            System.out.println("Invalid Diet Type...");
        }
    }

    public List<Dinosaur> returnLocationOfDiscovery(String location) {
        if (location.equals("North America")) {
            System.out.println("ist of Dinosaurs discovered in North America: " + printDinoNames(northAmerica));
            return northAmerica;
        } else if (location.equals("South America")) {
            System.out.println("List of Dinosaurs discovered in South America: " + printDinoNames(southAmerica));
            return southAmerica;
        } else if (location.equals("Asia")) {
            System.out.println("List of Dinosaurs discovered in Asia: " + printDinoNames(asia));
            return asia;
        } else if (location.equals("Africa")) {
            System.out.println("ist of Dinosaurs discovered in Africa: " + printDinoNames(africa));
            return africa;
        } else if (location.equals("Australia")) {
            System.out.println("List of Dinosaurs discovered in Australia: " + printDinoNames(australia));
            return australia;
        } else if (location.equals("Europe")) {
            System.out.println("List of Dinosaurs discovered in Europe: " + printDinoNames(europe));
            return europe;
        } else {
            System.out.println("Invalid Location of Discovery...");
            return null;
        }
    }

    public List<String> printDinoNames(List<Dinosaur> location) {
        List<String> nameOfDinos = new ArrayList<>();
        for (Dinosaur d: location) {
            nameOfDinos.add(d.getName());
        }
        return nameOfDinos;
    }
}
