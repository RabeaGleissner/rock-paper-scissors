import java.util.Objects;

public class Rules {

    private Move humanChoice;
    private Move computerChoice;

    public Rules(Move humanChoice, Move computerChoice) {
        this.humanChoice = humanChoice;
        this.computerChoice = computerChoice;
    }

    public String findWinner() {
        Move winningMove = winningMove();

        if (winningMove == humanChoice) {
            return "human";
        } else if (winningMove == computerChoice) {
            return "computer";
        } else if (draw()) {
            return "draw";
        } else {
            return "something went wrong";
        }
    }

    private Move winningMove() {
        if (paperWins() ) {
            return Move.PAPER;
        } else if (rockWins()) {
            return Move.ROCK;
        } else if (scissorsWin()) {
            return Move.SCISSORS;
        } else {
            return null;
        }
    }

    private boolean paperWins() {
        return ((humanChoice == Move.ROCK) && (computerChoice == Move.PAPER)) ||
                ((humanChoice  == Move.PAPER) && (computerChoice == Move.ROCK));
    }

    private boolean rockWins() {
        return ((humanChoice == Move.ROCK) && (computerChoice == Move.SCISSORS)) ||
                ((humanChoice == Move.SCISSORS) && (computerChoice == Move.ROCK));
    }

    private boolean scissorsWin() {
        return ((humanChoice == Move.PAPER) && (computerChoice == Move.SCISSORS)) ||
                ((humanChoice == Move.SCISSORS) && (computerChoice == Move.PAPER));
    }

    private boolean draw() {
        return Objects.equals(humanChoice, computerChoice);
    }
}
