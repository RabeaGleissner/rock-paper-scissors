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
            UserChoice userChoice = userInterface.humanChoice();

            if (userQuits(userChoice)) {
                userInterface.sayBye();
                break;
            }
            GameEnd gameState = evaluateGameState(userChoice.getMove(), computerMove());
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

    private boolean userQuits(UserChoice userChoice) {
        return GameControls.EXIT == userChoice.getTerminate();
    }
}