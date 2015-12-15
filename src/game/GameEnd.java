package game;

public enum GameEnd {
    HUMAN_WIN,
    COMPUTER_WIN,
    DRAW;

    public boolean isDraw() {
        return this == DRAW;
    }
}
