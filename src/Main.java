import UI.EnglishLanguage;
import UI.RealConsole;
import UI.RealUserInterface;
import game.ComputerPlayer;
import game.Game;
import game.RealRandomizer;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(new RealUserInterface(new RealConsole(), new EnglishLanguage()), new ComputerPlayer(new RealRandomizer()));
        game.play();
    }
}
