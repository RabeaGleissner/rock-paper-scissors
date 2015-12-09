package UI;

import game.Winner;

public class FakeLanguage implements Language{
    final String PROMPT = "Prompt";
    final String DRAW = "Draw";
    final String WINNER = "Winner";
    final String COMPUTER_CHOICE = "Computer choice:";
    final String GOODBYE = "Bye";
    final String LANGUAGE_PREFERENCE = "Language";
    final String NEW_LINE = "\n\n";

    @Override
    public String userPrompt() {
        return NEW_LINE + PROMPT;
    }

    @Override
    public String draw() {
        return NEW_LINE + DRAW;
    }

    @Override
    public String winner(Winner winner) {
        return NEW_LINE + WINNER;
    }

    @Override
    public String computerChoice() {
        return COMPUTER_CHOICE;
    }

    @Override
    public String goodbye() {
        return GOODBYE;
    }

    @Override
    public String languagePreference() {
        return LANGUAGE_PREFERENCE;
    }
}
