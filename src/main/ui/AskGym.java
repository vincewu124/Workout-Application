package ui;

import java.io.IOException;
import java.util.Scanner;

public class AskGym extends AskWorkout {
    private AskBody askBody;
    private Scanner scan;

    public AskGym() throws IOException {
        scan = new Scanner(System.in);
        askBody = new AskBody();
        asking();
    }

    @Override
    //EFFECTS: Asks the user what body part they want to workout and stores it into workout
    public void askBody() {
        askBody.askingGymOrStretches();
        String body = scan.nextLine();
        System.out.println("You choose: " + body);
        workout.userAddBody(body);
    }
}