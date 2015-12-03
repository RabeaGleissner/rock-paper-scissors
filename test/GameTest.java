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
    public void getUserInputRock() {
        fakeConsole.provideUserChoice("R");
        assertEquals(Move.ROCK, game.getUserInput());
    }

    @Test
    public void getUserInputScissors() {
        fakeConsole.provideUserChoice("S");
        assertEquals(Move.SCISSORS, game.getUserInput());
    }

    @Test
    public void getUserInputPaper() {
        fakeConsole.provideUserChoice("P");
        assertEquals(Move.PAPER, game.getUserInput());
    }

    @Test
    public void getUserInputExit() {
        fakeConsole.provideUserChoice("E");
        assertEquals(Move.EXIT, game.getUserInput());
    }

    @Test
    public void printMessageToConsole() {
        game.print("winner");
        assertEquals("winner", fakeConsole.messagePrinted());
    }
}
