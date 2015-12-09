package UI;

public class EnglishLanguage implements Language {
    String PROMPT = "\nPlease enter your choice: (1 = rock, 2 = scissors, 3 = paper) or type 4 for exit";
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
