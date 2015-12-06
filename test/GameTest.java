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
        String userPrompt = "\nPlease enter your choice: (R = rock, S = scissors, P = paper) or type E for exit";
        fakeConsole.provideUserChoice("R");
        assertEquals(Move.ROCK, game.askPlayerAndReturnChoice());
        assertEquals(userPrompt, fakeConsole.messagePrinted());
    }

    @Test
    public void playsOneRound() {
        fakeRandomizer.setFakeRandomMove(Move.ROCK);
        game.playOnce(Move.PAPER);
        assertEquals("Winner: human", fakeConsole.messagePrinted());
    }

    @Test
    public void nothingIsPrintedIfUserExits() {
        fakeConsole.provideUserChoice("E");
        game.play();
        assertEquals("See you next time!", fakeConsole.messagePrinted());
    }
}