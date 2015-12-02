import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ComputerPlayer {
    public String generateMove() {

        return getRandomMove();
    }

    private String getRandomMove() {
        String[] options = {"rock", "paper", "scissors"};
        int index = (int) (Math.random() * options.length);
        return options[index];
    }
}

