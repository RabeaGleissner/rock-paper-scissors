import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameTest {

    private FakeConsole fakeConsole;
    private Game game;

    @Before
    public void setup() {
        fakeConsole = new FakeConsole();
        game = new Game(fakeConsole);
    }

    @Test
    public void getUserInput() {
        fakeConsole.provideUserChoice("rock");
        assertEquals("rock", game.getUserInput());
    }

    @Test
    public void printMessageToConsole() {
        game.print("winner");
        assertEquals("winner", fakeConsole.messagePrinted());
    }

}
