package ui;

import java.io.IOException;
import java.util.Scanner;

public class AskStretches extends AskWorkout {
    private Scanner scan;
    private AskBody askBody;


    public AskStretches() throws IOException {
        scan = new Scanner(System.in);
        askBody = new AskBody();
        asking();
    }

    @Override
    //EFFECTS: asks the user what body part they want to stretch and stores it into workout
    public void askBody() {
        askBody.askingGymOrStretches();
        String body = scan.nextLine();
        System.out.println("You choose: " + body);
        workout.userAddBody(body);

    }
}