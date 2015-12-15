package game;

public class MoveChoice implements UserChoice {
    private final Move move;

    public MoveChoice(Move move) {
        this.move = move;
   }

    @Override
    public Move getMove() {
        return move;
    }

    @Override
    public boolean userQuits() {
        return false;
    }
}
