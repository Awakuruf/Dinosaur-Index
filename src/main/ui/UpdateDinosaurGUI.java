package ui;

import model.DefaultDinos;
import model.Dinosaur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateDinosaurGUI extends DefaultDinos implements ActionListener {
    private JFrame updateDinoFrame;
    private JPanel updateDinoPanel;
    private JLabel updateDinoLabel;

    private JFrame dinoFrame;
    private JPanel dinoPanel;

    private JButton description;
    private JButton location;
    private JButton era;
    private JButton diet;
    private JButton back;
    private JButton size;
    private JLabel optionLabel;

    private JButton nextDino;
    private Dinosaur selectedDino;

    private JFrame descriptionFrame;
    private JPanel descriptionPanel;
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


    public UpdateDinosaurGUI() {
        updateDinoFrame = new JFrame();
        updateDinoPanel = new JPanel();

        updateDinoLabel = new JLabel("Which Dino would you like to update?");
        updateDinoPanel.add(updateDinoLabel);
        loadDinos();

        updateDinoPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        updateDinoPanel.setLayout(new GridLayout(0, 1));

        updateDinoFrame.add(updateDinoPanel, BorderLayout.CENTER);
        updateDinoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        updateDinoFrame.pack();
        updateDinoFrame.setVisible(true);
    }


    public void loadDinos() {
        for (Dinosaur d : catalogue.returnCatalogueOfDinosaur()) {
            nextDino = new JButton(d.getName());
            nextDino.addActionListener(e -> {
                initialiseOptionFunctions();
                selectedDino = d;
                updateDinoFrame.dispose();
                    }
            );
            updateDinoPanel.add(nextDino);
        }
    }

    public void initialiseOptions() {
        dinoPanel.add(optionLabel);
        dinoPanel.add(description);
        dinoPanel.add(diet);
        dinoPanel.add(location);
        dinoPanel.add(era);
        dinoPanel.add(size);
        dinoPanel.add(back);
    }

    public void initialiseOptionFunctions() {
        dinoFrame = new JFrame();
        dinoPanel = new JPanel();

        initialiseOptionButtons();
        description.addActionListener(this);
        diet.addActionListener(this);
        location.addActionListener(this);
        era.addActionListener(this);
        size.addActionListener(this);
        back.addActionListener(e -> {
            new GUI();
            dinoFrame.dispose();
        });
        initialiseOptions();

        dinoPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        dinoPanel.setLayout(new GridLayout(0, 1));

        dinoFrame.add(dinoPanel, BorderLayout.CENTER);
        dinoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dinoFrame.pack();
        dinoFrame.setVisible(true);
    }

    public void initialiseOptionButtons() {
        optionLabel = new JLabel("Which information would you like to update?");
        description = new JButton("Description");
        diet = new JButton("Diet");
        location = new JButton("Location of Discovery");
        era = new JButton("Mesozoic Era");
        size = new JButton("Size");
        back = new JButton("Return to Main Menu");
    }

    // MODIFIES: Dinosaur
    // EFFECTS: Initialises the frame used in to update description of the dinosaur.
    public void updateDescription() {
        descriptionFrame = new JFrame();
        descriptionPanel = new JPanel();

        inputtedDescription = new JTextField(20);
        inputtedDescription.setBounds(100,20,165,25);

        descriptionQuestion = new JLabel("What is the description you want to add?");

        confirmDescription = new JButton("Add Description!");
        confirmDescription.addActionListener(e -> {
            String inputtedDescription = this.inputtedDescription.getText();
            selectedDino.addDescription(inputtedDescription);
            descriptionFrame.dispose();
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
    // EFFECTS: Initialises the frame used in to update diet of the dinosaur.
    public void updateDiet() {
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

    // EFFECTS: Initialises the buttons used in to update diet of the dinosaur.
    public void dietButtonsInitialise() {
        carnivore = new JButton("Carnivore");
        herbivore = new JButton("Herbivore");
        omnivore = new JButton("Omnivore");

        dietPanel.add(carnivore);
        dietPanel.add(herbivore);
        dietPanel.add(omnivore);

        carnivore.addActionListener(e -> {
            selectedDino.addDiet("Carnivore");
            new GUI();
            dietFrame.dispose();
        });

        herbivore.addActionListener(e -> {
            selectedDino.addDiet("Herbivore");
            new GUI();
            dietFrame.dispose();
        });

        omnivore.addActionListener(e -> {
            selectedDino.addDiet("Omnivore");
            new GUI();
            dietFrame.dispose();
        });
    }

    // MODIFIES: Dinosaur
    // EFFECTS: Initialises the frame used in to update Mesozoic Era of the dinosaur.
    public void updateEra() {
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

    // EFFECTS: Initialises the buttons used in to update Mesozoic Era of the dinosaur.
    public void eraButtonsInitialise() {
        triassic = new JButton("Triassic");
        jurassic = new JButton("Jurassic");
        cretaceous = new JButton("Cretaceous");

        eraPanel.add(triassic);
        eraPanel.add(jurassic);
        eraPanel.add(cretaceous);

        triassic.addActionListener(e -> {
            selectedDino.addEra("Triassic");
            new GUI();
            eraFrame.dispose();
        });

        jurassic.addActionListener(e -> {
            selectedDino.addEra("Jurassic");
            new GUI();
            eraFrame.dispose();
        });

        cretaceous.addActionListener(e -> {
            selectedDino.addEra("Cretaceous");
            new GUI();
            eraFrame.dispose();
        });
    }

    // MODIFIES: Dinosaur
    // EFFECTS: Initialises the frame used in to update the size of the dinosaur.
    public void updateSize() {
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

    // EFFECTS: Initialises the buttons used in to update the size of the dinosaur.
    public void sizeButtonInitialise() {
        inputtedSize = new JTextField();
        confirmSize = new JButton("Add Size!");

        confirmSize.addActionListener(e -> {
            String inputtedString = this.inputtedSize.getText();
            Integer inputtedSize = Integer.parseInt(inputtedString);
            selectedDino.addSize(inputtedSize);
            new GUI();
            sizeFrame.dispose();
        });
    }

    // MODIFIES: Dinosaur
    // EFFECTS: Initialises the frame used in to update the location of discovery for the dinosaur.
    public void updateLocation() {
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

    // MODIFIES: Dinosaur
    // EFFECTS: Initialises the buttons used in to update the location of discovery for the dinosaur.
    public void locationButtonsInitialise() {
        asia = new JButton("Asia");
        southAmerica = new JButton("South America");
        northAmerica = new JButton("North America");
        europe = new JButton("Europe");
        africa = new JButton("Africa");

        locationPanelAdd();
        locationActionListener();
    }

    // EFFECTS: Adds the corresponding buttons and labels to the location panel.
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
            selectedDino.addDiet("Africa");
            returnToMenu();
        });

        asia.addActionListener(e -> {
            selectedDino.addLocationFound("Asia");
            returnToMenu();
        });

        southAmerica.addActionListener(e -> {
            selectedDino.addLocationFound("South America");
            returnToMenu();
        });

        northAmerica.addActionListener(e -> {
            selectedDino.addLocationFound("North America");
            returnToMenu();
        });

        europe.addActionListener(e -> {
            selectedDino.addLocationFound("Europe");
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
        if (e.getSource() == description) {
            updateDescription();
            dinoFrame.dispose();
        } else if (e.getSource() == diet) {
            updateDiet();
            dinoFrame.dispose();
        } else if (e.getSource() == location) {
            updateLocation();
            dinoFrame.dispose();
        } else if (e.getSource() == era) {
            updateEra();
            dinoFrame.dispose();
        } else if (e.getSource() == size) {
            updateSize();
            dinoFrame.dispose();
        }
    }
}
