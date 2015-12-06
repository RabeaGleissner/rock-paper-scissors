public class Game {

    private final Console console;
    private final UserInterface userInterface;
    private final ComputerPlayer computerPlayer;


    public Game(Console console, UserInterface userInterface, ComputerPlayer computerPlayer) {
        this.console = console;
        this.userInterface = userInterface;
        this.computerPlayer = computerPlayer;
    }

    public Enum getUserInput() {
        String move = console.read();
        Enum returnedMove = null;
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

    public void print(String message) {
        console.print(message);
    }


    public Enum askPlayerAndReturnChoice() {
        print(userInterface.askForHumanChoice());
        return getUserInput();
    }

}
