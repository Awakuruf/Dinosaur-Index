package ui;

import model.DefaultDinos;
import persistence.JsonDinoAnalyzer;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class LoadDinosaurGUI extends DefaultDinos {

    private JFrame loadFrame;
    private JPanel loadPanel;
    private JButton enterButton;
    private JLabel saveMessage;

    private JsonDinoAnalyzer jsonDinoAnalyzer;
    private static final String JSON_STORE = "./data/dinoIndex.json";

    private JPanel errorPanel;
    private JLabel errorMessage;
    private JButton errorButton;

    // EFFECTS: Opens the Loading GUI for DinosaurIndex.
    public LoadDinosaurGUI() {
        jsonDinoAnalyzer = new JsonDinoAnalyzer(JSON_STORE);
        loadDinoIndex();

        loadFrame = new JFrame();
        loadPanel = new JPanel();
        saveMessage = new JLabel("Successfully loaded your DinoIndex");
        enterButton = new JButton("Okay");
        enterButton.addActionListener(e -> {
            new GUI();
            loadFrame.dispose();
        });

        loadPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        loadPanel.setLayout(new GridLayout(0, 1));
        loadPanel.add(saveMessage);
        loadPanel.add(enterButton);


        loadFrame.add(loadPanel, BorderLayout.CENTER);
        loadFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loadFrame.pack();
        loadFrame.setVisible(true);
    }

    // EFFECTS: Saves the currently inputted DinoIndex.
    public void loadDinoIndex() {
        try {
            catalogue = jsonDinoAnalyzer.analyze();
        } catch (IOException e) {
            errorPanel = new JPanel();
            errorMessage = new JLabel("Error: Unable to load your DinoIndex!");
            errorButton = new JButton("Try Again");
            enterButton.addActionListener(e1 -> {
                new GUI();
                loadFrame.dispose();
            });

            errorPanel.add(errorMessage);
            errorPanel.add(errorButton);

        }
    }
}
