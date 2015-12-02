import org.junit.Before;
import org.junit.Test;
import org.junit.runner.Computer;

import static org.junit.Assert.*;

public class ComputerPlayerTest {
    private ComputerPlayer computerPlayer;

    @Before
    public void setup() {
       computerPlayer = new ComputerPlayer();
    }

    @Test
    public void generatesMove() {
        assertTrue(
                ("rock").equals(computerPlayer.generateMove()) ||
                ("scissors").equals(computerPlayer.generateMove()) ||
                ("paper").equals(computerPlayer.generateMove())
        );
    }
}