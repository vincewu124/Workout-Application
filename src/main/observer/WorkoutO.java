package observer;

import model.Holder;
import model.WorkoutList;
import ui.Workout;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

public class WorkoutO implements Observer {
    private Holder hold;

    public WorkoutO(Holder h) {
        hold = h;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(getResults(o));
    }

    //EFFECTS: sends the string into the setHolder method to make it a JLabel
    public String getResults(Observable o) {
        WorkoutList workoutList = (WorkoutList) o;
        hold.setHolder(new JLabel("<html>Chest has been added " + workoutList.chooseStatBody().get(0)
                + " time(s)" + "<br/>"
                + "Arms has been added "
                + workoutList.chooseStatBody().get(1) + " time(s)" + "<br/>" + "Shoulders has been added "
                + workoutList.chooseStatBody().get(2) + " time(s)" + "<br/>" + "Full body has been added "
                + workoutList.chooseStatBody().get(3) + " time(s)" + "<br/>" + "Circuit has been added "
                + workoutList.chooseStatBody().get(4) + " time(s)" + "</html>"));
        return "Chest has been added " + workoutList.chooseStatBody().get(0) + '\n'
                + "Arms has been added "
                + workoutList.chooseStatBody().get(1) + '\n' + "Shoulders has been added "
                + workoutList.chooseStatBody().get(2) + '\n' + "Full body has been added "
                + workoutList.chooseStatBody().get(3) + '\n' + "Circuit has been added "
                + workoutList.chooseStatBody().get(4);
    }
}
