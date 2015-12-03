public class Game {

    private final Console console;


    public Game(Console console) {
        this.console = console;
    }

    public String getUserInput() {
        String move = console.read();
        String returnedMove = "";
        switch (move) {
            case "R": returnedMove = "rock";
                break;
            case "S": returnedMove ="scissors";
                break;
            case "P": returnedMove = "paper";
                break;
            case "E": returnedMove = "exit";
                break;
        }
        return returnedMove;
    }

    public void print(String message) {
        console.print(message);
    }

}
