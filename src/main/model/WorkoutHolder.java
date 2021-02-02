package model;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Observable;
import java.util.Observer;

//code source: https://github.students.cs.ubc.ca/CPSC210/B04-SimpleCalculatorSolutionLecLab.git
public class WorkoutHolder {
    private String body;
    private ArrayList<Exercise> bodyWorkouts;

    //EFFECTS: sets up a string and list
    public WorkoutHolder() {
        body = "";
    }

    //MODIFIES: this
    //EFFECTS: sets body with the input
    public void setBody(String body) {
        bodyWorkouts = new ArrayList<>();
        this.body = body;
    }

    //EFFECTS: returns the body
    public String getBody() {
        return body;
    }

    //MODIFIES: this, bodyWorkout
    //EFFECTS:  creates a temporary Exercise and passes it to the add method
    public void addExercise(String bodyWorkout) {
        Exercise tempExercise = new Exercise(bodyWorkout);
        this.add(tempExercise);
    }

    //MODIFIES: this, bodyWorkout
    //EFFECTS: adds the bodyWorkout to bodyWorkouts if it doesn't already contain it and adds it to the add method in
    //         the WorkoutHolder class
    public void add(Exercise bodyWorkout) {
        if (!bodyWorkouts.contains(bodyWorkout)) {
            bodyWorkouts.add(bodyWorkout);
            bodyWorkout.add(this);
        }
    }

    //EFFECTS:: returns the exercises stored in bodyWorkouts in the form of an ArrayList
    public ArrayList<Exercise> getBodyWorkouts() {
        return bodyWorkouts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WorkoutHolder that = (WorkoutHolder) o;
        return body.equals(that.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(body);
    }



}

