import UI.English;
import game.ComputerPlayer;
import game.Game;
import UI.RealConsole;
import UI.UserInterface;
import game.RealRandomizer;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(new UserInterface(new RealConsole(), new English()), new ComputerPlayer(new RealRandomizer()));
        game.play();
    }
}
