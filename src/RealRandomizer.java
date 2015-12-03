public class RealRandomizer implements Randomizer {

    public String getRandomMove() {
        return provideMove();
    }

    private String provideMove() {
        String[] options = {"rock", "paper", "scissors"};
        int index = (int) (Math.random() * options.length);
        return options[index];
    }
}
