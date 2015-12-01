public class Game {

    private final FakeConsole fakeConsole;

    public Game(FakeConsole fakeConsole) {
        this.fakeConsole = fakeConsole;
    }

    public String getUserInput() {
        return fakeConsole.read();
    }


    public void print(String message) {
        fakeConsole.print(message);
    }
}
