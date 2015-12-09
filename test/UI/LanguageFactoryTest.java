package UI;

import org.assertj.core.api.ThrowableAssert;
import org.junit.Ignore;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

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

    @Test
    public void whatHappensOnBadInput() {
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> languageFactory.generateLanguage("1234"));
    }

    @Ignore
    @Test(expected = RuntimeException.class)
    public void failsWhenUnkonw() {
        languageFactory.generateLanguage("1234");
    }
}