package ui;

import model.*;

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

    // EFFECTS: Starts up the index
    public DinoIndex() {
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
    // EFFECTS: Creates the first set of dinosaurs are present in the index.
    private void makeIndex() {
        catalogueDinosaur = new DinosaurList();
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
    // EFFECTS: Creates the first origin dinosaur that represent each section of index.
    private void makeDinosaur1() {
        tyrano = new Dinosaur("Tyrannosaurus");
        tyrano.addLocationFound("North America");
        tyrano.addDescription("Tyrant King Lizard");
        tyrano.addSize(12);
        tyrano.addDiet("Carnivore");
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    // MODIFIES: this
    // EFFECTS: Creates the secound origin dinosaur that represent each section of index.
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
    // EFFECTS: Creates the third origin dinosaur that represent each section of index.
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
    // EFFECTS: Creates the fourth origin dinosaur that represent each section of index.
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
    // EFFECTS: Creates the fifth origin dinosaur that represent each section of index.
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
    // EFFECTS: Creates the sixth origin dinosaur that represent each section of index.
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
        System.out.println("\nl = Search by Location of Discovery!");
        System.out.println("\ne = Filter By Mesozoic Era!");
        System.out.println("\nf = Filter by Dinosaur's Diet!");
        System.out.println("\nt = Filter by Dinosaur's Phylogenetic Tree [COMING SOON!!!]");
        System.out.println("\nd = Discovered new dinosaur!");
        System.out.println("\nu = Update dinosaur information!");
        System.out.println("\nc = Close the Index.");
    }

    // MODIFIES: this
    // EFFECTS: Selects the designated page in the index.
    private void selectPage(String input) {
        if (input.equals("n")) {
            searchByName();
        } else if (input.equals("l")) {
            searchByLocation();
        } else if (input.equals("e")) {
            searchByEra();
        } else if (input.equals("f")) {
            searchByDiet();
        } else if (input.equals("d")) {
            discoveredNewDino();
        } else if (input.equals("u")) {
            updateNewDino();
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
            updateSize();
        } else if (information.equals("Description")) {
            updateDescription();
        } else if (information.equals("Diet")) {
            updateDiet();
        } else if (information.equals("Location of Discovery")) {
            updateLocation();
        } else if (information.equals("Mesozoic Period")) {
            updatePeriod();
        } else {
            System.out.println("Invalid Input...");
        }
    }

    // REQUIRES: inputted name has to be the name of existing dinosaur
    // MODIFIES: this
    // EFFECTS: Updates the existing discovered Dinosaur with information.
    // (E.g.: Size, Diet, Location of Discovery and etc...)
    private void updateNewDino() {
        System.out.println("Enter the name of the existing discovered Dinosaur: ");
        String name = input.next();
        if (name.equals(discoveredDinosaur.getName())) {
            System.out.println("Description, Size, Location of Discovery, Diet, Mesozoic Period:");
            System.out.println("What information would you like to add?");
            String information = input.next();
            if (information.equals("Size")) {
                updateSize();
            } else if (information.equals("Description")) {
                updateDescription();
            } else if (information.equals("Diet")) {
                updateDiet();
            } else if (information.equals("Location of Discovery")) {
                updateLocation();
            } else if (information.equals("Mesozoic Period")) {
                updatePeriod();
            } else {
                System.out.println("Invalid Input...");
            }
        } else {
            System.out.println("No existing Dinosaur...");
        }
    }


    private void updateSize() {
        System.out.println("What was the size of the Dinosaur?");
        Integer size = input.nextInt();
        discoveredDinosaur.addSize(size);
        System.out.println("Successfully added size!");
    }

    private void updateDescription() {
        System.out.println("What is the description of the Dinosaur?");
        String description = input.next();
        discoveredDinosaur.addDescription(description);
        System.out.println("Successfully added description!");
    }

    private void updateDiet() {
        System.out.println("Was the dinosaur Carnivore, Herbivore or Omnivore?");
        String diet = input.next();
        if (diet.equals("Carnivore")) {
            discoveredDinosaur.addDiet("Carnivore");
            System.out.println("Successfully added diet!");
        } else if (diet.equals("Herbivore")) {
            discoveredDinosaur.addDiet("Herbivore");
            System.out.println("Successfully added diet!");
        } else if (diet.equals("Omnivore")) {
            discoveredDinosaur.addDiet("Omnivore");
            System.out.println("Successfully added diet!");
        } else {
            System.out.println("Invalid Diet...");
        }
    }

    private void updateLocation() {
        System.out.println("Where was this dinosaur's fossil discovered?");
        String location = input.next();
        if (location.equals("North America")) {
            discoveredDinosaur.addLocationFound("North America");
            System.out.println("Successfully added location!");
        } else if (location.equals("Asia")) {
            discoveredDinosaur.addLocationFound("Asia");
            System.out.println("Successfully added location!");
        } else if (location.equals("Africa")) {
            discoveredDinosaur.addLocationFound("Africa");
            System.out.println("Successfully added location!");
        } else if (location.equals("Europe")) {
            discoveredDinosaur.addLocationFound("Europe");
            System.out.println("Successfully added location!");
        } else {
            System.out.println("Invalid Input...");
        }
    }

    private void updatePeriod() {
        System.out.println("Did the dinosaur live in: Triassic, Jurassic or Cretaceous?");
        String era = input.next();
        if (era.equals("Triassic")) {
            discoveredDinosaur.addEra("Triassic");
            System.out.println("Successfully added Mesozoic Era!");
        } else if (era.equals("Jurassic")) {
            discoveredDinosaur.addEra("Jurassic");
            System.out.println("Successfully added Mesozoic Era!");
        } else if (era.equals("Cretaceous")) {
            discoveredDinosaur.addEra("Cretaceous");
            System.out.println("Successfully added Mesozoic Era!");
        } else {
            System.out.println("Invalid Input...");
        }
    }


}
