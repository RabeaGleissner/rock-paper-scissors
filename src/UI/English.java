package UI;

public class English implements Language {
    String PROMPT = "\nPlease enter your choice: (R = rock, S = scissors, P = paper) or type E for exit";
    String DRAW = "\n\nIt's a draw!";
    String WINNER = "\n\nWinner: ";
    String COMPUTER_CHOICE = "Computer choice was: ";
    String GOODBYE = "See you next time!";

    public String userPrompt() {
        return PROMPT;
    }

    public String draw() {
       return DRAW;
    }

    public String winner() {
        return WINNER;
    }

    public String computerChoice() {
        return COMPUTER_CHOICE;
    }

    public String goodbye() {
        return GOODBYE;
    }
}
