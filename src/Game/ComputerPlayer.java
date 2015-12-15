package game;

public class ComputerPlayer {

    private final RandomCalc randomCalc;

    public ComputerPlayer(RandomCalc randomCalc) {
        this.randomCalc= randomCalc;
    }

    public Move generateMove() {
        Move[] options = Move.values();
        int index = randomCalc.randomNumber(options.length);
        return options[index];
    }
}

