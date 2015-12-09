package UI;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LanguageFactoryTest {

    LanguageFactory languageFactory = new LanguageFactory();

    @Test
    public void generateEnglishLanguage() {
        assertThat(languageFactory.generateLanguage("1")).isInstanceOf(EnglishLanguage.class);
    }

    @Test
    public void generateGermanLanguage() {
        assertThat(languageFactory.generateLanguage("2")).isInstanceOf(GermanLanguage.class);
    }

    @Test(expected = RuntimeException.class)
    public void failsWhenUnkonw() {
        languageFactory.generateLanguage("1234");
    }
}