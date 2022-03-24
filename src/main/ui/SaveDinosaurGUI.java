package ui;

import model.DefaultDinos;
import persistence.JsonDinoAnalyzer;
import persistence.JsonDinoWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class SaveDinosaurGUI extends DefaultDinos {

    private JFrame saveFrame;
    private JPanel savePanel;
    private JButton enterButton;
    private JLabel saveMessage;

    private JsonDinoWriter jsonDinoWriter;
    private static final String JSON_STORE = "./data/dinoIndex.json";

    private JPanel errorPanel;
    private JLabel errorMessage;
    private JButton errorButton;

    // EFFECTS: Opens the Saving GUI for DinosaurIndex.
    public SaveDinosaurGUI() {
        jsonDinoWriter = new JsonDinoWriter(JSON_STORE);
        saveDinoIndex();

        saveFrame = new JFrame();
        savePanel = new JPanel();
        saveMessage = new JLabel("Successfully saved your DinoIndex");
        enterButton = new JButton("Okay");
        enterButton.addActionListener(e -> {
            new GUI();
            saveFrame.dispose();
        });

        savePanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        savePanel.setLayout(new GridLayout(0, 1));
        savePanel.add(saveMessage);
        savePanel.add(enterButton);


        saveFrame.add(savePanel, BorderLayout.CENTER);
        saveFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        saveFrame.pack();
        saveFrame.setVisible(true);
    }

    // EFFECTS: Saves the DinoIndex it's running on.
    public void saveDinoIndex() {
        try {
            jsonDinoWriter.open();
            jsonDinoWriter.write(catalogue);
            jsonDinoWriter.close();
        } catch (FileNotFoundException e) {
            errorPanel = new JPanel();
            errorMessage = new JLabel("Error: Unable to save this DinoIndex!");
            errorButton = new JButton("Try Again");
            enterButton.addActionListener(e1 -> {
                new GUI();
                saveFrame.dispose();
            });

            errorPanel.add(errorMessage);
            errorPanel.add(errorButton);

        }
    }
}
