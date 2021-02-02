package ui;

import exception.LoadingException;
import model.WorkoutList;
//import model.SetsAndReps;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Scanner;

public abstract class AskWorkout extends JPanel {
    private Scanner scanner;
    protected WorkoutList workout;
    private JLabel askQ;
//    private SetsAndReps setsAndReps;

    //EFFECTS: creates new scanner, instance of a WorkoutList and instance of AskType
    public AskWorkout() {
        scanner = new Scanner(System.in);
        workout = new WorkoutList();
        setBackground(new Color(37, 55, 180));
        askQ = new JLabel("What would you like to do? (type the number) "
                + "([1]add a workout, [2]show workout, or [3]end program)");
        add(askQ);
        add(Box.createHorizontalStrut(10));


//        setsAndReps = new SetsAndReps();
    }


    //code source: https://github.students.cs.ubc.ca/CPSC210/B04-SimpleCalculatorSolutionLecLab.git

    //EFFECTS: Starts asking the user what they want to do and adds & saves user workout inputs into a file.
    //         Then the user is given the choice to continue adding files or show files
    public void asking() throws IOException {
        while (true) {
            choices();
            String choice = scanner.nextLine();
            System.out.println("you choose: " + choice);
            if (choice.equals("1")) {
                askBody();
                askExer();
                askSave();
            }
            if (choice.equals("2")) {
                askLoad();
            }
            if (choice.equals("3")) {
                break;
            }
        }
    }

    public void choices() {
        System.out.println("What would you like to do? (type the number) "
                + "([1]add a workout, [2]show workout, or [3]end program)");
    }


    //EFFECTS: ask user for input and sends it to a method that handles setting it
    public abstract void askBody();

    //EFFECTS: continues asking user for input and calls method to set it until it finishes
    public void askExer() {
        while (true) {
            System.out.println("What exercise would you like to add? [or say done to quit]");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("done")) {
                break;
            }
          //  workout.settingExer(input);
        }
    }

    //EFFECTS: asks the user what name they want to save the file as and pass it to the save method
    public void askSave() throws IOException {
        System.out.println("What would you like to name this workout?");
        String nameFile;
        nameFile = scanner.nextLine();
        System.out.println("The name of this workout is " + nameFile);
     //   workout.save(nameFile);
    }

    //EFFECTS: ask the user which file they want to read
    public void askLoad() throws IOException {
        System.out.println("Which workout would you like to see");
        String wantFile = scanner.nextLine();
        try {
            workout.load(wantFile);
        } catch (LoadingException e) {
            System.out.println("File does not exist");
            askLoad();
        }
    }
}