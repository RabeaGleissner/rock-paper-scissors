package game;

public class UserChoice {
    private Move move;
    private GameControls terminate;

    public UserChoice(Move move, GameControls terminate) {
        this.move = move;
        this.terminate = terminate;
    }

    public Move getMove() {
        return move;
    }

    public GameControls getTerminate() {
        return terminate;
    }

    public UserChoice addNewMove(Move move) {
        return new UserChoice(move, null);
    }

    public UserChoice addGameControl(GameControls selection) {
        return new UserChoice(null, selection);
    }
}
