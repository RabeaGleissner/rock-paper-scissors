public class FakeConsole {

    private String userChoice;

    public FakeConsole() {
        userChoice = "";
    }

    public String read() {
        return userChoice;
    }

    public void provideUserChoice(String choice) {
        userChoice = choice;
    }
}
