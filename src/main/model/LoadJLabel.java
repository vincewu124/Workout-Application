package model;

import exception.LoadingException;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LoadJLabel {
    private JLabel text;
    private JLabel exer;
    private String string = new String();
    private int lastIndex;
    private JPanel panel = new JPanel();


    //MODIFIES: this
    //EFFECTS: converts an array string list to an array list
    public ArrayList<String> stringListToAL(String[] list) {
        ArrayList<String> listed = new ArrayList<>();
        for (String s : list) {
            listed.add(s);
        }
        return listed;
    }

    //MODIFIES: this
    //EFFECTS: converts the file into 2 JLabels (text and exer) and adds them into a JPanel
    public JPanel makeLabel(String fileName) throws IOException {
        List<String> workList = Files.readAllLines(Paths.get("data//" + fileName + ".txt"));
        for (String line : workList) {
            ArrayList<String> splitString = stringListToAL(line.split("/"));
            text = new JLabel("<html>Workout body part: " + splitString.get(0) + "<br/>"
                    + "With the following exercise(s):");
            splitString.remove(0);
            for (String workout : splitString) {
                string = string + workout + ", ";
            }
        }
        lastIndex = string.length();
        exer = new JLabel(string.substring(0, (lastIndex - 2)));
        panel.add(text);
        panel.add(exer);
        return panel;
    }

    public JPanel getPanel() {
        return panel;
    }

    public JLabel setText(JLabel j) {
        text = j;
        return text;
    }

    public JLabel setExer(JLabel j) {
        exer = j;
        return exer;
    }

    public JLabel getText() {
        return text;
    }

    public JLabel getExer() {
        return exer;
    }
}
