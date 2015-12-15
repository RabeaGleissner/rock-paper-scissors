package game;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FakeUserInterface implements UserInterface {

    public boolean communicateWinnerWasCalled = false;
    public boolean sayByeWasCalled = false;
    private List<UserChoice> moves = new LinkedList<>();
    public boolean chooseLanguageWasCalled = false;
    public GameEnd gameEnd = null;

    public UserChoice humanChoice() {
      return moves.remove(0);
    }

    public void communicateWinner(GameEnd gameEnd) {
        communicateWinnerWasCalled = true;
        this.gameEnd = gameEnd;
    }

    public void sayBye() {
        sayByeWasCalled = true;
    }

    @Override
    public void chooseLanguage() {
        chooseLanguageWasCalled = true;
    }

    @Override
    public void showComputerChoice(Move choice) {
    }

    public void plays(UserChoice... userChoices) {
        moves.addAll(Arrays.asList(userChoices));
    }

    public void userWantsToExit() {
        UserChoice userChoice = new UserChoice(null, GameControls.EXIT);
        moves.add(userChoice.addGameControl(GameControls.EXIT));
    }

    public boolean computerHasWon() {
        return gameEnd == GameEnd.COMPUTER_WIN;
    }
}
