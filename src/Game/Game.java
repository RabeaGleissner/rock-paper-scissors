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
            GameEnd gameState = evaluateGameState(humanChoice, computerMove());
            announceGameEnd(gameState);
        }
    }

    private GameEnd evaluateGameState(Move humanChoice, Move computerChoice) {
        Rules rules = new Rules(humanChoice, computerChoice);
        return rules.gameEndState();
    }

    private void announceGameEnd(GameEnd gameEnd) {
        userInterface.communicateWinner(gameEnd);
    }

    private Move computerMove() {
        Move computerChoice = computerPlayer.generateMove();
        userInterface.showComputerChoice(computerChoice);
        return computerChoice;
    }

    private boolean userQuits(Move humanChoice) {
        return humanChoice.equals(Move.EXIT);
    }
}