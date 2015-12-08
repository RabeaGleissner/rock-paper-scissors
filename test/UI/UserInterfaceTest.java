package UI;
import game.FakeConsole;
import game.Move;
import game.Rules;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class UserInterfaceTest {
    private UserInterface userInterface;
    private FakeConsole fakeConsole;
    private English english;

    @Before
    public void setup() {
        fakeConsole = new FakeConsole();
        english = new English();
        userInterface = new UserInterface(fakeConsole, english);
    }

    @Test
    public void showComputerChoice() {
        userInterface.communicateWinner(Move.ROCK, new Rules(Move.PAPER, Move.ROCK));
        assertEquals("Computer choice was: ROCK\n\nWinner: human", fakeConsole.messagePrinted());
    }

    @Test
    public void sayGoodByeToUser() {
        userInterface.sayBye();
        assertEquals("See you next time!", fakeConsole.messagePrinted());
    }

    @Test
    public void getUserInputRock() {
        fakeConsole.provideUserChoice("R");
        assertEquals(Move.ROCK, userInterface.humanChoice());
    }

    @Test
    public void getUserInputScissors() {
        fakeConsole.provideUserChoice("S");
        assertEquals(Move.SCISSORS, userInterface.humanChoice());
    }

    @Test
    public void getUserInputPaper() {
        fakeConsole.provideUserChoice("P");
        assertEquals(Move.PAPER, userInterface.humanChoice());
    }

    @Test
    public void getUserInputExit() {
        fakeConsole.provideUserChoice("E");
        assertEquals(Move.EXIT, userInterface.humanChoice());
    }

    @Test
    public void returnUserSelection() {
        fakeConsole.provideUserChoice("R");
        assertEquals(Move.ROCK, userInterface.humanChoice());
    }

    @Test
    public void communicateDraw() {
        userInterface.communicateWinner(Move.ROCK, new Rules(Move.ROCK, Move.ROCK));
        assertEquals("Computer choice was: ROCK\n\nIt's a draw!", fakeConsole.messagePrinted());

    }

    @Test
    public void communicateWinnerHuman() {
        userInterface.communicateWinner(Move.ROCK, new Rules(Move.PAPER, Move.ROCK));
        assertEquals("Computer choice was: ROCK\n\nWinner: human", fakeConsole.messagePrinted());

    }
}