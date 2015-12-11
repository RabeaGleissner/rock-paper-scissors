package UI;

import game.Move;
import game.Winner;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EnglishLanguageTest {
    EnglishLanguage english;

    @Before
    public void setup() {
        english = new EnglishLanguage();
    }

    @Test
    public void userPrompt() {
        assertEquals("\n\nPlease enter your choice: (1 = rock, 2 = scissors, 3 = paper) or type 4 for exit", english.userPrompt());

    }

    @Test
    public void draw() {
        assertEquals("\n\nIt's a draw!", english.draw());

    }

    @Test
    public void winner() {
        assertEquals("\n\nWinner: Computer", english.winner(Winner.COMPUTER));

    }

    @Test
    public void computerChoice() {
        assertEquals("Computer choice was: ", english.computerChoice());

    }

    @Test
    public void goodbye() {
        assertEquals("See you next time!", english.goodbye());

    }

    @Test
    public void languagePreference() {
        assertEquals("Which language would you like to use? Type 1 for English and 2 for Deutsch.", english.languagePreference());

    }

    @Test
    public void communicateComputerChoice() {
        assertEquals("paper", english.communicateComputerChoice(Move.PAPER));

    }
}