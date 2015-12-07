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
            Enum humanChoice = askPlayerAndReturnChoice();

            if (userQuits(humanChoice)) {
                console.print(userInterface.sayBye());
                break;
            }
            playOnce(humanChoice);
        }
    }

    public void playOnce(Enum humanChoice) {
        Enum computerChoice = computerPlayer.generateMove();
        Rules rules = new Rules(humanChoice, computerChoice);
        communicateWinner(computerChoice, rules);
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

    private void communicateWinner(Enum computerChoice, Rules rules) {
        print(userInterface.showComputerChoice(computerChoice.toString()));
        print(userInterface.announceGameEnd(rules.findWinner()));
    }

    private void print(String message) {
        console.print(message);
    }

    private Enum askPlayerAndReturnChoice() {
        print(userInterface.askForHumanChoice());
        Enum userInput = getUserInput();
        while (userInput == null) {
            play();
        }
        return userInput;
    }

    private boolean userQuits(Enum humanChoice) {
        return humanChoice.equals(Move.EXIT);
    }

}
