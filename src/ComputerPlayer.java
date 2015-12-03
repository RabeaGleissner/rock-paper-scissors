public class ComputerPlayer {

    private final Randomizer randomizer;

    public ComputerPlayer(Randomizer randomizer) {
        this.randomizer = randomizer;
    }

    public Enum generateMove() {

        return randomizer.getRandomMove();
    }


}

