import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class UserInterfaceTest {
    private UserInterface userInterface;

    @Before
    public void setup() {
        userInterface = new UserInterface();
    }

    @Test
    public void askForHumanChoice() {
        assertEquals("Please enter your choice: (R = rock, S = scissors, P = paper) or type E for exit",
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
}