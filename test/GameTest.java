import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameTest {

    private FakeConsole fakeConsole;
    private Game game;

    @Before
    public void setup() {
        fakeConsole = new FakeConsole();
        game = new Game(fakeConsole);
    }

    @Test
    public void getUserInput() {
        fakeConsole.provideUserChoice("rock");
        assertEquals("rock", game.getUserInput());
    }

    @Test
    public void printMessageToConsole() {
        game.print("winner");
        assertEquals("winner", fakeConsole.messagePrinted());
    }

    @Test
    public void computerChoicePaperWins() {
        String humanChoice = "rock";
        String computerChoice = "paper";
        assertEquals("computer", game.findWinner(humanChoice, computerChoice));
    }

    @Test
    public void humanChoicePaperWins() {
        String humanChoice = "paper";
        String computerChoice = "rock";
        assertEquals("human", game.findWinner(humanChoice, computerChoice));
    }

    @Test
    public void computerChoiceRockWins() {
        String humanChoice = "scissors";
        String computerChoice = "rock";
        assertEquals("computer", game.findWinner(humanChoice, computerChoice));
    }

    @Test
    public void humanChoiceRockWins() {
        String humanChoice = "rock";
        String computerChoice = "scissors";
        assertEquals("human", game.findWinner(humanChoice, computerChoice));
    }

    @Test
    public void computerChoiceScissorsWins() {
        String humanChoice = "paper";
        String computerChoice = "scissors";
        assertEquals("computer", game.findWinner(humanChoice, computerChoice));
    }

    @Test
    public void humanChoiceScissorsWins() {
        String humanChoice = "scissors";
        String computerChoice = "paper";
        assertEquals("human", game.findWinner(humanChoice, computerChoice));
    }

    @Test
    public void drawWithPaper() {
        String humanChoice = "paper";
        String computerChoice = "paper";
        assertEquals("draw", game.findWinner(humanChoice, computerChoice));
    }
}
