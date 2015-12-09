package UI;

public class GermanLanguage implements Language {

    final String PROMPT = "\nBitte gib eine der folgenden Zahlen ein: 1 = Stein, 2 = Schere, 3 = Papier, 4 = Abbrechen";
    final String DRAW = "\n\nUnentschieden!";
    final String WINNER = "\n\nGewinner: ";
    final String COMPUTER_CHOICE = "Der Computer hat folgendes gespielt: ";
    final String GOODBYE = "Bis zum nächsten Mal!";
    final String LANGUAGE_PREFERENCE = "Which language would you like to use? Type E for English and D for Deutsch.";


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

    public String languagePreference() {
        return LANGUAGE_PREFERENCE;
    }
}
