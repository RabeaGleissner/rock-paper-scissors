package game;
import UI.English;
import UI.UserInterface;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {

    private FakeConsole fakeConsole;
    private Game game;
    private FakeRandomizer fakeRandomizer;
    private English english;


    @Before
    public void setup() {
        fakeConsole = new FakeConsole();
        fakeRandomizer = new FakeRandomizer();
        english = new English();
        UserInterface userInterface = new UserInterface(fakeConsole, english);
        ComputerPlayer computerPlayer = new ComputerPlayer(fakeRandomizer);
        game = new Game(userInterface, computerPlayer);
    }

    @Test
    public void playsOneRound() {
        fakeRandomizer.setFakeRandomMove(Move.ROCK);
        game.announceWinner(Move.PAPER);
        assertEquals("Computer choice was: ROCK\n\nWinner: human", fakeConsole.messagePrinted());
    }

    @Test
    public void nothingIsPrintedIfUserExits() {
        fakeConsole.provideUserChoice("E");
        game.play();
        assertEquals("See you next time!", fakeConsole.messagePrinted());
    }
}