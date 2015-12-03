import java.util.Objects;

public class Rules {

    private Enum humanChoice;
    private Enum computerChoice;

    public Rules(Enum humanChoice, Enum computerChoice) {
        this.humanChoice = humanChoice;
        this.computerChoice = computerChoice;
    }

    public String findWinner() {
        Enum winner = rules();

        if (Objects.equals(winner, humanChoice)) {
            return "human";
        } else if (Objects.equals(winner, computerChoice)) {
            return "computer";
        } else if (draw()) {
            return "draw";
        } else {
            return "something went wrong";
        }
    }

    private Enum rules() {
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
        return (Objects.equals(humanChoice, Move.ROCK) && Objects.equals(computerChoice, Move.PAPER)) ||
                (Objects.equals(humanChoice, Move.PAPER) && Objects.equals(computerChoice, Move.ROCK));
    }

    private boolean rockWins() {
        return (Objects.equals(humanChoice, Move.ROCK) && Objects.equals(computerChoice, Move.SCISSORS)) ||
                (Objects.equals(humanChoice, Move.SCISSORS) && Objects.equals(computerChoice, Move.ROCK));
    }

    private boolean scissorsWin() {
        return (Objects.equals(humanChoice, Move.PAPER) && Objects.equals(computerChoice, Move.SCISSORS)) ||
                (Objects.equals(humanChoice, Move.SCISSORS) && Objects.equals(computerChoice, Move.PAPER));
    }

    private boolean draw() {
        return Objects.equals(humanChoice, computerChoice);
    }
}
