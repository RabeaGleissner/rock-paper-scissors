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

    boolean userQuits() {
        return GameControls.EXIT == getTerminate();
    }

    public static class MoveChoice extends UserChoice {
        public MoveChoice(Move move) {
            super(move, null);
       }
    }

    public static class Exit extends UserChoice {
        public Exit(GameControls terminate) {
            super(null, terminate);
        }
    }
}

