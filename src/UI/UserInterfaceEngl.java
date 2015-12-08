package UI;
import game.Console;
import game.Move;
import game.Rules;
import game.UserInterface;

public class UserInterfaceEngl implements UserInterface {

    private final Console console;

    public UserInterfaceEngl(Console console) {
        this.console = console;
    }

    String PROMPT = "\nPlease enter your choice: (R = rock, S = scissors, P = paper) or type E for exit";
    String DRAW = "\n\nIt's a draw!";
    String WINNER = "\n\nWinner: ";
    String COMPUTER_CHOICE = "Computer choice was: ";
    String GOODBYE = "See you next time!";


    public void sayBye() {
        print(goodbye());
    }

    public void communicateWinner(Move computerChoice, Rules rules) {
        print(showComputerChoice(computerChoice.toString()) + announceGameEnd(rules.findWinner()));
    }

    public Move humanChoice() {
        print(askForHumanChoice());
        return getUserInput();
    }

    private Move getUserInput() {
        String move = readUserInput();
        return convertUserInputToEnum(move);
    }

    private Move convertUserInputToEnum(String move) {
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

    private String readUserInput() {
        return console.read();
    }

    private String askForHumanChoice() {
        return PROMPT;
    }

    private String showComputerChoice(String choice) {
        return COMPUTER_CHOICE + choice;
    }

    private String announceGameEnd(String winner) {
        if (winner.equals("draw")) {
            return DRAW;
        } else {
            return WINNER + winner;
        }
    }

    private void print(String message) {
        console.print(message);
    }

    private String goodbye() {
        return GOODBYE;
    }
}


