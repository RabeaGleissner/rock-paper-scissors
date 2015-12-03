public class RealRandomizer implements Randomizer {

    public Enum getRandomMove() {
        return provideMove();
    }

    private Enum provideMove() {
        Enum[] options = {Move.ROCK, Move.PAPER, Move.SCISSORS};
        int index = (int) (Math.random() * options.length);
        return options[index];
    }
}
