import java.util.Objects;

public class UserInterface {
    public String askForHumanChoice() {
        return "Please enter your choice: (R = rock, S = scissors, P = paper) or type E for exit";
    }

    public String announceGameEnd(String winner) {
        if (Objects.equals(winner, "draw")) {
            return "It's a draw!";
        } else {
            return "Winner: " + winner;
        }
    }
}
