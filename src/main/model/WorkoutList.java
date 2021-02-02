package model;

import exception.LoadingException;
import observer.WorkoutO;

import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


public class WorkoutList extends Observable implements Load, Save, Serializable {
    private Map<Integer, WorkoutHolder> workoutLog;
    private ArrayList<Integer> keyRecord;
    private Statistics stat;
    private Holder hold;
    private LoadJLabel load;

    public WorkoutList() {
        workoutLog = new HashMap<>();
        keyRecord = new ArrayList<>();
        stat = new Statistics();
        hold = new Holder();
        addObserver(new WorkoutO(hold));
    }

    //MODIFIES: this
    //EFFECTS: adds the key and inputted into the hashMap, sets the body into inputted and goes to the notify method
    public void addBody(Integer key, String body) {
        if (!keyRecord.contains(key)) {
            WorkoutHolder workoutHolder = new WorkoutHolder();
            workoutLog.put(key, workoutHolder);
            settingBody(body, workoutHolder);
            notifying();
            keyRecord.add(key);
        }
    }


    //EFFECTS: sets the change and notifies the observer
    public void notifying() {
        setChanged();
        notifyObservers();
    }

    public JLabel setHolder(JLabel j) {
        return hold.setT(j);
    }

    public JLabel getHolderBack() {
        return hold.getT();
    }


    //MODIFIES: this
    //EFFECTS: sets the string into the instance of WorkoutHolder (inputted)
    public void settingBody(String body, WorkoutHolder w) {
        stat.chooseAdd(body);
        w.setBody(body);
    }

    //EFFECTS: returns an arrayList from the chooseBody method
    public ArrayList<Integer> chooseStatBody() {
        return stat.chooseBody();
    }

    //MODIFIES: this
    //EFFECTS: returns a WorkoutHolder that is set to specific key in the workoutLog
    public WorkoutHolder getWorkoutHolder(String body) {
        WorkoutHolder h = new WorkoutHolder();
        for (Integer i : keyRecord) {
            if (workoutLog.get(i).getBody().equals(body)) {
                h = workoutLog.get(i);
            }
        }
        return h;
    }


    //MODIFIES: this
    //EFFECTS: creates a new file and saves the input from workoutLog into the file
    @Override
    public void save(String nameFile, String body) throws IOException {
        PrintWriter writer = new PrintWriter("data//" + nameFile + ".txt");
        WorkoutHolder h = getWorkoutHolder(body);
        String str = h.getBody() + "/";
        for (Exercise e : h.getBodyWorkouts()) {
            str = str + e.getName() + "/";
        }
        writer.println(str);
        writer.close();
    }


    //https://blog.jetbrains.com/idea/2016/08/using-junit-5-in-intellij-idea/
    //MODIFIES: this
    //EFFECTS: loads the file that the user wants to see
    @Override
    public List<String> load(String wantFile) throws IOException, LoadingException {
        File tmpDir = new File("data//" + wantFile + ".txt");
        boolean exists = tmpDir.exists();
        if (!exists) {
            throw new LoadingException();
        }
        List<String> workList = Files.readAllLines(Paths.get("data//" + wantFile + ".txt"));
        for (String line : workList) {
            ArrayList<String> splitString = stringListToAL(line.split("/"));
            System.out.println("Workout body part: " + splitString.get(0) + ", with the following exercise(s):");
            splitString.remove(0);
            int count = 1;
            for (String workout : splitString) {
                System.out.println("Exercise " + (count) + ": " + workout);
                count++;
            }
        }
        makeJpanel(wantFile);
        return workList;
    }

    //MODIFIES: this
    //EFFECTS: converts an array string list to an array list
    public ArrayList<String> stringListToAL(String[] list) {
        ArrayList<String> listed = new ArrayList<>();
        for (String s : list) {
            listed.add(s);
        }
        return listed;
    }

    //EFFECTS: sets the desired load file into the setLoad method to create a JPanel for it
    public void makeJpanel(String wantFile) throws IOException, LoadingException {
        load = new LoadJLabel();
        load.makeLabel(wantFile);
    }

    public JLabel getText() {
        return load.getText();
    }

    public JLabel getExer() {
        return load.getExer();
    }

    //MODIFIES: this
    //EFFECTS: checks where the body belongs with a specific number and passes it to the addBody method
    public String userAddBody(String body) {
        switch (body) {
            case "Chest":
                addBody(1, body);
                return body;
            case "Arms":
                addBody(2, body);
                return body;
            case "Shoulders":
                addBody(3, body);
                return body;
            default:
                userAddMore(body);
        }
        return "none";
    }

    //MODIFIES: this
    //EFFECTS: continues searching for the body and sends it to addBody method
    public String userAddMore(String body) {
        switch (body) {
            case "Full body":
                addBody(4, body);
                return body;
            case "Circuit":
                addBody(5, body);
                return body;
            default:
        }
        return "none";
    }
}


