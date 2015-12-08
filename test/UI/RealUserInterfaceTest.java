package UI;
import game.FakeConsole;
import game.Move;
import game.Rules;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class RealUserInterfaceTest {
    private RealUserInterface realUserInterface;
    private FakeConsole fakeConsole;
    private English english;

    @Before
    public void setup() {
        fakeConsole = new FakeConsole();
        english = new English();
        realUserInterface = new RealUserInterface(fakeConsole, english);
    }

    @Test
    public void showComputerChoice() {
        realUserInterface.communicateWinner(Move.ROCK, new Rules(Move.PAPER, Move.ROCK));
        assertEquals("Computer choice was: ROCK\n\nWinner: human", fakeConsole.messagePrinted());
    }

    @Test
    public void sayGoodByeToUser() {
        realUserInterface.sayBye();
        assertEquals("See you next time!", fakeConsole.messagePrinted());
    }

    @Test
    public void getUserInputRock() {
        fakeConsole.provideUserChoice("R");
        assertEquals(Move.ROCK, realUserInterface.humanChoice());
    }

    @Test
    public void getUserInputScissors() {
        fakeConsole.provideUserChoice("S");
        assertEquals(Move.SCISSORS, realUserInterface.humanChoice());
    }

    @Test
    public void getUserInputPaper() {
        fakeConsole.provideUserChoice("P");
        assertEquals(Move.PAPER, realUserInterface.humanChoice());
    }

    @Test
    public void getUserInputExit() {
        fakeConsole.provideUserChoice("E");
        assertEquals(Move.EXIT, realUserInterface.humanChoice());
    }

    @Test
    public void returnUserSelection() {
        fakeConsole.provideUserChoice("R");
        assertEquals(Move.ROCK, realUserInterface.humanChoice());
    }

    @Test
    public void communicateDraw() {
        realUserInterface.communicateWinner(Move.ROCK, new Rules(Move.ROCK, Move.ROCK));
        assertEquals("Computer choice was: ROCK\n\nIt's a draw!", fakeConsole.messagePrinted());

    }

    @Test
    public void communicateWinnerHuman() {
        realUserInterface.communicateWinner(Move.ROCK, new Rules(Move.PAPER, Move.ROCK));
        assertEquals("Computer choice was: ROCK\n\nWinner: human", fakeConsole.messagePrinted());

    }
}