package UI;

import game.GameEnd;
import game.Move;

public class GermanLanguage implements Language {
    final String SCISSORS = "Schere";
    final String PAPER = "Papier";
    final String ROCK = "Stein";
    final String PROMPT = "\nBitte gib eine der folgenden Zahlen ein: 1 = Stein, 2 = Schere, 3 = Papier, 4 = Abbrechen";
    final String DRAW = "\n\nUnentschieden!";
    final String WINNER = "\n\nGewinner: ";
    final String COMPUTER_CHOICE = "Der Computer hat folgendes gespielt: ";
    final String GOODBYE = "Bis zum nächsten Mal!";
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

    public String winner(GameEnd gameEnd) {
        if (gameEnd == GameEnd.HUMAN_WIN) {
            return NEW_LINE + WINNER + HUMAN;
        } else {
            return NEW_LINE + WINNER + COMPUTER;
        }
    }

    public String communicateComputerChoice() {
        return COMPUTER_CHOICE;
    }

    public String goodbye() {
        return GOODBYE;
    }

    public String languagePreference() {
        return LANGUAGE_PREFERENCE;
    }

    @Override
    public String translateComputerChoice(Move computerChoice) {
        String move;
        if (computerChoice == Move.ROCK) {
            move = ROCK;
        } else if (computerChoice == Move.PAPER) {
            move = PAPER;
        } else {
            move = SCISSORS;
        }
        return move;
    }
}
