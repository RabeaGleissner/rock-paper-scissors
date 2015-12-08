package game;

public interface UserInterface {
    Move humanChoice();
    void communicateWinner(Move computerChoice, Rules rules);
    void sayBye();
}