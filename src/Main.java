import game.ComputerPlayer;
import game.Game;
import UI.RealConsole;
import UI.UserInterfaceEngl;
import game.RealRandomizer;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(new UserInterfaceEngl(new RealConsole()), new ComputerPlayer(new RealRandomizer()));
        game.play();
    }
}
