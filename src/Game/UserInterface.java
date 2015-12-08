package game;

public interface UserInterface {
    String askForHumanChoice();
    String announceGameEnd(String winner);
    String showComputerChoice(String choice);
    String sayBye();
}