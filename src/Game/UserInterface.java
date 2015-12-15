package game;

public interface UserInterface {
    Move humanChoice();
    void communicateWinner(GameEnd gameEnd);
    void sayBye();
    void chooseLanguage();
    void showComputerChoice(Move choice);
}