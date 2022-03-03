package ui;

import model.*;
import persistence.JsonDinoAnalyzer;
import persistence.JsonDinoWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DinoIndex {

    private Dinosaur tyrano;
    private Dinosaur trike;
    private Dinosaur stego;
    private Dinosaur eoraptor;
    private Dinosaur giga;
    private Dinosaur coel;

    private DinosaurList catalogueDinosaur;

    private Dinosaur discoveredDinosaur;
    private Scanner input;

    private static final String JSON_STORE = "./data/dinoIndex.json";
    private JsonDinoWriter jsonDinoWriter;
    private JsonDinoAnalyzer jsonDinoAnalyzer;

    // EFFECTS: Starts up the index
    public DinoIndex() {
        input = new Scanner(System.in);
        catalogueDinosaur = new DinosaurList("Default DinoIndex");
        jsonDinoAnalyzer = new JsonDinoAnalyzer(JSON_STORE);
        jsonDinoWriter = new JsonDinoWriter(JSON_STORE);
        openDinoIndex();
    }

    // MODIFIES: this
    // EFFECTS: Opens up the index and run its function
    public void openDinoIndex() {
        boolean remainOpen = true;
        String press = null;

        makeIndex();

        while (remainOpen) {
            openTableOfContents();
            press = input.next();
            press = press.toLowerCase();

            if (press.equals("c")) {
                remainOpen = false;
            } else {
                selectPage(press);
            }
        }

        System.out.println("\nClosing Prehistoric earth...");

    }

    // MODIFIES: this
    // EFFECTS: Inputs the first set of dinosaurs are present in the index.
    private void makeIndex() {
        makeDinosaur1();
        catalogueDinosaur.addToCatalogueOfDino(tyrano);
        makeDinosaurs2();
        catalogueDinosaur.addToCatalogueOfDino(trike);
        makeDinosaurs3();
        catalogueDinosaur.addToCatalogueOfDino(eoraptor);
        makeDinosaurs4();
        catalogueDinosaur.addToCatalogueOfDino(stego);
        makeDinosaurs5();
        catalogueDinosaur.addToCatalogueOfDino(giga);
        makeDinosaurs6();
        catalogueDinosaur.addToCatalogueOfDino(coel);
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    // MODIFIES: this
    // EFFECTS: Creates the first embedded dinosaur that represent each section of index.
    private void makeDinosaur1() {
        tyrano = new Dinosaur("Tyrannosaurus");
        tyrano.addLocationFound("North America");
        tyrano.addDescription("Tyrant King Lizard");
        tyrano.addSize(12);
        tyrano.addDiet("Carnivore");
        tyrano.addEra("Cretaceous");
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    // MODIFIES: this
    // EFFECTS: Creates the second embedded dinosaur that represent each section of index.
    private void makeDinosaurs2() {
        trike = new Dinosaur("Triceratops");
        trike.addEra("Cretaceous");
        trike.addSize(9);
        trike.addDescription("Three Horned Lizard");
        trike.addLocationFound("North America");
        trike.addDiet("Herbivore");
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    // MODIFIES: this
    // EFFECTS: Creates the third embedded dinosaur that represent each section of index.
    private void makeDinosaurs3() {
        eoraptor = new Dinosaur("Eoraptor");
        eoraptor.addEra("Triassic");
        eoraptor.addSize(3);
        eoraptor.addDescription("First ever raptor to exist on earth.");
        eoraptor.addLocationFound("Asia");
        eoraptor.addDiet("Omnivore");
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    // MODIFIES: this
    // EFFECTS: Creates the fourth embedded dinosaur that represent each section of index.
    private void makeDinosaurs4() {
        stego = new Dinosaur("Stegosaurus");
        stego.addEra("Jurassic");
        stego.addSize(10);
        stego.addDescription("Spiked dinosaur, existed in Jurassic Period");
        stego.addLocationFound("Africa");
        stego.addDiet("Herbivore");
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    // MODIFIES: this
    // EFFECTS: Creates the fifth embedded dinosaur that represent each section of index.
    private void makeDinosaurs5() {
        giga = new Dinosaur("Giganotosaurus");
        giga.addEra("Cretaceous");
        giga.addSize(14);
        giga.addDescription("Biggest type of Tyranosaur");
        giga.addLocationFound("South America");
        giga.addDiet("Carnivore");
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    // MODIFIES: this
    // EFFECTS: Creates the sixth embedded dinosaur that represent each section of index.
    private void makeDinosaurs6() {
        coel = new Dinosaur("Coelophysis");
        coel.addEra("Triassic");
        coel.addSize(2);
        coel.addDescription("The first ever living Dinosaur dated back 1000 million years ago.");
        coel.addLocationFound("Africa // North America");
        coel.addDiet("Omnivore");
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }


    // EFFECTS: Open the table of contents to choose from.
    private void openTableOfContents() {
        System.out.println("\nChoose Option:");
        System.out.println("\nn = Search by Name!");
        System.out.println("\np = Search by Location of Discovery!");
        System.out.println("\ne = Filter By Mesozoic Era!");
        System.out.println("\nf = Filter by Dinosaur's Diet!");
        System.out.println("\nd = Discovered new dinosaur!");
        System.out.println("\nu = Update dinosaur information!");
        System.out.println("\ns = Save Dinosaurs to File!");
        System.out.println("\nl = Load Dinosaurs from File!");
        System.out.println("\nc = Close the Index.");
    }

    // EFFECTS: Selects the designated operation in the index.
    private void selectPage(String input) {
        if (input.equals("n")) {
            searchByName();
        } else if (input.equals("p")) {
            searchByLocation();
        } else if (input.equals("e")) {
            searchByEra();
        } else if (input.equals("f")) {
            searchByDiet();
        } else if (input.equals("d")) {
            discoveredNewDino();
        } else if (input.equals("u")) {
            updateNewDino();
        } else if (input.equals("s")) {
            saveDinoIndex();
        } else if (input.equals("l")) {
            loadDinoIndex();
        } else {
            System.out.println("Invalid input");
        }
    }

    // MODIFIES: this
    // EFFECTS: Searches through the index by the given input name of dinosaur.
    private void searchByName() {
        System.out.println("" + catalogueDinosaur.printDinoNames());
        System.out.println("Enter the name of the dinosaur: ");
        String name = input.next();
        catalogueDinosaur.filterDinoInfo(name);
    }

    // MODIFIES: this
    // EFFECTS: Searchers through the index by the given location of discovery of the dinosaur.
    private void searchByLocation() {
        System.out.println("Enter either 'North America' 'South America' 'Africa' 'Asia' or 'Europe': ");
        String location = input.next();

        List<Dinosaur> withLocation = catalogueDinosaur.filterByLocation(location);

        System.out.println("The Dinosaurs discover in this location are: "
                + catalogueDinosaur.printFilteredNames(withLocation));
    }

    // MODIFIES: this
    // EFFECTS: Searchers through the index by the given mesozoic period that the dinosaur lived in.
    private void searchByEra() {
        System.out.println("Enter either 'Triassic' 'Jurassic' or 'Cretaceous': ");
        String era = input.next();

        List<Dinosaur> withEra = catalogueDinosaur.filterByEra(era);
        System.out.println("The Dinosaurs with this era are: " + catalogueDinosaur.printFilteredNames(withEra));
    }


    // MODIFIES: this
    // EFFECTS: Searchers through the index by the given diet type of the dinosaur.
    private void searchByDiet() {
        System.out.println("Enter either 'Herbivore' 'Carnivore' or 'Omnivore': ");
        String diet = input.next();

        List<Dinosaur> withDiet = catalogueDinosaur.filterByDiet(diet);
        System.out.println("The Dinosaurs with this diet are: " + catalogueDinosaur.printFilteredNames(withDiet));
    }


    // REQUIRES: inputted name cannot be the name of existing dinosaur
    // MODIFIES: this
    // EFFECTS: Crates the newly discovered Dinosaur and gives it a name.
    private void discoveredNewDino() {
        System.out.println("Enter the name of the newly discovered Dinosaur: ");
        String name = input.next();
        discoveredDinosaur = new Dinosaur(name);
        catalogueDinosaur.addToCatalogueOfDino(discoveredDinosaur);
        System.out.println("Description, Size, Location of Discovery, Diet, Mesozoic Period:");
        System.out.println("What information would you like to add?");
        String information = input.next();
        if (information.equals("Size")) {
            updateSize(discoveredDinosaur);
        } else if (information.equals("Description")) {
            updateDescription(discoveredDinosaur);
        } else if (information.equals("Diet")) {
            updateDiet(discoveredDinosaur);
        } else if (information.equals("Location of Discovery")) {
            updateLocation(discoveredDinosaur);
        } else if (information.equals("Mesozoic Period")) {
            updatePeriod(discoveredDinosaur);
        } else {
            System.out.println("Invalid Input...");
        }
    }

    // REQUIRES: inputted name has to be the name of existing dinosaur
    // MODIFIES: this
    // EFFECTS: Selects the existing discovered Dinosaur with the information the user wants to add.
    // (E.g.: Size, Diet, Location of Discovery and etc...)
    private void updateNewDino() {
        System.out.println("Enter the name of the existing discovered Dinosaur: ");
        String name = input.next();
        for (Dinosaur d : catalogueDinosaur.returnCatalogueOfDinosaur()) {
            if (name.equals(d.getName())) {
                System.out.println("Description, Size, Location of Discovery, Diet, Mesozoic Period:");
                System.out.println("What information would you like to add?");
                String information = input.next();
                if (information.equals("Size")) {
                    updateSize(d);
                } else if (information.equals("Description")) {
                    updateDescription(d);
                } else if (information.equals("Diet")) {
                    updateDiet(d);
                } else if (information.equals("Location of Discovery")) {
                    updateLocation(d);
                } else if (information.equals("Mesozoic Period")) {
                    updatePeriod(d);
                } else {
                    System.out.println("Invalid Input...");
                }
            }
        }
        //TODO System.out.println("No existing Dinosaur...");
    }

    // MODIFIES: this
    // EFFECTS: Updates the existing Dinosaur's size with the inputted size.
    private void updateSize(Dinosaur d) {
        System.out.println("What was the size of the Dinosaur?");
        Integer size = input.nextInt();
        d.addSize(size);
        System.out.println("Successfully added size!");
    }

    // MODIFIES: this
    // EFFECTS: Updates the existing Dinosaur's description with the inputted description.
    private void updateDescription(Dinosaur d) {
        System.out.println("What is the description of the Dinosaur?");
        String description = input.next();
        d.addDescription(description);
        System.out.println("Successfully added description!");
    }

    // MODIFIES: this
    // EFFECTS: Updates the existing Dinosaur's diet with the inputted type of diet.
    private void updateDiet(Dinosaur d) {
        System.out.println("Was the dinosaur Carnivore, Herbivore or Omnivore?");
        String diet = input.next();
        if (diet.equals("Carnivore")) {
            d.addDiet("Carnivore");
            System.out.println("Successfully added diet!");
        } else if (diet.equals("Herbivore")) {
            d.addDiet("Herbivore");
            System.out.println("Successfully added diet!");
        } else if (diet.equals("Omnivore")) {
            d.addDiet("Omnivore");
            System.out.println("Successfully added diet!");
        } else {
            System.out.println("Invalid Diet...");
        }
    }

    // MODIFIES: this
    // EFFECTS: Updates the existing Dinosaur's location with the inputted location.
    private void updateLocation(Dinosaur d) {
        System.out.println("Where was this dinosaur's fossil discovered?");
        String location = input.next();
        if (location.equals("North America")) {
            d.addLocationFound("North America");
            System.out.println("Successfully added location!");
        } else if (location.equals("Asia")) {
            d.addLocationFound("Asia");
            System.out.println("Successfully added location!");
        } else if (location.equals("Africa")) {
            d.addLocationFound("Africa");
            System.out.println("Successfully added location!");
        } else if (location.equals("Europe")) {
            d.addLocationFound("Europe");
            System.out.println("Successfully added location!");
        } else {
            System.out.println("Invalid Input...");
        }
    }

    // MODIFIES: this
    // EFFECTS: Updates the existing Dinosaur's Mesozoic Era with the inputted era.
    private void updatePeriod(Dinosaur d) {
        System.out.println("Did the dinosaur live in: Triassic, Jurassic or Cretaceous?");
        String era = input.next();
        if (era.equals("Triassic")) {
            d.addEra("Triassic");
            System.out.println("Successfully added Mesozoic Era!");
        } else if (era.equals("Jurassic")) {
            d.addEra("Jurassic");
            System.out.println("Successfully added Mesozoic Era!");
        } else if (era.equals("Cretaceous")) {
            d.addEra("Cretaceous");
            System.out.println("Successfully added Mesozoic Era!");
        } else {
            System.out.println("Invalid Input...");
        }
    }

    // EFFECTS: saves the DinoIndex to file
    private void saveDinoIndex() {
        try {
            jsonDinoWriter.open();
            jsonDinoWriter.write(catalogueDinosaur);
            jsonDinoWriter.close();
            System.out.println("Saved " + catalogueDinosaur.getName() + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads DinoIndex from file
    private void loadDinoIndex() {
        try {
            catalogueDinosaur = jsonDinoAnalyzer.analyze();
            System.out.println("Loaded " + catalogueDinosaur.getName() + " from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }


}
