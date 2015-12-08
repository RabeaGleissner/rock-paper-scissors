package game;

public class Game {

    private final UserInterface userInterface;
    private final ComputerPlayer computerPlayer;


    public Game(UserInterface userInterface, ComputerPlayer computerPlayer) {
        this.userInterface = userInterface;
        this.computerPlayer = computerPlayer;
    }

    public void play() {
        while (true) {
            Move humanChoice = userInterface.humanChoice();

            if (userQuits(humanChoice)) {
                userInterface.sayBye();
                break;
            }
            getWinner(humanChoice);
        }
    }

    public void getWinner(Move humanChoice) {
        Move computerChoice = computerPlayer.generateMove();
        Rules rules = new Rules(humanChoice, computerChoice);
        userInterface.communicateWinner(computerChoice, rules);
    }

    private boolean userQuits(Move humanChoice) {
        return humanChoice.equals(Move.EXIT);
    }
}