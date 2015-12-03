public class ComputerPlayer {

    private final Randomizer randomizer;

    public ComputerPlayer(Randomizer randomizer) {
        this.randomizer = randomizer;
    }

    public String generateMove() {

        return randomizer.getRandomMove();
    }


}

