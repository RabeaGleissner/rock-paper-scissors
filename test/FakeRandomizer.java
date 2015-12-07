public class FakeRandomizer implements Randomizer {

    private Move randomMove;

    public FakeRandomizer() {
        randomMove = null;
    }

    public Move getRandomMove() {
        return randomMove;
    }

    public void setFakeRandomMove(Move move) {
        randomMove = move;
    }

}
