package UI;
import game.FakeConsole;
import game.GameEnd;
import game.Move;
import game.Rules;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

public class RealUserInterfaceTest {
    private RealUserInterface realUserInterface;
    private FakeConsole fakeConsole;

    @Before
    public void setup() {
        fakeConsole = new FakeConsole();
        FakeLanguage fakeLanguage = new FakeLanguage();
        realUserInterface = new RealUserInterface(fakeConsole, new LanguageFactory() {
            @Override
            public Language generateLanguage(String userChoice) {
                return fakeLanguage;
            }

            @Override
            public Language defaultLanguage() {
                return fakeLanguage;
            }
        });
    }

    @Test
    public void communicateWinner() {
        realUserInterface.communicateWinner(GameEnd.COMPUTER_WIN);
        assertEquals("\n\nWinner", fakeConsole.messagePrinted());
    }

    @Test
    public void showComputerChoice() {
        realUserInterface.showComputerChoice(Move.ROCK);
        assertEquals("Computer choice:rock", fakeConsole.messagePrinted());
    }

    @Test
    public void sayGoodByeToUser() {
        realUserInterface.sayBye();
        assertEquals("Bye", fakeConsole.messagePrinted());
    }

    @Test
    public void getUserInputRock() {
        fakeConsole.provideUserChoice("1");
        assertEquals(Move.ROCK, realUserInterface.humanChoice());
    }

    @Test
    public void getUserInputScissors() {
        fakeConsole.provideUserChoice("2");
        assertEquals(Move.SCISSORS, realUserInterface.humanChoice());
    }

    @Test
    public void getUserInputPaper() {
        fakeConsole.provideUserChoice("3");
        assertEquals(Move.PAPER, realUserInterface.humanChoice());
    }

    @Test
    public void getUserInputExit() {
        fakeConsole.provideUserChoice("4");
        assertEquals(Move.EXIT, realUserInterface.humanChoice());
    }

    @Test
    public void returnUserSelection() {
        fakeConsole.provideUserChoice("1");
        assertEquals(Move.ROCK, realUserInterface.humanChoice());
    }

    @Test
    public void communicateDraw() {
        realUserInterface.communicateWinner(GameEnd.DRAW);
        assertEquals("\n\nDraw", fakeConsole.messagePrinted());

    }

    @Test
    public void communicateWinnerHuman() {
        realUserInterface.communicateWinner(GameEnd.COMPUTER_WIN);
        assertEquals("\n\nWinner", fakeConsole.messagePrinted());

    }

    @Test
    public void asksUserForLanguagePreference() {
        fakeConsole.provideUserChoice("2");
        realUserInterface.chooseLanguage();
        assertEquals("Language", fakeConsole.messagePrinted());
    }

    @Test
    public void givenALanguageChoiceCallsTheLanguageFactoryWithTheSameChoice() {
        class LanguageFactorySpy extends LanguageFactory {
            private boolean generateLanguageCall = false;

            @Override
            public Language generateLanguage(String userChoice) {
                generateLanguageCall = true;
                return null;
            }

            public boolean hasGenerateLanguageBeenCalled() {
                return generateLanguageCall;
            }
        }

        LanguageFactorySpy languageFactorySpy = new LanguageFactorySpy();
        RealUserInterface realUserInterface = new RealUserInterface(fakeConsole, languageFactorySpy);

        fakeConsole.provideUserChoice("2");
        realUserInterface.chooseLanguage();

        assertTrue(languageFactorySpy.hasGenerateLanguageBeenCalled());
    }
}