package game;

public class Exit implements UserChoice {

    @Override
    public Move getMove() {
        return null;
    }

    @Override
    public boolean userQuits() {
        return true;
    }

}
