import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RulesTest {


    @Test
    public void computerChoicePaperWins() {
        Rules rules = new Rules("rock", "paper");
        assertEquals("computer", rules.findWinner());
    }

    @Test
    public void humanChoicePaperWins() {
        Rules rules = new Rules("paper", "rock");
        assertEquals("human", rules.findWinner());
    }

    @Test
    public void computerChoiceRockWins() {
        Rules rules = new Rules("scissors", "rock");
        assertEquals("computer", rules.findWinner());
    }

    @Test
    public void humanChoiceRockWins() {
        Rules rules = new Rules("rock", "scissors");
        assertEquals("human", rules.findWinner());
    }

    @Test
    public void computerChoiceScissorsWins() {
        Rules rules = new Rules("paper", "scissors");
        assertEquals("computer", rules.findWinner());
    }

    @Test
    public void humanChoiceScissorsWins() {
        Rules rules = new Rules("scissors", "paper");
        assertEquals("human", rules.findWinner());
    }

    @Test
    public void drawWithPaper() {
        Rules rules = new Rules("paper", "paper");
        assertEquals("draw", rules.findWinner());
    }

}