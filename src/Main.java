import UI.LanguageFactory;
import UI.RealConsole;
import UI.RealUserInterface;
import game.ComputerPlayer;
import game.Game;
import game.RandomCalc;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(new RealUserInterface(new RealConsole(), new LanguageFactory()), new ComputerPlayer(new RandomCalc()));
        game.play();
    }
}
