package ui;

import exception.WrongTypeException;

import java.io.IOException;
import java.util.Scanner;

public class AskType {
    private Scanner scannered;
    private AskWorkout chosen;

//   this class is initiated in the Workout class if needed for console

    public AskType() {
        scannered = new Scanner(System.in);
    }


    //EFFECTS: tries asking the user for the workout type and tells user if they inputted a type that doesn't exist
    public void askUser() throws IOException {
        try {
            asking();
        } catch (WrongTypeException e) {
            System.out.println("There is no such workout type");
        } finally {
            System.out.println("Workout complete");
        }
    }


    //EFFECTS: asks the user what type of workout they want to create and passes it into the corresponding workout type
    //         class
    public void asking() throws IOException, WrongTypeException {
        System.out.println("What type of workout would you like to choose? (Gym, Track and Field, or Stretches)");
        String type = scannered.nextLine();
        System.out.println("you chose: " + type);
        if (!(type.equalsIgnoreCase("Gym")) && !(type.equalsIgnoreCase("Track and Field"))
                && !(type.equalsIgnoreCase("Stretches"))) {
            throw new WrongTypeException();
        }
        if (type.equalsIgnoreCase("Gym")) {
            chosen = new AskGym();
        }
        if (type.equalsIgnoreCase("Track and Field")) {
            chosen = new AskTrackAndField();
        }
        if (type.equalsIgnoreCase("Stretches")) {
            chosen = new AskStretches();
        }
    }
}