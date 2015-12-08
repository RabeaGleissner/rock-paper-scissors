package game;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RulesTest {


    @Test
    public void computerChoicePaperWins() {
        Rules rules = new Rules(Move.ROCK, Move.PAPER);
        assertEquals("computer", rules.findWinner());
    }

    @Test
    public void humanChoicePaperWins() {
        Rules rules = new Rules(Move.PAPER, Move.ROCK);
        assertEquals("human", rules.findWinner());
    }

    @Test
    public void computerChoiceRockWins() {
        Rules rules = new Rules(Move.SCISSORS, Move.ROCK);
        assertEquals("computer", rules.findWinner());
    }

    @Test
    public void humanChoiceRockWins() {
        Rules rules = new Rules(Move.ROCK, Move.SCISSORS);
        assertEquals("human", rules.findWinner());
    }

    @Test
    public void computerChoiceScissorsWins() {
        Rules rules = new Rules(Move.PAPER, Move.SCISSORS);
        assertEquals("computer", rules.findWinner());
    }

    @Test
    public void humanChoiceScissorsWins() {
        Rules rules = new Rules(Move.SCISSORS, Move.PAPER);
        assertEquals("human", rules.findWinner());
    }

    @Test
    public void drawWithPaper() {
        Rules rules = new Rules(Move.PAPER, Move.PAPER);
        assertEquals("draw", rules.findWinner());
    }

    @Test
    public void errorMessage() {
        Rules rules = new Rules(Move.EXIT, Move.PAPER);
        assertEquals("something went wrong", rules.findWinner());
    }
}