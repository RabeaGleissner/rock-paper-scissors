package UI;
import game.Console;
import game.Move;
import game.Rules;
import game.Winner;

public class RealUserInterface implements game.UserInterface {

    private final Console console;
    private Language language;

    public RealUserInterface(Console console, Language language) {
        this.console = console;
        this.language = language;
    }


    public void sayBye() {
        print(goodbye());
    }

    public void communicateWinner(Move computerChoice, Rules rules) {
        print(showComputerChoice(computerChoice.toString()) + announceGameEnd(rules.findWinner()));
    }

    public Move humanChoice() {
        print(askForHumanChoice());
        return getUserInput();
    }

    private Move getUserInput() {
        String move = readUserInput();
        Move convertedMove = convertUserInputToEnum(move);

        if (convertedMove == null) {
            return humanChoice();
        } else {
            return convertedMove;
        }
    }

    private Move convertUserInputToEnum(String move) {
        Move returnedMove = null;
        switch (move) {
            case "1": returnedMove = Move.ROCK;
                break;
            case "2": returnedMove = Move.SCISSORS;
                break;
            case "3": returnedMove = Move.PAPER;
                break;
            case "4": returnedMove = Move.EXIT;
                break;
        }
        return returnedMove;
    }

    private String readUserInput() {
        return console.read();
    }

    private String askForHumanChoice() {
        return language.userPrompt();
    }

    private String showComputerChoice(String choice) {
        return language.computerChoice()+ choice;
    }

    private String announceGameEnd(Winner winner) {
        if (winner == Winner.DRAW) {
            return language.draw();
        } else {
            return language.winner(winner);
        }
    }

    private void print(String message) {
        console.print(message);
    }

    private String goodbye() {
        return language.goodbye();
    }

    @Override
    public void chooseLanguage() {
        print(language.languagePreference());
        LanguageFactory languageFactory = new LanguageFactory();
        this.language = languageFactory.generateLanguage(readUserInput());
    }

}


