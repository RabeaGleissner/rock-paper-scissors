package UI;
import game.Console;
import game.GameEnd;
import game.Move;
import game.UserInterface;

public class RealUserInterface implements UserInterface {

    private final Console console;
    private Language language;
    private LanguageFactory languageFactory;

    public RealUserInterface(Console console, LanguageFactory languageFactory) {
        this.console = console;
        this.languageFactory = languageFactory;
        this.language = languageFactory.defaultLanguage();
    }


    public void sayBye() {
        print(goodbye());
    }

    public void communicateWinner(Move computerChoice, GameEnd gameEnd) {
        print(showComputerChoice(language.communicateComputerChoice(computerChoice)) + announceGameEnd(gameEnd));
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

    private String announceGameEnd(GameEnd gameEnd) {
        if (gameEnd == GameEnd.DRAW) {
            return language.draw();
        } else {
            return language.winner(gameEnd);
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
        this.language = languageFactory.generateLanguage(readUserInput());
    }

}


