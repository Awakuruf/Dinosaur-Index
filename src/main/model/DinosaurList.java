package model;

import java.util.ArrayList;
import java.util.List;

public class DinosaurList {
    //This shows the list of countries of where the dinosaur fossil was discovered in!

    //fields
    private List<Dinosaur> listOfDino;


    // REQUIRES: The string must not be empty.
    // EFFECTS: Constructs an empty list that represents the catalogue of dinosaurs.
    public DinosaurList() {
        listOfDino = new ArrayList<>();
    }

    // REQUIRES: The inputted dinosaur cannot be null.
    // MODIFIES: this
    // EFFECTS: Adds the inputted dinosaur to the catalogue of dinosaurs.
    public void addToCatalogueOfDino(Dinosaur dinosaur) {
        listOfDino.add(dinosaur);
    }

    // REQUIRES: The string must not be empty.
    // MODIFIES: this
    // EFFECTS: Returns a list containing dinosaurs that have the inputted diet.
    public List<Dinosaur> filterByDiet(String diet) {
        ArrayList<Dinosaur> withDiet = new ArrayList<>();
        for (Dinosaur d : listOfDino) {
            if (d.getDiet() != null) {
                if (d.getDiet().equals(diet)) {
                    withDiet.add(d);
                }
            }
        }
        return withDiet;
    }

    // REQUIRES: The string must not be empty.
    // MODIFIES: this
    // EFFECTS: Returns a list containing dinosaurs that have the inputted Mesozoic Period.
    public List<Dinosaur> filterByEra(String mesozoicPeriod) {
        ArrayList<Dinosaur> withEra = new ArrayList<>();
        for (Dinosaur d : listOfDino) {
            if (d.getEra() != null) {
                if (d.getEra().equals(mesozoicPeriod)) {
                    withEra.add(d);
                }
            }
        }
        return withEra;
    }

    // REQUIRES: The string must not be empty.
    // MODIFIES: this
    // EFFECTS: Returns a list containing dinosaurs that have the inputted Location of Discovery.
    public List<Dinosaur> filterByLocation(String location) {
        ArrayList<Dinosaur> withLocation = new ArrayList<>();
        for (Dinosaur d : listOfDino) {
            if (d.getLocation() != null) {
                if (d.getLocation().equals(location)) {
                    withLocation.add(d);
                }
            }
        }
        return withLocation;
    }

    // REQUIRES: listOfDino cannot be an empty set of list.
    // MODIFIES: this
    // EFFECTS: Returns a list of names of the dinosaurs in the catalogue of dinosaurs.
    public List<String> printDinoNames() {
        List<String> nameOfDino = new ArrayList<>();
        for (Dinosaur d : listOfDino) {
            nameOfDino.add(d.getName());
        }
        return nameOfDino;
    }

    // REQUIRES: The parameter "list" cannot be an empty list.
    // MODIFIES: this
    // EFFECTS: Returns a list containing the name of the dinosaurs that
    // were filtered.
    public List<String> printFilteredNames(List<Dinosaur> list) {
        List<String> namesOfDino = new ArrayList<>();
        for (Dinosaur d : list) {
            namesOfDino.add(d.getName());
        }
        return namesOfDino;
    }

    // REQUIRES: The parameter "dinoName" cannot be an empty string.
    // MODIFIES: this
    // EFFECTS: Returns the Dinosaur Page of the given dinosaur in the list.
    public String filterDinoInfo(String dinoName) {
        for (Dinosaur d : listOfDino) {
            if (d.getName().equals(dinoName)) {
                return d.returnDinosaurPage();
            }
        }
        return null;
    }

    // Getter for the DinosaurList.
    public List<Dinosaur> returnCatalogueOfDinosaur() {
        return listOfDino;
    }
}
