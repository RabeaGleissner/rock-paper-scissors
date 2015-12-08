package UI;
import game.FakeConsole;
import game.Move;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class UserInterfaceEnglTest {
    private UserInterfaceEngl userInterface;
    private FakeConsole fakeConsole;

    @Before
    public void setup() {
        fakeConsole = new FakeConsole();
        userInterface = new UserInterfaceEngl(fakeConsole);
    }

    @Test
    public void askForHumanChoice() {
        assertEquals("\nPlease enter your choice: (R = rock, S = scissors, P = paper) or type E for exit",
                userInterface.askForHumanChoice());
    }

    @Test
    public void announceGameDrawn() {
        assertEquals("It's a draw!", userInterface.announceGameEnd("draw"));
    }

    @Test
    public void announceHumanAsWinner() {
        assertEquals("Winner: human", userInterface.announceGameEnd("human"));
    }

    @Test
    public void announceComputerAsWinner() {
        assertEquals("Winner: computer", userInterface.announceGameEnd("computer"));
    }

    @Test
    public void showComputerChoice() {
        assertEquals("Computer choice was: rock", userInterface.showComputerChoice("rock"));
    }

    @Test
    public void sayGoodBye() {
        assertEquals("See you next time!", userInterface.goodbye());
    }

    @Test
    public void getUserInputRock() {
        fakeConsole.provideUserChoice("R");
        assertEquals(Move.ROCK, userInterface.getUserInput());
    }

    @Test
    public void getUserInputScissors() {
        fakeConsole.provideUserChoice("S");
        assertEquals(Move.SCISSORS, userInterface.getUserInput());
    }

    @Test
    public void getUserInputPaper() {
        fakeConsole.provideUserChoice("P");
        assertEquals(Move.PAPER, userInterface.getUserInput());
    }

    @Test
    public void getUserInputExit() {
        fakeConsole.provideUserChoice("E");
        assertEquals(Move.EXIT, userInterface.getUserInput());
    }

}