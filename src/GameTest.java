import org.junit.Test;
import static org.junit.Assert.*;

public class GameTest {

    @Test
    public void getUserInput() {
        FakeConsole fakeConsole = new FakeConsole();
        fakeConsole.provideUserChoice("rock");
        Game game = new Game(fakeConsole);
        assertEquals("rock", game.getUserInput());
    }

}
