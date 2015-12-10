package UI;

public class LanguageFactory {

    public Language generateLanguage(String userChoice) {
        if (userChoice.equals("1")) {
            return new EnglishLanguage();
        } else if (userChoice.equals("2")){
            return new GermanLanguage();
        } else {
            throw new RuntimeException("Couldn't find language for: " + userChoice);
        }
    }


    public Language defaultLanguage() {
        return new EnglishLanguage();
    }
}
