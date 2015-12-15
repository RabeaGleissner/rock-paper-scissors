package game;
import org.junit.Before;
import org.junit.Test;

import static game.Move.PAPER;
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
    public void announcesHumanAsWinner() {
        user.plays(new UserChoice.MoveChoice(Move.ROCK), new UserChoice.Exit(GameControls.EXIT));
        computer.plays(SCISSORS);
        game.play();
        assertTrue(user.sayByeWasCalled);
    }

    @Test
    public void announcesComputerAsWinner() {
        user.plays(new UserChoice.MoveChoice(Move.ROCK), new UserChoice.Exit(GameControls.EXIT));
        computer.plays(PAPER);
        game.play();
        assertTrue(user.computerHasWon());
    }

    @Test
    public void exitWhenUserAsksForExit() {
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
        private Move computerMove;

        public FakeComputerPlayer() {
            super(null);
        }

        @Override
        public Move generateMove() {
            return computerMove;
        }

        public void plays(Move scissors) {
            this.computerMove = scissors;
        }
    }

}