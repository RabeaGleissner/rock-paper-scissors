package UI;
import game.*;

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

    public void communicateWinner(GameEnd gameEnd) {
        print(announceGameEnd(gameEnd));
    }

    public UserChoice humanChoice() {
        print(askForHumanChoice());
        return getUserInput();
    }

    public void showComputerChoice(Move choice) {
        print(language.communicateComputerChoice() + language.translateComputerChoice(choice));
    }

    private UserChoice getUserInput() {
        String move = readUserInput();
        UserChoice convertedMove = convertUserInputToEnum(move);

        if (convertedMove == null) {
            return humanChoice();
        } else {
            return convertedMove;
        }
    }

    private UserChoice convertUserInputToEnum(String move) {
        UserChoice userChoice = new UserChoice(null, null);
        switch (move) {
            case "1": return new UserChoice.MoveChoice(Move.ROCK);
            case "2": return new UserChoice.MoveChoice(Move.SCISSORS);
            case "3": return new UserChoice.MoveChoice(Move.PAPER);
            case "4": return new UserChoice.Exit(GameControls.EXIT);
            default:
                return userChoice;
        }
    }

    private String readUserInput() {
        return console.read();
    }

    private String askForHumanChoice() {
        return language.userPrompt();
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


