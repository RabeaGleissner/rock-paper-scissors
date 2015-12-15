package game;

public interface UserInterface {
    Move humanChoice();
    void communicateWinner(Move computerChoice, GameEnd gameEnd);
    void sayBye();
    void chooseLanguage();
}