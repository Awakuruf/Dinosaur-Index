package ui;

import model.*;

import java.util.Scanner;

public class DinoIndex {
    private MesozoicEra triassic;
    private MesozoicEra jurassic;
    private MesozoicEra cretaceous;
    private DietType carnivore;
    private DietType herbivore;
    private DietType omnivore;
    private Location northAmerica;
    private Location southAmerica;
    private Location europe;
    private Location asia;
    private Location africa;
    private Dinosaur tyrano;
    private Dinosaur trike;
    private Dinosaur stego;
    private Dinosaur eoraptor;
    private Dinosaur giga;
    private Dinosaur coel;
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

        makeDinosaur1();
        makeDinosaurs2();
        makeDinosaurs3();
        makeDinosaurs4();
        makeDinosaurs5();
        makeDinosaurs6();

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
    // EFFECTS: Creates the first origin dinosaur that represent each section of index.
    private void makeDinosaur1() {
        tyrano = new Dinosaur("Tyrannosaurus");
        northAmerica = new Location();
        carnivore = new DietType();
        cretaceous = new MesozoicEra();
        tyrano.addLocationFound("North America");
        tyrano.addDescription("Tyrant King Lizard");
        tyrano.addSize(12);
        tyrano.addDiet("Carnivore");
        cretaceous.addToEraGroup(tyrano, "Cretaceous");
        carnivore.addToDietGroup(tyrano, "Carnivore");
        northAmerica.addToLocationGroup(tyrano, "North America");
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
        herbivore = new DietType();
        trike.addDiet("Herbivore");
        cretaceous.addToEraGroup(trike, "Jurassic");
        herbivore.addToDietGroup(trike, "Herbivore");
        northAmerica.addToLocationGroup(trike, "North America");
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    // MODIFIES: this
    // EFFECTS: Creates the third origin dinosaur that represent each section of index.
    private void makeDinosaurs3() {
        eoraptor = new Dinosaur("Eoraptor");
        eoraptor.addEra("Triassic");
        triassic = new MesozoicEra();
        omnivore = new DietType();
        asia = new Location();
        eoraptor.addSize(3);
        eoraptor.addDescription("First ever raptor to exist on earth.");
        eoraptor.addLocationFound("Asia");
        eoraptor.addDiet("Omnivore");
        triassic.addToEraGroup(eoraptor, "Triassic");
        omnivore.addToDietGroup(eoraptor, "Omnivore");
        asia.addToLocationGroup(eoraptor, "Asia");
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    // MODIFIES: this
    // EFFECTS: Creates the fourth origin dinosaur that represent each section of index.
    private void makeDinosaurs4() {
        stego = new Dinosaur("Stegosaurus");
        africa = new Location();
        stego.addEra("Jurassic");
        jurassic = new MesozoicEra();
        stego.addSize(10);
        stego.addDescription("Spiked dinosaur, existed in Jurassic Period");
        stego.addLocationFound("Africa");
        stego.addDiet("Herbivore");
        jurassic.addToEraGroup(stego, "Jurassic");
        herbivore.addToDietGroup(stego, "Herbivore");
        africa.addToLocationGroup(stego, "Africa");
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    // MODIFIES: this
    // EFFECTS: Creates the fifth origin dinosaur that represent each section of index.
    private void makeDinosaurs5() {
        giga = new Dinosaur("Giganotosaurus");
        southAmerica = new Location();
        giga.addEra("Cretaceous");
        giga.addSize(14);
        giga.addDescription("Biggest type of Tyranosaur");
        giga.addLocationFound("South America");
        giga.addDiet("Carnivore");
        cretaceous.addToEraGroup(giga, "Jurassic");
        carnivore.addToDietGroup(giga, "Carnivore");
        southAmerica.addToLocationGroup(giga, "South America");
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
        triassic.addToEraGroup(coel, "Triassic");
        omnivore.addToDietGroup(coel, "Omnivore");
        africa.addToLocationGroup(coel, "Africa");
        northAmerica.addToLocationGroup(coel, "North America");
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
            filterByEra();
        } else if (input.equals("f")) {
            filterByDiet();
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
        System.out.println("Tyrannosaurus, Triceratops, Stegosaurus, Coelophysis, Giganotosaurus");
        if (!(discoveredDinosaur == null)) {
            System.out.println(discoveredDinosaur.getName());
            //TODO Make sure it prints out EVERY added dinosaur.
        } else {
            System.out.println("No new dinosaur!");
        }
        System.out.println("Enter the name of the dinosaur: ");
        String name = input.next();

        if ((tyrano.getName()).equals(name)) {
            tyrano.returnDinosaurPage();
        } else if ((trike.getName()).equals(name)) {
            trike.returnDinosaurPage();
        } else if ((stego.getName()).equals(name)) {
            stego.returnDinosaurPage();
        } else if ((giga.getName()).equals(name)) {
            giga.returnDinosaurPage();
        } else if ((coel.getName()).equals(name)) {
            coel.returnDinosaurPage();
        } else if ((discoveredDinosaur.getName()).equals(name)) {
            discoveredDinosaur.returnDinosaurPage();
        } else {
            System.out.println("Dinosaur entry couldn't be found...");
        }
    }

    // MODIFIES: this
    // EFFECTS: Searchers through the index by the given location of discovery.
    private void searchByLocation() {
        System.out.println("North America");
        System.out.println("South America");
        System.out.println("Asia");
        System.out.println("Europe");
        System.out.println("Africa");
        System.out.println("Enter the location of the fossil discovery!: ");
        String location = input.next();

        if (location.equals("North America")) {
            this.northAmerica.returnLocationOfDiscovery("North America");
        } else if (location.equals("South America")) {
            southAmerica.returnLocationOfDiscovery("South America");
        } else if (location.equals("Africa")) {
            africa.returnLocationOfDiscovery("Africa");
        } else if (location.equals("Asia")) {
            asia.returnLocationOfDiscovery("Asia");
        } else if (location.equals("Europe")) {
            europe.returnLocationOfDiscovery("Europe");
        } else {
            System.out.println("Location couldn't be found...");
        }
    }

    // MODIFIES: this
    // EFFECTS: Searchers through the index by the given period of Mesozoic Era that dinosaur lived in.
    private void filterByEra() {
        System.out.println("Enter either 'Triassic' 'Jurassic' or 'Cretaceous': ");
        String era = input.next();

        if (era.equals("Triassic")) {
            this.triassic.returnMesozoicEra("Triassic");
        } else if (era.equals("Jurassic")) {
            jurassic.returnMesozoicEra("Jurassic");
        } else if (era.equals("Cretaceous")) {
            cretaceous.returnMesozoicEra("Cretaceous");
        } else {
            System.out.println("Mesozoic Era couldn't be found...");
        }
    }


    // MODIFIES: this
    // EFFECTS: Searchers through the index by the given diet type of the dinosaur.
    private void filterByDiet() {
        System.out.println("Enter either 'Herbivore' 'Carnivore' or 'Omnivore': ");
        String diet = input.next();

        if (diet.equals("Herbivore")) {
            this.herbivore.returnDiet("Herbivore");
        } else if (diet.equals("Carnivore")) {
            carnivore.returnDiet("Carnivore");
        } else if (diet.equals("Omnivore")) {
            omnivore.returnDiet("Omnivore");
        } else {
            System.out.println("Mesozoic Era couldn't be found...");
        }
    }


    // REQUIRES: inputted name cannot be the name of existing dinosaur
    // MODIFIES: this
    // EFFECTS: Crates the newly discovered Dinosaur and gives it a name.
    private void discoveredNewDino() {
        System.out.println("Enter the name of the newly discovered Dinosaur: ");
        String name = input.next();
        discoveredDinosaur = new Dinosaur(name);
        //TODO Why is this replacing the previous inputted Dinosaur?
        System.out.println("Description, Size, Location of Discovery, Diet, Mesozoic Period:");
        System.out.println("What information would you like to add?");
        String information = input.next();
        if (information.equals("Size")) {
            addSizeToNewDino();
        } else if (information.equals("Description")) {
            addDescriptionToNewDino();
        } else if (information.equals("Diet")) {
            addDietToNewDino();
        } else if (information.equals("Location of Discovery")) {
            addLocationToNewDino();
        } else if (information.equals("Mesozoic Period")) {
            addEraToNewDino();
        } else {
            System.out.println("Invalid Input...");
        }
    }

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

    private void addSizeToNewDino() {
        System.out.println("What was the size of the Dinosaur?");
        Integer size = input.nextInt();
        discoveredDinosaur.addSize(size);
        System.out.println("Successfully added size!");
    }

    private void updateSize() {
        System.out.println("What was the size of the Dinosaur?");
        Integer size = input.nextInt();
        discoveredDinosaur.addSize(size);
        System.out.println("Successfully added size!");
    }

    private void addDescriptionToNewDino() {
        System.out.println("What is the description of the Dinosaur?");
        String description = input.next();
        discoveredDinosaur.addDescription(description);
        System.out.println("Successfully added description!");
    }

    private void updateDescription() {
        System.out.println("What is the description of the Dinosaur?");
        String description = input.next();
        discoveredDinosaur.addDescription(description);
        System.out.println("Successfully added description!");
    }

    private void addDietToNewDino() {
        System.out.println("Was the dinosaur Carnivore, Herbivore or Omnivore?");
        String diet = input.next();
        if (diet.equals("Carnivore")) {
            discoveredDinosaur.addDiet("Carnivore");
            carnivore.addToDietGroup(discoveredDinosaur, "Carnivore");
            System.out.println("Successfully added diet!");
        } else if (diet.equals("Herbivore")) {
            herbivore.addToDietGroup(discoveredDinosaur, "Herbivore");
            discoveredDinosaur.addDiet("Herbivore");
            System.out.println("Successfully added diet!");
        } else if (diet.equals("Omnivore")) {
            omnivore.addToDietGroup(discoveredDinosaur, "Omnivore");
            discoveredDinosaur.addDiet("Omnivore");
            System.out.println("Successfully added diet!");
        } else {
            System.out.println("Invalid Diet...");
        }
    }

    private void updateDiet() {
        System.out.println("Was the dinosaur Carnivore, Herbivore or Omnivore?");
        String diet = input.next();
        if (diet.equals("Carnivore")) {
            discoveredDinosaur.addDiet("Carnivore");
            carnivore.addToDietGroup(discoveredDinosaur, "Carnivore");
            System.out.println("Successfully added diet!");
        } else if (diet.equals("Herbivore")) {
            herbivore.addToDietGroup(discoveredDinosaur, "Herbivore");
            discoveredDinosaur.addDiet("Herbivore");
            System.out.println("Successfully added diet!");
        } else if (diet.equals("Omnivore")) {
            omnivore.addToDietGroup(discoveredDinosaur, "Omnivore");
            discoveredDinosaur.addDiet("Omnivore");
            System.out.println("Successfully added diet!");
        } else {
            System.out.println("Invalid Diet...");
        }
    }

    private void addLocationToNewDino() {
        System.out.println("Where was this dinosaur's fossil discovered?");
        String location = input.next();
        if (location.equals("North America")) {
            northAmerica.addToLocationGroup(discoveredDinosaur, "North America");
            discoveredDinosaur.addLocationFound("North America");
            System.out.println("Successfully added location!");
        } else if (location.equals("Asia")) {
            asia.addToLocationGroup(discoveredDinosaur, "Asia");
            discoveredDinosaur.addLocationFound("Asia");
            System.out.println("Successfully added location!");
        } else if (location.equals("Africa")) {
            africa.addToLocationGroup(discoveredDinosaur, "Africa");
            discoveredDinosaur.addLocationFound("Africa");
            System.out.println("Successfully added location!");
        } else if (location.equals("Europe")) {
            europe.addToLocationGroup(discoveredDinosaur, "Europe");
            discoveredDinosaur.addLocationFound("Europe");
            System.out.println("Successfully added location!");
        } else {
            System.out.println("Invalid Input...");
        }
    }

    private void updateLocation() {
        System.out.println("Where was this dinosaur's fossil discovered?");
        String location = input.next();
        if (location.equals("North America")) {
            northAmerica.addToLocationGroup(discoveredDinosaur, "North America");
            discoveredDinosaur.addLocationFound("North America");
            System.out.println("Successfully added location!");
        } else if (location.equals("Asia")) {
            asia.addToLocationGroup(discoveredDinosaur, "Asia");
            discoveredDinosaur.addLocationFound("Asia");
            System.out.println("Successfully added location!");
        } else if (location.equals("Africa")) {
            africa.addToLocationGroup(discoveredDinosaur, "Africa");
            discoveredDinosaur.addLocationFound("Africa");
            System.out.println("Successfully added location!");
        } else if (location.equals("Europe")) {
            europe.addToLocationGroup(discoveredDinosaur, "Europe");
            discoveredDinosaur.addLocationFound("Europe");
            System.out.println("Successfully added location!");
        } else {
            System.out.println("Invalid Input...");
        }
    }

    private void addEraToNewDino() {
        System.out.println("Did the dinosaur live in: Triassic, Jurassic or Cretaceous?");
        String era = input.next();
        if (era.equals("Triassic")) {
            triassic.addToEraGroup(discoveredDinosaur, "Triassic");
            discoveredDinosaur.addEra("Triassic");
            System.out.println("Successfully added Mesozoic Era!");
        } else if (era.equals("Jurassic")) {
            jurassic.addToEraGroup(discoveredDinosaur, "Jurassic");
            discoveredDinosaur.addEra("Jurassic");
            System.out.println("Successfully added Mesozoic Era!");
        } else if (era.equals("Cretaceous")) {
            cretaceous.addToEraGroup(discoveredDinosaur, "Cretaceous");
            discoveredDinosaur.addEra("Cretaceous");
            System.out.println("Successfully added Mesozoic Era!");
        } else {
            System.out.println("Invalid Input...");
        }
    }

    private void updatePeriod() {
        System.out.println("Did the dinosaur live in: Triassic, Jurassic or Cretaceous?");
        String era = input.next();
        if (era.equals("Triassic")) {
            triassic.addToEraGroup(discoveredDinosaur, "Triassic");
            discoveredDinosaur.addEra("Triassic");
            System.out.println("Successfully added Mesozoic Era!");
        } else if (era.equals("Jurassic")) {
            jurassic.addToEraGroup(discoveredDinosaur, "Jurassic");
            discoveredDinosaur.addEra("Jurassic");
            System.out.println("Successfully added Mesozoic Era!");
        } else if (era.equals("Cretaceous")) {
            cretaceous.addToEraGroup(discoveredDinosaur, "Cretaceous");
            discoveredDinosaur.addEra("Cretaceous");
            System.out.println("Successfully added Mesozoic Era!");
        } else {
            System.out.println("Invalid Input...");
        }
    }


}
