package ui;

import model.DefaultDinos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends DefaultDinos implements ActionListener {

    private JLabel label;
    private JFrame frame;
    private JPanel panel;
    private JButton searchByName;
    private JButton discoverDinosaur;
    private JButton loadDinosaur;
    private JButton saveDinosaur;
    private JButton updateDinosaur;

    private ImageIcon logo;

    // EFFECTS: Opens the GUI for DinosaurIndex.
    public GUI() {
        frame = new JFrame();

        initialiseWelcome();
        searchByName.addActionListener(this);
        discoverDinosaur.addActionListener(this);
        updateDinosaur.addActionListener(this);
        saveDinosaur.addActionListener(this);
        loadDinosaur.addActionListener(this);


        panel = new JPanel();
        panel.setBorder(BorderFactory.createMatteBorder(30, 30, 10, 30, Color.white));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(label);
        panel.setBackground(Color.orange);
        addToPanel();

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Dinosaur Index");
        frame.pack();
        frame.setVisible(true);
    }


    // EFFECTS: Initialises the buttons for welcome page.
    public void initialiseWelcome() {
        label = new JLabel("Welcome to your DinoIndex!");
        logo = new ImageIcon("./images/logo.jpeg");
        label.setIcon(logo);
        label.setFont(new Font("Times New Roman", Font.BOLD, 36));
        label.setForeground(Color.black);
        label.setIconTextGap(10);
        searchByName = new JButton("Search Dinosaurs by Name!");
        discoverDinosaur = new JButton("Discovered a new Dinosaur!");
        updateDinosaur = new JButton("Update information on existing Dinosaur!");
        saveDinosaur = new JButton("Save your DinoIndex!");
        loadDinosaur = new JButton("Load your saved DinoIndex!");
    }

    // EFFECTS: Adds the labels and buttons to the Welcome Panel.
    public void addToPanel() {
        panel.add(searchByName);
        panel.add(discoverDinosaur);
        panel.add(updateDinosaur);
        panel.add(saveDinosaur);
        panel.add(loadDinosaur);
    }

    // EFFECTS: Crates directory of methods that each buttons takes action on.
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchByName) {
            new SearchByNameGUI();
            frame.dispose();
        } else if (e.getSource() == discoverDinosaur) {
            new DiscoverDinosaurGUI();
            frame.dispose();
        } else if (e.getSource() == updateDinosaur) {
            new UpdateDinosaurGUI();
        } else if (e.getSource() == saveDinosaur) {
            new SaveDinosaurGUI();
        } else if (e.getSource() == loadDinosaur) {
            new LoadDinosaurGUI();
        }
    }
}
