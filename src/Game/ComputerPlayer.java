package game;

public class ComputerPlayer {

    private final Randomizer randomizer;

    public ComputerPlayer(Randomizer randomizer) {
        this.randomizer = randomizer;
    }

    public Move generateMove() {

        return randomizer.getRandomMove();
    }


}

