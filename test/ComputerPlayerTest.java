import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

public class ComputerPlayerTest {
    private ComputerPlayer computerPlayer;
    private FakeRandomizer fakeRandomizer;

    @Before
    public void setup() {
       fakeRandomizer = new FakeRandomizer();
       computerPlayer = new ComputerPlayer(fakeRandomizer);
    }

    @Test
    public void generatesMove() {
        fakeRandomizer.setFakeRandomMove("rock");
        assertTrue(
                ("rock").equals(computerPlayer.generateMove()) ||
                ("scissors").equals(computerPlayer.generateMove()) ||
                ("paper").equals(computerPlayer.generateMove())
        );
    }

    @Test
    public void generateRandomMove() {
        fakeRandomizer.setFakeRandomMove("rock");
        assertEquals("rock", computerPlayer.generateMove());
    }


}