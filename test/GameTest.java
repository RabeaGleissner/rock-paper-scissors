import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {

    private FakeConsole fakeConsole;
    private Game game;
    private ComputerPlayer computerPlayer;
    private FakeRandomizer fakeRandomizer;


    @Before
    public void setup() {
        fakeConsole = new FakeConsole();
        fakeRandomizer = new FakeRandomizer();
        UserInterface userInterface = new UserInterface();
        computerPlayer = new ComputerPlayer(fakeRandomizer);
        game = new Game(fakeConsole, userInterface, computerPlayer);
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

    @Test
    public void asksPlayerForInputAndReturnsChoice() {
        fakeConsole.provideUserChoice("R");
        assertEquals(Move.ROCK, game.askPlayerAndReturnChoice());
    }

    @Test
    public void playsOneRound() {
        fakeRandomizer.setFakeRandomMove(Move.ROCK);
        game.playOnce(Move.PAPER);
        assertEquals("Winner: human", fakeConsole.messagePrinted());
    }
}