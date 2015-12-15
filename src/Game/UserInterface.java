package game;

public interface UserInterface {
    UserChoice humanChoice();
    void communicateWinner(GameEnd gameEnd);
    void sayBye();
    void chooseLanguage();
    void showComputerChoice(Move choice);
}