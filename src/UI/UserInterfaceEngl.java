package UI;
import game.Console;
import game.Move;
import game.Rules;
import game.UserInterface;
import java.util.Objects;

public class UserInterfaceEngl implements UserInterface {

    private final Console console;

    public UserInterfaceEngl(Console console) {
        this.console = console;
    }

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

    public String goodbye() {
        return GOODBYE;
    }

    public void sayBye() {
        console.print(goodbye());
    }

    public void print(String message) {
        console.print(message);
    }

    public void communicateWinner(Move computerChoice, Rules rules) {
        print(showComputerChoice(computerChoice.toString()));
        print(announceGameEnd(rules.findWinner()));
    }

    public Move askPlayerAndReturnChoice() {
        print(askForHumanChoice());
        Move userInput = getUserInput();
        return userInput;
    }

    public Move getUserInput() {
        String move = console.read();
        Move returnedMove = null;
        switch (move) {
            case "R": returnedMove = Move.ROCK;
                break;
            case "S": returnedMove = Move.SCISSORS;
                break;
            case "P": returnedMove = Move.PAPER;
                break;
            case "E": returnedMove = Move.EXIT;
                break;
        }
        return returnedMove;
    }
}


