package ui;

import model.DefaultDinos;
import model.Dinosaur;

import javax.swing.*;
import java.awt.*;

public class SearchByNameGUI extends DefaultDinos {
    private JLabel label;
    private JLabel dinoName;
    private JLabel dinoDiet;
    private JLabel dinoEra;
    private JLabel dinoLocation;
    private JLabel dinoDescription;
    private JLabel dinoSize;
    private JPanel dinoDescriptionPanel;
    private ImageIcon dinoImage;
    private JLabel dinoImageFrame;

    private JFrame nameSearchFrame;

    private JFrame dinoInfoFrame;
    private JPanel dinoInfoPanel;

    private JPanel nameSearchPanel;
    private JButton nextDino;
    private JButton menu;

    // EFFECTS: Opens the Searching GUI for DinosaurIndex.
    public SearchByNameGUI() {
        nameSearchFrame = new JFrame();

        label = new JLabel("Current Dinosaurs in the Index:" + catalogue.printDinoNames());
        nameSearchPanel = new JPanel();

        for (Dinosaur d : catalogue.returnCatalogueOfDinosaur()) {
            nextDino = new JButton(d.getName());
            nextDino.addActionListener(e -> {
                setDinoInfoFrame(d);
            }
            );
            nameSearchPanel.add(nextDino);
        }

        nameSearchPanel.add(label);
        nameSearchPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        nameSearchPanel.setLayout(new GridLayout(0, 1));

        nameSearchFrame.add(nameSearchPanel, BorderLayout.CENTER);
        nameSearchFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        nameSearchFrame.pack();
        nameSearchFrame.setVisible(true);
    }

    // EFFECTS: Initialises the Searching GUI for DinosaurIndex.
    public void setDinoInfoFrame(Dinosaur d) {
        dinoInfoFrame = new JFrame();
        dinoInfoPanel = new JPanel();
        dinoDescriptionPanel = new JPanel();
        menu = new JButton("Return to Main Menu");
        menu.addActionListener(e -> {
            new GUI();
            dinoInfoFrame.dispose();
            nameSearchFrame.dispose();
        });
        dinoName = new JLabel("Name: " + d.getName());
        dinoDiet = new JLabel("Diet: " + d.getDiet());
        dinoEra = new JLabel("Mesozoic Era: " + d.getEra());
        dinoLocation = new JLabel("Location of Discovery: " + d.getLocation());
        dinoDescription = new JLabel("Description: " + d.getDescription());
        dinoSize = new JLabel("Size: " + d.getSize());
        dinoImage = new ImageIcon(d.getImageDirectory());
        refactorImage(d);
        dinoImageFrame = new JLabel(dinoImage);



        dinoInfoPanel.setLayout(new GridLayout(0, 1));
        panelDinoInfo();

        dinoInfoFrame.setSize(900, 900);
        dinoInfoFrame.setLocationRelativeTo(null);
        dinoInfoFrame.setVisible(true);
    }

    // EFFECTS: Refactors the Image when loading the DinosaurIndex.
    public void refactorImage(Dinosaur d) {
        ImageIcon diImage = dinoImage;
        Image tempImage = diImage.getImage();
        Image newImage = tempImage.getScaledInstance(130, 115, java.awt.Image.SCALE_SMOOTH);
        d.pasteImage(new ImageIcon(newImage));
        dinoImage = d.getImage();
    }

    // EFFECTS: Adds the labels and buttons to the Information Panel.
    public void panelDinoInfo() {
        dinoInfoPanel.add(dinoName);
        dinoInfoPanel.add(dinoDiet);
        dinoInfoPanel.add(dinoEra);
        dinoInfoPanel.add(dinoLocation);
        dinoInfoPanel.add(dinoDescription);
        dinoInfoPanel.add(dinoSize);
        dinoInfoPanel.add(dinoImageFrame);
        dinoInfoPanel.add(menu);
        dinoInfoFrame.add(dinoInfoPanel);
    }
}
