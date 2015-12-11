package UI;

import game.GameEnd;
import game.Move;

public class FakeLanguage implements Language{
    final String SCISSORS = "scissors";
    final String PAPER = "paper";
    final String ROCK = "rock";
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
    public String winner(GameEnd gameEnd) {
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
