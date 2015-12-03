public class FakeRandomizer implements Randomizer {

    private String randomMove;

    public FakeRandomizer() {
        randomMove = "";
    }

    public String getRandomMove() {
        return randomMove;
    }

    public void setFakeRandomMove(String move) {
        randomMove = move;
    }

}
