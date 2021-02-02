package ui;

import model.WorkoutList;

import java.io.IOException;

public class Workout {
    public Workout() throws IOException {
    }

    //EFFECT: initiates the program
    public static void main(String[] args) throws IOException {
        User user = new User();
        user.run();
    }
}