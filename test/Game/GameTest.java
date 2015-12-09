package game;
import org.junit.Before;
import org.junit.Test;

import static game.Move.EXIT;
import static game.Move.ROCK;
import static game.Move.SCISSORS;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GameTest {

    private Game game;
    private FakeUserInterface user;
    private FakeComputerPlayer computer;


    @Before
    public void setup() {
        user = new FakeUserInterface();
        computer = new FakeComputerPlayer();
        game = new Game(user, computer);
    }

    @Test
    public void playsOneRound() {
        game.announceWinner(Move.PAPER);
        assertEquals(true , user.communicateWinnerWasCalled);
    }

    @Test
    public void announcesHumanAsWinner() {
        user.plays(ROCK, EXIT);
        computer.plays(SCISSORS);
        game.play();
        assertTrue(user.sayByeWasCalled);
    }

    @Test
    public void exitWhenUserEntersE() {
        user.userWantsToExit();
        game.play();
        assertEquals(true, user.sayByeWasCalled);
    }

    @Test
    public void askUserForLanguagePreference() {
        user.userWantsToExit();
        game.play();
        assertTrue(user.chooseLanguageWasCalled);
    }

    public static class FakeComputerPlayer extends ComputerPlayer {
        private Move scissors;

        public FakeComputerPlayer() {
            super(null);
        }

        @Override
        public Move generateMove() {
            return scissors;
        }

        public void plays(Move scissors) {
            this.scissors = scissors;
        }
    }
}