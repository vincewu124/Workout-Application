package ui;


import exception.LoadingException;
import model.Exercise;
import model.WorkoutHolder;
import model.WorkoutList;
import observer.WorkoutO;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;

public class User extends JFrame {
    private ListOfWorkouts bodyList;
    private Buttons buttons;
    private JFormattedTextField field2;
    private JFormattedTextField field3;
    private JFormattedTextField fieldm;
    private JFormattedTextField fieldl;

    private WorkoutList workoutList;
    private int currentIndex;
    private Map<String, ListOfWorkouts> workoutLog;

    public User() {
        workoutLog = new HashMap<>();
        bodyList = new ListOfWorkouts();
    }

    //EFFECTS: starts the program by opening a JFrame with buttons and text
    public void run() {
        workoutList = new WorkoutList();
        JFrame frame = new JFrame("WorkoutList Application");
        JPanel main = new JPanel();
        JPanel text = new JPanel();
        JPanel button = new JPanel();
        makeButtonFirst("Gym", "gym", button, this, workoutList);
        makeButtonFirst("Stretches", "stretches", button, this, workoutList);
        makeButtonFirst("Track and Field", "track", button, this, workoutList);
        text.add(new JLabel("What workout would you like to add?"));
        main.add(text);
        main.add(button);
        frame.add(main);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    //EFFECTS: creates a new JFrame to give the user options on the body they want to workout
    public void secondPanel() {
        JFrame frame = new JFrame("Body Options");
        JPanel main = new JPanel();
        JPanel button = new JPanel();
        JPanel list = new JPanel();
        list.add(new JLabel("Body"));
        list.add(bodyList);
        list.setLayout(new BoxLayout(list, BoxLayout.PAGE_AXIS));
        makeButtonSecond("Add Body", "addBody", button, this);
        makeButtonSecond("Select this Body", "selectBody", button, this);
        makeButtonSecond("Check Stats", "stats", button, this);
        makeButtonSecond("Save", "save", button, this);
        makeButtonSecond("Load", "load", button, this);
        main.add(list);
        main.add(button);
        frame.add(main);
        frame.pack();
        frame.setVisible(true);
    }

    //EFFECTS: creates a new JFrame for exercises and gives user the option of adding more into it
    public void thirdPanel() {
        JFrame frame = new JFrame("Exercises");
        currentIndex = bodyList.getIndex();
        JPanel main = new JPanel();
        JPanel list = new JPanel();
        JPanel button = new JPanel();
        list.add(new JLabel("Exercise(s)"));
        ListOfWorkouts exerList = workoutLog.get(bodyList.getValue(currentIndex));
        list.add(exerList);
        placeInIt(exerList);
        list.setLayout(new BoxLayout(list, BoxLayout.PAGE_AXIS));
        makeButtonSecond("Add Exercise", "exercise", button, this);
        main.add(list);
        main.add(button);
        frame.add(main);
        frame.pack();
        frame.setVisible(true);
    }

    //MODIFIES: this
    //EFFECTS: adds the exercises already listed into the workoutList
    public void placeInIt(ListOfWorkouts exerList) {
        String s = bodyList.getValue(currentIndex);
        for (Exercise e : workoutList.getWorkoutHolder(s).getBodyWorkouts()) {
            if (!exerList.isIn(e.getName())) {
                exerList.adding(e.getName());
            }
        }
    }


    //EFFECTS: creates a new JFrame that shows how many times a certain body part is added
    public void showStats() {
        JFrame frame = new JFrame("Statistics");
        JPanel main = new JPanel();
        main.add(workoutList.getHolderBack());
        main.setBackground(new Color(180, 108, 139));
        frame.add(main);
        frame.pack();
        frame.setVisible(true);
    }

    //MODIFIES: this
    //EFFECTS: creates a new button for the run method
    public void makeButtonFirst(String name, String type, JPanel panel, User user, WorkoutList workout) {
        buttons = new Buttons(name, type, this, workoutList);
        panel.add(buttons);
    }

    //EFFECTS: creates a button for the second panel
    public void makeButtonSecond(String name, String type, JPanel panel, User user) {
        buttons = new Buttons(name, type, this);
        panel.add(buttons);
    }

    //MODIFIES: this
    //EFFECTS: sets field and goes to the addExer method
    public void makerSecond(JFormattedTextField f) {
        field2 = f;
        addExer();
    }

    //MODIFIES: this
    //EFFECTS: sets field, adds the body to the workoutList and sets the body part to the JList to see
    public void makerThird(JFormattedTextField f) {
        field3 = f;
        workoutList.userAddBody(field3.getText());
        if (!bodyList.isIn(field3.getText())) {
            bodyList.adding(field3.getText());
        }
        workoutLog.put(field3.getText(), new ListOfWorkouts());
        GuiMakeNewPanel gui = new GuiMakeNewPanel();
        gui.showBody(field3.getText());
    }

    //MODIFIES: this
    //EFFECTS: sets field, adds the exercise to the JList and the workoutList
    public void addExer() {
        System.out.println(field2.getText());
        workoutLog.get(bodyList.getValue(currentIndex)).adding(field2.getText());
        WorkoutHolder h = workoutList.getWorkoutHolder(bodyList.getValue(currentIndex));
        h.addExercise(field2.getText());
        GuiMakeNewPanel gui = new GuiMakeNewPanel();
        gui.showExer(field2.getText());
    }

    //MODIFIES: this
    //EFFECTS: saves the workoutList into a new file
    public void makeFile(JFormattedTextField f) {
        fieldm = f;
        currentIndex = bodyList.getIndex();
        try {
            workoutList.save(fieldm.getText(), bodyList.getValue(currentIndex));
        } catch (IOException e) {
            System.out.println("Did not save");
        }
        GuiMakeNewPanel gui = new GuiMakeNewPanel();
        gui.showSaved(fieldm.getText());
    }

    //MODIFIES: this
    //EFFECTS: loads the file into a JFrame
    public void loadFile(JFormattedTextField f) {
        fieldl = f;
        try {
            workoutList.load(fieldl.getText());
        } catch (IOException e) {
            System.out.println("Did not load");
        } catch (LoadingException e) {
            System.out.println("Did not load");
        }
        JFrame frame = new JFrame();
        JPanel text = new JPanel();
        text.add(workoutList.getText());
        text.add(workoutList.getExer());
        text.setBackground(new Color(180, 108, 139));
        frame.add(text);
        frame.pack();
        frame.setVisible(true);
    }
}
