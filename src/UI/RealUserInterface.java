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
        UserChoice userInput = null;
        UserChoice userChoice = new UserChoice(null, null);
        switch (move) {
            case "1": userInput = userChoice.addNewMove(Move.ROCK);
                break;
            case "2": userInput = userChoice.addNewMove(Move.SCISSORS);
                break;
            case "3": userInput = userChoice.addNewMove(Move.PAPER);
                break;
            case "4": userInput = userChoice.addGameControl(GameControls.EXIT);
                break;
        }
        return userInput;
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


