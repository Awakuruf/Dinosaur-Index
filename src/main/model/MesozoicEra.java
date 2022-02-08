package model;

import java.util.ArrayList;
import java.util.List;

public class MesozoicEra {
    //This shows the list of countries of where the dinosaur fossil was discovered in!

    //fields
    private List<Dinosaur> triassic;
    private List<Dinosaur> jurassic;
    private List<Dinosaur> cretaceous;

    // REQUIRES: The string must not be empty.
    // EFFECTS: Constructs the period of Mesozoic Era
    public MesozoicEra() {
        triassic = new ArrayList<>();
        jurassic = new ArrayList<>();
        cretaceous = new ArrayList<>();
    }

    // REQUIRES: The string must not be empty.
    // MODIFIES: this
    // EFFECTS: Add the parameter dino to the given period of Mesozoic Era.
    public void addToEraGroup(Dinosaur dinosaur, String era) {
        if (era.equals("Triassic")) {
            triassic.add(dinosaur);
        } else if (era.equals("Jurassic")) {
            jurassic.add(dinosaur);
        } else if (era.equals("Cretaceous")) {
            cretaceous.add(dinosaur);
        } else {
            System.out.println("Invalid Diet Type...");
        }
    }

    public List<Dinosaur> returnMesozoicEra(String era) {
        if (era.equals("Triassic")) {
            System.out.println("List of Triassic Dinosaurs: " + printDinoNames(triassic));
            return triassic;
        } else if (era.equals("Jurassic")) {
            System.out.println("List of Cretaceous Dinosaurs: " + printDinoNames(jurassic));
            return jurassic;
        } else if (era.equals("Cretaceous")) {
            System.out.println("List of Cretaceous Dinosaurs: " + printDinoNames(cretaceous));
            return cretaceous;
        } else {
            System.out.println("Invalid Diet Type...");
            return null;
        }
    }

    public List<String> printDinoNames(List<Dinosaur> era) {
        List<String> nameOfDinos = new ArrayList<>();
        for (Dinosaur d: era) {
            nameOfDinos.add(d.getName());
        }
        return nameOfDinos;
    }




}

