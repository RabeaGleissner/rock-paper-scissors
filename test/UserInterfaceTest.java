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
        assertEquals("Please enter your choice: R = rock, S = scissors, P = paper",
                userInterface.askForHumanChoice());

    }
}