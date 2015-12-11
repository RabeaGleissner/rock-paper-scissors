package UI;

import game.GameEnd;
import game.Move;

public class EnglishLanguage implements Language {
    final String SCISSORS = "scissors";
    final String PAPER = "paper";
    final String ROCK = "rock";
    final String PROMPT = "Please enter your choice: (1 = rock, 2 = scissors, 3 = paper) or type 4 for exit";
    final String DRAW = "It's a draw!";
    final String WINNER = "Winner: ";
    final String COMPUTER_CHOICE = "Computer choice was: ";
    final String GOODBYE = "See you next time!";
    final String LANGUAGE_PREFERENCE = "Which language would you like to use? Type 1 for English and 2 for Deutsch.";
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

    public String computerChoice() {
        return COMPUTER_CHOICE;
    }

    public String goodbye() {
        return GOODBYE;
    }

    public String languagePreference() {
        return LANGUAGE_PREFERENCE;
    }

    @Override
    public String communicateComputerChoice(Move computerChoice) {
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
