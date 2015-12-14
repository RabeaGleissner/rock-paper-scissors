package game;

public class Game {

    private final UserInterface userInterface;
    private final ComputerPlayer computerPlayer;


    public Game(UserInterface userInterface, ComputerPlayer computerPlayer) {
        this.userInterface = userInterface;
        this.computerPlayer = computerPlayer;
    }

    public void play() {
        userInterface.chooseLanguage();
        while (true) {
            Move humanChoice = userInterface.humanChoice();

            if (userQuits(humanChoice)) {
                userInterface.sayBye();
                break;
            }
            announceGameEnd(humanChoice);
        }
    }

    private void announceGameEnd(Move humanChoice) {
        Move computerChoice = computerMove();
        userInterface.communicateWinner(computerChoice, new Rules(humanChoice, computerChoice));
    }

    private Move computerMove() {
        return computerPlayer.generateMove();
    }

    private boolean userQuits(Move humanChoice) {
        return humanChoice.equals(Move.EXIT);
    }
}