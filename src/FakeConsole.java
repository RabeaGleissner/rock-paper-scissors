public class FakeConsole {

    private String userChoice;
    private String consoleOutput;

    public FakeConsole() {
        userChoice = "";
        consoleOutput = "";
    }

    public String read() {
        return userChoice;
    }

    public void print(String message) {
        consoleOutput = message;
    }

    public void provideUserChoice(String choice) {
        userChoice = choice;
    }

    public String messagePrinted() {
        return consoleOutput;
    }
}
