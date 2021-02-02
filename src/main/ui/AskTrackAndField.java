package ui;

import java.io.IOException;
import java.util.Scanner;

public class AskTrackAndField extends AskWorkout {
    private Scanner scan;
    private AskBody askBody;


    public AskTrackAndField() throws IOException {
        scan = new Scanner(System.in);
        askBody = new AskBody();
        asking();
    }

    @Override
    //EFFECTS: asks the user what body part they want to workout for track and stores it into workout
    public void askBody() {
        askBody.askingTrackAndField();
        String body = scan.nextLine();
        System.out.println("You choose: " + body);
        workout.userAddBody(body);

    }
}