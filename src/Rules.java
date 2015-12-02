public class Rules {

    private String humanChoice;
    private String computerChoice;

    public Rules(String humanChoice, String computerChoice) {
        this.humanChoice = humanChoice;
        this.computerChoice = computerChoice;
    }

    public String findWinner() {
        String winner = rules();

        if (winner == humanChoice) {
            return "human";
        } else if (winner == computerChoice) {
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
        if ( (humanChoice == "rock" && computerChoice == "paper") ||
                (humanChoice == "paper" && computerChoice == "rock") ) {
            return true;
        }
        return false;
    }

    private boolean rockWins() {
        if ( (humanChoice == "rock" && computerChoice == "scissors") ||
                (humanChoice == "scissors" && computerChoice == "rock") ) {
            return true;
        }
        return false;
    }

    private boolean scissorsWin() {
        if ( (humanChoice == "paper" && computerChoice == "scissors") ||
                (humanChoice == "scissors" && computerChoice == "paper") ) {
            return true;
        }
        return false;
    }

    private boolean draw() {
        if ( humanChoice == computerChoice) {
            return true;
        }
        return false;
    }
}
