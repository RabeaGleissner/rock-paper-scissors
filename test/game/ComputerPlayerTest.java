package game;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ComputerPlayerTest {
    private ComputerPlayer computerPlayer;

    @Before
    public void setup() {
       computerPlayer = new ComputerPlayer(new FakeRandomCalc());
    }

    @Test
    public void generateRandomMove() {
        assertEquals(Move.ROCK, computerPlayer.generateMove());
    }


    private class FakeRandomCalc extends RandomCalc {
        @Override
        public int randomNumber(int moves) {
            return 0;
        }
    }
}