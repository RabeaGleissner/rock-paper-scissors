package game;

public interface UserInterface {
    String askForHumanChoice();
    String announceGameEnd(String winner);
    String showComputerChoice(String choice);
    String goodbye();
    void print(String message);
    Move askPlayerAndReturnChoice();
    Move getUserInput();
    void communicateWinner(Move computerChoice, Rules rules);
    void sayBye();
}