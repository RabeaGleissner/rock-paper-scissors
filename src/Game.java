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
        }

        if (winner == humanChoice) {
            return "human";
        } else if (winner == computerChoice) {
            return "computer";
        } else {
            return "something went wrong";
        }
    }

    private boolean paperWinRules(String humanChoice, String computerChoice) {
       if ( (humanChoice == "rock" && computerChoice == "paper") ||
                (humanChoice == "paper" && computerChoice == "rock") ) {
           return true;
       }
        return false;
    }
}
