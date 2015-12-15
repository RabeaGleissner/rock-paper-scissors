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
            // potentially put the below methods in one method playTurn()
            Move computerChoice = computerMove();
            GameEnd gameEnd = evaluateGameState(humanChoice, computerChoice);
            announceGameEnd(computerChoice, gameEnd);
        }
    }

    private GameEnd evaluateGameState(Move humanChoice, Move computerChoice) {
       Rules rules = new Rules(humanChoice, computerChoice);
        return rules.gameEndState();
    }

    private void announceGameEnd(Move computerChoice, GameEnd gameEnd) {
        userInterface.communicateWinner(computerChoice, gameEnd);
    }

    private Move computerMove() {
        // communicate choice
        return computerPlayer.generateMove();
    }

    private boolean userQuits(Move humanChoice) {
        return humanChoice.equals(Move.EXIT);
    }
}