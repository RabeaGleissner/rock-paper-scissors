package game;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ComputerPlayerTest {
    private ComputerPlayer computerPlayer;
    private FakeRandomizer fakeRandomizer;

    @Before
    public void setup() {
       fakeRandomizer = new FakeRandomizer();
       computerPlayer = new ComputerPlayer(fakeRandomizer);
    }

    @Test
    public void generateRandomMove() {
        fakeRandomizer.setFakeRandomMove(Move.ROCK);
        assertEquals(Move.ROCK, computerPlayer.generateMove());
    }


}