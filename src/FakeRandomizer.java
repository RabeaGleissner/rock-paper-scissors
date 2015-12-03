public class FakeRandomizer implements Randomizer {

    private Enum randomMove;

    public FakeRandomizer() {
        randomMove = null;
    }

    public Enum getRandomMove() {
        return randomMove;
    }

    public void setFakeRandomMove(Enum move) {
        randomMove = move;
    }

}
