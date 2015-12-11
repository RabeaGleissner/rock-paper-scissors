package game;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class RulesTest {

    @Test
    public void computerChoicePaperWins() {
        Move humanMove = Move.ROCK;
        Move computerMove = Move.PAPER;
        Rules rules = new Rules(humanMove, computerMove);
        assertEquals(Winner.COMPUTER, rules.gameEndState());
    }

    @Test
    public void humanChoicePaperWins() {
        Move computerMove = Move.ROCK;
        Move humanMove = Move.PAPER;
        Rules rules = new Rules(humanMove, computerMove);
        assertEquals(Winner.HUMAN, rules.gameEndState());
    }

    @Test
    public void computerChoiceRockWins() {
        Move computerMove = Move.ROCK;
        Move humanMove = Move.SCISSORS;
        Rules rules = new Rules(humanMove, computerMove);
        assertEquals(Winner.COMPUTER, rules.gameEndState());
    }

    @Test
    public void humanChoiceRockWins() {
        Move humanMove = Move.ROCK;
        Move computerMove = Move.SCISSORS;
        Rules rules = new Rules(humanMove, computerMove);
        assertEquals(Winner.HUMAN, rules.gameEndState());
    }

    @Test
    public void computerChoiceScissorsWins() {
        Move humanMove = Move.PAPER;
        Move computerMove = Move.SCISSORS;
        Rules rules = new Rules(humanMove, computerMove);
        assertEquals(Winner.COMPUTER, rules.gameEndState());
    }

    @Test
    public void humanChoiceScissorsWins() {
        Move humanMove = Move.SCISSORS;
        Move computerMove = Move.PAPER;
        Rules rules = new Rules(humanMove, computerMove);
        assertEquals(Winner.HUMAN, rules.gameEndState());
    }

    @Test
    public void drawWithPaper() {
        Rules rules = new Rules(Move.PAPER, Move.PAPER);
        assertEquals(Winner.DRAW, rules.gameEndState());
    }

    @Test
    public void errorMessage() {
        Rules rules = new Rules(Move.EXIT, Move.PAPER);
        assertEquals(null, rules.gameEndState());
    }
}