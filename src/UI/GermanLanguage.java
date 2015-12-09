package UI;

public class GermanLanguage implements Language {

    String PROMPT = "\nBitte gib eine der folgenden Zahlen ein: 1 = Stein, 2 = Schere, 3 = Papier, 4 = Abbrechen";
    String DRAW = "\n\nUnentschieden!";
    String WINNER = "\n\nGewinner: ";
    String COMPUTER_CHOICE = "Der Computer hat folgendes gespielt: ";
    String GOODBYE = "Bis zum nächsten Mal!";


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
