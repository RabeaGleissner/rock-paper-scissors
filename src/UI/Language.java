package UI;

import game.Move;
import game.Winner;

public interface Language {
    String userPrompt();
    String draw();
    String winner(Winner winner);
    String computerChoice();
    String goodbye();
    String languagePreference();
    String communicateComputerChoice(Move computerChoice);
}
