public class Game {

    private final FakeConsole fakeConsole;

    public Game(FakeConsole fakeConsole) {
        this.fakeConsole = fakeConsole;
    }

    public String getUserInput() {
        return fakeConsole.read();
    }

    public void print(String message) {
        fakeConsole.print(message);
    }

    public String findWinner(String humanChoice, String computerChoice) {
        String winner = "";

        if ( paperWinRules(humanChoice, computerChoice) ) {
            winner = "paper";
        } else if (rockWinRules(humanChoice, computerChoice)) {
            winner = "rock";
        } else if (scissorWinRules(humanChoice, computerChoice)) {
           winner = "scissors";
        }

        if (winner == humanChoice) {
            return "human";
        } else if (winner == computerChoice) {
            return "computer";
        } else {
            return "draw";
        }
    }

    private boolean paperWinRules(String humanChoice, String computerChoice) {
       if ( (humanChoice == "rock" && computerChoice == "paper") ||
                (humanChoice == "paper" && computerChoice == "rock") ) {
           return true;
       }
        return false;
    }

    private boolean rockWinRules(String humanChoice, String computerChoice) {
        if ( (humanChoice == "rock" && computerChoice == "scissors") ||
                (humanChoice == "scissors" && computerChoice == "rock") ) {
            return true;
        }
        return false;
    }

    private boolean scissorWinRules(String humanChoice, String computerChoice) {
        if ( (humanChoice == "paper" && computerChoice == "scissors") ||
                (humanChoice == "scissors" && computerChoice == "paper") ) {
            return true;
        }
        return false;
    }
}
