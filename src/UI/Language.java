package UI;

import game.Move;
import game.GameEnd;

public interface Language {
    String userPrompt();
    String draw();
    String winner(GameEnd gameEnd);
    String communicateComputerChoice();
    String goodbye();
    String languagePreference();
    String translateComputerChoice(Move computerChoice);
}
