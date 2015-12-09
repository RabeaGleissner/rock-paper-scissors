package UI;

import game.Winner;

public class EnglishLanguage implements Language {
    final String PROMPT = "Please enter your choice: (1 = rock, 2 = scissors, 3 = paper) or type 4 for exit";
    final String DRAW = "It's a draw!";
    final String WINNER = "Winner: ";
    final String COMPUTER_CHOICE = "Computer choice was: ";
    final String GOODBYE = "See you next time!";
    final String LANGUAGE_PREFERENCE = "Which language would you like to use? Type E for English and D for Deutsch.";
    final String COMPUTER = "Computer";
    final String HUMAN = "User";
    final String NEW_LINE = "\n\n";

    public String userPrompt() {
        return NEW_LINE + PROMPT;
    }

    public String draw() {
       return NEW_LINE + DRAW;
    }

    public String winner(Winner winner) {
        if (winner == Winner.HUMAN) {
            return NEW_LINE + WINNER + HUMAN;
        } else {
            return NEW_LINE + WINNER + COMPUTER;
        }
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
