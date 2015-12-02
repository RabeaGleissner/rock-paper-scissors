import java.util.Objects;

public class Rules {

    private String humanChoice;
    private String computerChoice;

    public Rules(String humanChoice, String computerChoice) {
        this.humanChoice = humanChoice;
        this.computerChoice = computerChoice;
    }

    public String findWinner() {
        String winner = rules();

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

    private String rules() {
        String winner = "";

        if ( paperWins() ) {
            winner = "paper";
        } else if (rockWins()) {
            winner = "rock";
        } else if (scissorsWin()) {
            winner = "scissors";
        }
        return winner;
    }

    private boolean paperWins() {
        if ( (Objects.equals(humanChoice, "rock") && Objects.equals(computerChoice, "paper")) ||
                (Objects.equals(humanChoice, "paper") && Objects.equals(computerChoice, "rock")) ) {
            return true;
        }
        return false;
    }

    private boolean rockWins() {
        if ( (Objects.equals(humanChoice, "rock") && Objects.equals(computerChoice, "scissors")) ||
                (Objects.equals(humanChoice, "scissors") && Objects.equals(computerChoice, "rock")) ) {
            return true;
        }
        return false;
    }

    private boolean scissorsWin() {
        if ( (Objects.equals(humanChoice, "paper") && Objects.equals(computerChoice, "scissors")) ||
                (Objects.equals(humanChoice, "scissors") && Objects.equals(computerChoice, "paper")) ) {
            return true;
        }
        return false;
    }

    private boolean draw() {
        if (Objects.equals(humanChoice, computerChoice)) {
            return true;
        }
        return false;
    }
}
