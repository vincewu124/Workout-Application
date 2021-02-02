package model;

import java.util.ArrayList;
import java.util.Objects;

public class Exercise {
    private String name;
    private ArrayList<WorkoutHolder> workouts;

    public Exercise(String name) {
        this.name = name;
    }

    //EFFECTS: return the name of the exercise
    public String getName() {
        return this.name;
    }

    //MODIFIES: this, workout
    //EFFECTS: adds the workout to workouts if it doesn't already contain it and adds it to the add method in
    //         the WorkoutHolder class
    public void add(WorkoutHolder workout) {
        workouts = new ArrayList<>();
        if (!workouts.contains(workout)) {
            workouts.add(workout);
            workout.add(this);
        }
    }

    //EFFECTS: returns the exercises stored in bodyWorkouts in the form of an ArrayList
    public ArrayList<WorkoutHolder> getWorkoutHolder() {
        return workouts;
    }


    //EFFECTS: checks if the objects are the same
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Exercise exercise = (Exercise) o;
        return name.equals(exercise.name);
    }

    //EFFECTS: returns the object's name in the hashcode
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
