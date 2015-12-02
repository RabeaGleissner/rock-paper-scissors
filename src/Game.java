public class Game {

    private final Console console;


    public Game(Console console) {
        this.console = console;
    }

    public String getUserInput() {
        return console.read();
    }

    public void print(String message) {
        console.print(message);
    }

}
