package UI;

import game.UserInterface;

import java.util.Objects;

public class UserInterfaceEngl implements UserInterface {

    String PROMPT = "\nPlease enter your choice: (R = rock, S = scissors, P = paper) or type E for exit";
    String DRAW = "It's a draw!";
    String WINNER = "Winner: ";
    String COMPUTER_CHOICE = "Computer choice was: ";
    String GOODBYE = "See you next time!";

    public String askForHumanChoice() {
        return PROMPT;
    }

    public String announceGameEnd(String winner) {
        if (Objects.equals(winner, "draw")) {
            return DRAW;
        } else {
            return WINNER + winner;
        }
    }

    public String showComputerChoice(String choice) {
        return COMPUTER_CHOICE + choice;
    }

    public String sayBye() {
        return GOODBYE;
    }
}
