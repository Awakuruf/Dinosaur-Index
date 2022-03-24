package ui;

import model.DefaultDinos;
import model.Dinosaur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DiscoverDinosaurGUI extends DefaultDinos implements ActionListener {
    private JFrame discoveredDinoFrame;
    private JFrame optionFrame;
    private JFrame descriptionFrame;
    private JLabel discoveredDinoLabel;
    private JLabel optionLabel;
    private JPanel discoveredDinoPanel;
    private JPanel optionPanel;
    private JPanel descriptionPanel;
    private JButton confirm;
    private JTextField inputtedName;
    private JLabel success;
    private Dinosaur newDino;

    private JButton diet;
    private JButton location;
    private JButton era;
    private JButton size;
    private JButton description;
    private JButton back;

    private JTextField inputtedDescription;
    private JLabel descriptionQuestion;
    private JButton confirmDescription;

    private JFrame dietFrame;
    private JPanel dietPanel;
    private JLabel dietMessage;
    private JButton carnivore;
    private JButton herbivore;
    private JButton omnivore;

    private JFrame eraFrame;
    private JPanel eraPanel;
    private JLabel eraMessage;
    private JButton triassic;
    private JButton jurassic;
    private JButton cretaceous;

    private JFrame locationFrame;
    private JPanel locationPanel;
    private JLabel locationMessage;
    private JButton asia;
    private JButton northAmerica;
    private JButton africa;
    private JButton europe;
    private JButton southAmerica;

    private JFrame sizeFrame;
    private JPanel sizePanel;
    private JLabel sizeMessage;
    private JTextField inputtedSize;
    private JButton confirmSize;

    private JTextField dinoImage;



    // EFFECTS: Opens the GUi for DiscoverDinosaur Page.
    public DiscoverDinosaurGUI() {
        discoveredDinoFrame = new JFrame();
        discoveredDinoPanel = new JPanel();

        discoveredDinoLabel = new JLabel("Name of the newly Discovered Dinosaur!: ");
        inputtedName = new JTextField(20);
        inputtedName.setBounds(100,20,165,25);
        confirm = new JButton("Add Dino to Index!");
        confirm.setBounds(10,80,80,25);
        confirm.addActionListener(this);
        success = new JLabel("");
        success.setBounds(10, 110, 300, 25);

        discoveredDinoPanel.add(discoveredDinoLabel);
        discoveredDinoPanel.add(inputtedName);
        discoveredDinoPanel.add(confirm);
        discoveredDinoPanel.add(success);
        discoveredDinoPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        discoveredDinoPanel.setLayout(new GridLayout(0, 1));

        discoveredDinoFrame.add(discoveredDinoPanel, BorderLayout.CENTER);
        discoveredDinoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        discoveredDinoFrame.pack();
        discoveredDinoFrame.setVisible(true);
    }

    // EFFECTS: Opens the available options for DiscoverDinosaur Page.
    public void openOptions() {
        optionFrame = new JFrame();
        optionPanel = new JPanel();

        optionLabel = new JLabel("Which information would you like to add?: ");

        initialiseOptionButtons();
        initialiseOptions();

        optionPanel.setLayout(new GridLayout(0, 1));

        optionFrame.add(optionPanel, BorderLayout.CENTER);
        optionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        optionFrame.pack();
        optionFrame.setVisible(true);
    }

    // EFFECTS: Adds the buttons used in DiscoverDinosaur Page.
    public void initialiseOptions() {
        optionPanel.add(optionLabel);
        optionPanel.add(description);
        optionPanel.add(diet);
        optionPanel.add(location);
        optionPanel.add(era);
        optionPanel.add(size);
        optionPanel.add(back);
    }

    // EFFECTS: Initialises the buttons used in DiscoverDinosaur Page.
    public void initialiseOptionButtons() {
        description = new JButton("Description");
        diet = new JButton("Diet");
        location = new JButton("Location of Discovery");
        era = new JButton("Mesozoic Era");
        size = new JButton("Size");
        back = new JButton("Return to Main Menu");
        description.addActionListener(this);
        diet.addActionListener(this);
        location.addActionListener(this);
        era.addActionListener(this);
        size.addActionListener(this);
        back.addActionListener(e -> {
            new GUI();
            optionFrame.dispose();
        });
    }

    // MODIFIES: Dinosaur
    // EFFECTS: Initialises the frame used in to add description of the dinosaur.
    public void addDescription() {
        descriptionFrame = new JFrame();
        descriptionPanel = new JPanel();

        inputtedDescription = new JTextField(20);
        inputtedDescription.setBounds(100,20,165,25);

        descriptionQuestion = new JLabel("What is the description you want to add?");

        confirmDescription = new JButton("Add Description!");
        confirmDescription.addActionListener(e -> {
            String inputtedDescription = this.inputtedDescription.getText();
            newDino.addDescription(inputtedDescription);
            descriptionFrame.dispose();
            discoveredDinoFrame.dispose();
        });


        descriptionPanel.add(descriptionQuestion);
        descriptionPanel.add(inputtedDescription);
        descriptionPanel.add(confirmDescription);
        descriptionPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        descriptionPanel.setLayout(new GridLayout(0, 1));

        descriptionFrame.add(descriptionPanel, BorderLayout.CENTER);
        descriptionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        descriptionFrame.pack();
        descriptionFrame.setVisible(true);
    }

    // MODIFIES: Dinosaur
    // EFFECTS: Initialises the frame used in to add diet of the dinosaur.
    public void addDiet() {
        dietFrame = new JFrame();
        dietPanel = new JPanel();
        dietMessage = new JLabel("Which diet did this dinosaur have?");
        dietButtonsInitialise();

        dietPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        dietPanel.setLayout(new GridLayout(0, 1));
        dietPanel.add(dietMessage);

        dietFrame.add(dietPanel, BorderLayout.CENTER);
        dietFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dietFrame.pack();
        dietFrame.setVisible(true);
    }

    // EFFECTS: Initialises the buttons used in to add diet of the dinosaur.
    public void dietButtonsInitialise() {
        carnivore = new JButton("Carnivore");
        herbivore = new JButton("Herbivore");
        omnivore = new JButton("Omnivore");

        dietPanel.add(carnivore);
        dietPanel.add(herbivore);
        dietPanel.add(omnivore);

        carnivore.addActionListener(e -> {
            newDino.addDiet("Carnivore");
            new GUI();
            dietFrame.dispose();
        });

        herbivore.addActionListener(e -> {
            newDino.addDiet("Herbivore");
            new GUI();
            dietFrame.dispose();
        });

        omnivore.addActionListener(e -> {
            newDino.addDiet("Omnivore");
            new GUI();
            dietFrame.dispose();
        });
    }

    // MODIFIES: Dinosaur
    // EFFECTS: Initialises the frame used in to add Mesozoic Era of the dinosaur.
    public void addEra() {
        eraFrame = new JFrame();
        eraPanel = new JPanel();
        eraMessage = new JLabel("Which Mesozoic Era did this dinosaur live in?");
        eraButtonsInitialise();

        eraPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        eraPanel.setLayout(new GridLayout(0, 1));
        eraPanel.add(eraMessage);

        eraFrame.add(eraPanel, BorderLayout.CENTER);
        eraFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        eraFrame.pack();
        eraFrame.setVisible(true);
    }

    // EFFECTS: Initialises the buttons used in to add Mesozoic Era of the dinosaur.
    public void eraButtonsInitialise() {
        triassic = new JButton("Triassic");
        jurassic = new JButton("Jurassic");
        cretaceous = new JButton("Cretaceous");

        eraPanel.add(triassic);
        eraPanel.add(jurassic);
        eraPanel.add(cretaceous);

        triassic.addActionListener(e -> {
            newDino.addEra("Triassic");
            new GUI();
            eraFrame.dispose();
        });

        jurassic.addActionListener(e -> {
            newDino.addEra("Jurassic");
            new GUI();
            eraFrame.dispose();
        });

        cretaceous.addActionListener(e -> {
            newDino.addEra("Cretaceous");
            new GUI();
            eraFrame.dispose();
        });
    }

    // MODIFIES: Dinosaur
    // EFFECTS: Initialises the frame used in to add size of the dinosaur.
    public void addSize() {
        sizeFrame = new JFrame();
        sizePanel = new JPanel();
        sizeMessage = new JLabel("What was this dinosaurs size? (in meters)");
        sizeButtonInitialise();

        sizePanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        sizePanel.setLayout(new GridLayout(0, 1));
        sizePanel.add(inputtedSize);
        sizePanel.add(confirmSize);

        sizeFrame.add(sizePanel, BorderLayout.CENTER);
        sizeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sizeFrame.pack();
        sizeFrame.setVisible(true);
    }

    // EFFECTS: Initialises the buttons used in to add size of the dinosaur.
    public void sizeButtonInitialise() {
        inputtedSize = new JTextField();
        confirmSize = new JButton("Add Size!");

        confirmSize.addActionListener(e -> {
            String inputtedString = this.inputtedSize.getText();
            Integer inputtedSize = Integer.parseInt(inputtedString);
            newDino.addSize(inputtedSize);
            new GUI();
            sizeFrame.dispose();
        });
    }

    // MODIFIES: Dinosaur
    // EFFECTS: Initialises the frame used in to add location of the dinosaur.
    public void addLocation() {
        locationFrame = new JFrame();
        locationPanel = new JPanel();
        locationMessage = new JLabel("Which Location was this dinosaur discovered in?");
        locationButtonsInitialise();

        locationPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        locationPanel.setLayout(new GridLayout(0, 1));
        locationPanel.add(locationMessage);

        locationFrame.add(locationPanel, BorderLayout.CENTER);
        locationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        locationFrame.pack();
        locationFrame.setVisible(true);
    }

    // EFFECTS: Initialises the button used in to add location of the dinosaur.
    public void locationButtonsInitialise() {
        asia = new JButton("Asia");
        southAmerica = new JButton("South America");
        northAmerica = new JButton("North America");
        europe = new JButton("Europe");
        africa = new JButton("Africa");

        locationPanelAdd();
        locationActionListener();
    }

    // EFFECTS: Adds the buttons of locations to the panel.
    private void locationPanelAdd() {
        locationPanel.add(asia);
        locationPanel.add(southAmerica);
        locationPanel.add(northAmerica);
        locationPanel.add(europe);
        locationPanel.add(africa);
    }

    // EFFECTS: Crates directory of methods that each buttons of location buttons to take action on.
    public void locationActionListener() {
        africa.addActionListener(e -> {
            newDino.addDiet("Africa");
            returnToMenu();
        });

        asia.addActionListener(e -> {
            newDino.addLocationFound("Asia");
            returnToMenu();
        });

        southAmerica.addActionListener(e -> {
            newDino.addLocationFound("South America");
            returnToMenu();
        });

        northAmerica.addActionListener(e -> {
            newDino.addLocationFound("North America");
            returnToMenu();
        });

        europe.addActionListener(e -> {
            newDino.addLocationFound("Europe");
            returnToMenu();
        });
    }

    // EFFECTS: Creates a directory for the return button in locationFrame.
    private void returnToMenu() {
        new GUI();
        locationFrame.dispose();
    }


    // EFFECTS: Crates directory of methods that each buttons takes action on.
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == confirm) {
            String inputtedName = this.inputtedName.getText();
            newDino = new Dinosaur(inputtedName);
            catalogue.addToCatalogueOfDino(newDino);
            discoveredDinoFrame.dispose();
            openOptions();
        } else if (e.getSource() == description) {
            addDescription();
            discoveredDinoFrame.dispose();
        } else if (e.getSource() == diet) {
            addDiet();
            discoveredDinoFrame.dispose();
        } else if (e.getSource() == location) {
            addLocation();
            discoveredDinoFrame.dispose();
        } else if (e.getSource() == era) {
            addEra();
            discoveredDinoFrame.dispose();
        } else if (e.getSource() == size) {
            addSize();
            discoveredDinoFrame.dispose();
        }
    }
}
