package game;

public class Game {

    private final Console console;
    private final UserInterface userInterface;
    private final ComputerPlayer computerPlayer;


    public Game(Console console, UserInterface userInterface, ComputerPlayer computerPlayer) {
        this.console = console;
        this.userInterface = userInterface;
        this.computerPlayer = computerPlayer;
    }

    public void play() {
        while (true) {
            Move humanChoice = askPlayerAndReturnChoice();

            if (userQuits(humanChoice)) {
                console.print(userInterface.sayBye());
                break;
            }
            playOnce(humanChoice);
        }
    }

    public void playOnce(Move humanChoice) {
        Move computerChoice = computerPlayer.generateMove();
        Rules rules = new Rules(humanChoice, computerChoice);
        communicateWinner(computerChoice, rules);
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

    private boolean isValid(Move humanChoice) {
        return humanChoice == Move.ROCK ||
               humanChoice == Move.SCISSORS ||
               humanChoice == Move.PAPER ||
               humanChoice == Move.EXIT;
    }

    private void communicateWinner(Move computerChoice, Rules rules) {
        print(userInterface.showComputerChoice(computerChoice.toString()));
        print(userInterface.announceGameEnd(rules.findWinner()));
    }

    private void print(String message) {
        console.print(message);
    }

    private Move askPlayerAndReturnChoice() {
        print(userInterface.askForHumanChoice());
        Move userInput = getUserInput();
        while (userInput == null) {
            play();
        }
        return userInput;
    }

    private boolean userQuits(Move humanChoice) {
        return humanChoice.equals(Move.EXIT);
    }

}
