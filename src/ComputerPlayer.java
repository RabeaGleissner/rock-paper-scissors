public class ComputerPlayer {
    public String generateMove() {

        return getRandomMove();
    }

    private String getRandomMove() {
        String[] options = {"rock", "paper", "scissors"};
        int index = (int) (Math.random() * options.length);
        return options[index];
    }
}

