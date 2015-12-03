public class Game {

    private final Console console;


    public Game(Console console) {
        this.console = console;
    }

    public Enum getUserInput() {
        String move = console.read();
        Enum returnedMove = null;
        switch (move) {
            case "R": returnedMove = Move.ROCK;
                break;
            case "S": returnedMove = Move.SCISSORS;
                break;
            case "P": returnedMove = Move.PAPER;
                break;
            case "E": returnedMove = Move.EXIT;
                break;
        }
        return returnedMove;
    }

    public void print(String message) {
        console.print(message);
    }

}
