package game;

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
        fakeRandomizer.setFakeRandomMove(Move.ROCK);
        assertTrue(
                (Move.ROCK).equals(computerPlayer.generateMove()) ||
                (Move.SCISSORS).equals(computerPlayer.generateMove()) ||
                (Move.PAPER).equals(computerPlayer.generateMove())
        );
    }

    @Test
    public void generateRandomMove() {
        fakeRandomizer.setFakeRandomMove(Move.ROCK);
        assertEquals(Move.ROCK, computerPlayer.generateMove());
    }


}