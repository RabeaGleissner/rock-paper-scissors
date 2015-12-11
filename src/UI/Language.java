package UI;

import game.Move;
import game.GameEnd;

public interface Language {
    String userPrompt();
    String draw();
    String winner(GameEnd gameEnd);
    String computerChoice();
    String goodbye();
    String languagePreference();
    String communicateComputerChoice(Move computerChoice);
}
