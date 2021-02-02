package ui;

import model.WorkoutList;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class GuiMakeNewPanel extends JFrame implements PropertyChangeListener {
    private Buttons buttons;
    private User user;
    private JFormattedTextField fieldBody;
    private JFormattedTextField fieldWorkout;
    private JFormattedTextField fieldExer;
    private JFormattedTextField fieldSave;
    private JFormattedTextField fieldLoad;
    private WorkoutList workoutList = new WorkoutList();

    public GuiMakeNewPanel() {
        fieldWorkout = new JFormattedTextField();
        fieldWorkout.setColumns(30);
        fieldBody = new JFormattedTextField();
        fieldBody.setColumns(30);
        fieldExer = new JFormattedTextField();
        fieldExer.setColumns(30);
        fieldSave = new JFormattedTextField();
        fieldSave.setColumns(30);
        fieldLoad = new JFormattedTextField();
        fieldLoad.setColumns(30);
    }

    //MODIFIES: this, user
    //EFFECTS: creates a new JFrame with button and text for body
    public void makeBody(User user) {
        this.user = user;
        JFrame frame = new JFrame("Adding Body");
        JPanel main = new JPanel();
        JPanel button = new JPanel();
        JPanel text = new JPanel();
        text.add(new JLabel("Chest, Arms, Shoulders, Full body, or Circuit"));
        text.add(fieldBody);
        text.setLayout(new BoxLayout(text, BoxLayout.PAGE_AXIS));
        makeButton("Name of Body", "bodyName", button, user, fieldBody);
        main.add(button);
        main.add(text);
        frame.add(main);
        frame.pack();
        frame.setVisible(true);
    }

    //MODIFIES: this, user
    //EFFECTS: creates a new JFrame with button and text for exercises
    public void makeExer(User user) {
        this.user = user;
        JFrame frame = new JFrame("Adding Exercise");
        JPanel main = new JPanel();
        JPanel button = new JPanel();
        JPanel text = new JPanel();
        text.add(fieldExer);
        makeButton("Add Exercise", "addExer", button, user, fieldExer);
        main.add(button);
        main.add(text);
        frame.add(main);
        frame.pack();
        frame.setVisible(true);
    }

    //MODIFIES: this, user
    //EFFECTS: creates a new JFrame with button and text for saving
    public void savePanel(User user) {
        this.user = user;
        JFrame frame = new JFrame("Saving");
        JPanel main = new JPanel();
        JPanel button = new JPanel();
        JPanel text = new JPanel();
        text.add(fieldSave);
        makeButton("Name of File", "fileName", button, user, fieldSave);
        main.add(button);
        main.add(text);
        frame.add(main);
        frame.pack();
        frame.setVisible(true);
    }

    //MODIFIES: this, user
    //EFFECTS: creates a new JFrame with button and text for saving
    public void loadPanel(User user) {
        this.user = user;
        JFrame frame = new JFrame("Loading");
        JPanel main = new JPanel();
        JPanel button = new JPanel();
        JPanel text = new JPanel();
        text.add(fieldLoad);
        makeButton("Name of File", "loadName", button, user, fieldLoad);
        main.add(button);
        main.add(text);
        frame.add(main);
        frame.pack();
        frame.setVisible(true);
    }

    //EFFECTS: makes a new button and sets it onto the JPanel
    public void makeButton(String name, String type, JPanel panel, User user, JFormattedTextField f) {
        buttons = new Buttons(name, type, user, f);
        panel.add(buttons);
    }

    //EFFECTS: gives back the user the name of the body they added
    public void showBody(String text) {
        JFrame frame = new JFrame();
        JPanel input = new JPanel();
        JLabel saved = new JLabel("Added " + text + "!");
        input.add(saved);
        input.setBackground(new Color(180, 108, 139));
        frame.add(input);
        frame.pack();
        frame.setVisible(true);
    }

    //EFFECTS: gives back the user the name of the exercise they added
    public void showExer(String text) {
        JFrame frame = new JFrame();
        JPanel input = new JPanel();
        JLabel saved = new JLabel("Added " + text + "!");
        input.add(saved);
        input.setBackground(new Color(180, 108, 139));
        frame.add(input);
        frame.pack();
        frame.setVisible(true);
    }

    //EFFECTS: gives back the user the name of the file they saved
    public void showSaved(String text) {
        JFrame frame = new JFrame();
        JPanel input = new JPanel();
        JLabel saved = new JLabel("Saved " + text + "!");
        input.add(saved);
        input.setBackground(new Color(180, 108, 139));
        frame.add(input);
        frame.pack();
        frame.setVisible(true);
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
    }
}
