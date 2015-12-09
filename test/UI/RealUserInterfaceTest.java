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

    @Before
    public void setup() {
        fakeConsole = new FakeConsole();
        FakeLanguage fakeLanguage = new FakeLanguage();
        realUserInterface = new RealUserInterface(fakeConsole, fakeLanguage);
    }

    @Test
    public void showComputerChoice() {
        realUserInterface.communicateWinner(Move.ROCK, new Rules(Move.PAPER, Move.ROCK));
        assertEquals("Computer choice:ROCK\n\nWinner", fakeConsole.messagePrinted());
    }

    @Test
    public void sayGoodByeToUser() {
        realUserInterface.sayBye();
        assertEquals("Bye", fakeConsole.messagePrinted());
    }

    @Test
    public void getUserInputRock() {
        fakeConsole.provideUserChoice("1");
        assertEquals(Move.ROCK, realUserInterface.humanChoice());
    }

    @Test
    public void getUserInputScissors() {
        fakeConsole.provideUserChoice("2");
        assertEquals(Move.SCISSORS, realUserInterface.humanChoice());
    }

    @Test
    public void getUserInputPaper() {
        fakeConsole.provideUserChoice("3");
        assertEquals(Move.PAPER, realUserInterface.humanChoice());
    }

    @Test
    public void getUserInputExit() {
        fakeConsole.provideUserChoice("4");
        assertEquals(Move.EXIT, realUserInterface.humanChoice());
    }

    @Test
    public void returnUserSelection() {
        fakeConsole.provideUserChoice("1");
        assertEquals(Move.ROCK, realUserInterface.humanChoice());
    }

    @Test
    public void communicateDraw() {
        realUserInterface.communicateWinner(Move.ROCK, new Rules(Move.ROCK, Move.ROCK));
        assertEquals("Computer choice:ROCK\n\nDraw", fakeConsole.messagePrinted());

    }

    @Test
    public void communicateWinnerHuman() {
        realUserInterface.communicateWinner(Move.ROCK, new Rules(Move.PAPER, Move.ROCK));
        assertEquals("Computer choice:ROCK\n\nWinner", fakeConsole.messagePrinted());

    }
}