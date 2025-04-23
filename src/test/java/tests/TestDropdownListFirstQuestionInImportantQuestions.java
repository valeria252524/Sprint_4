package tests;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)

    public class TestDropdownListFirstQuestionInImportantQuestions extends BaseTest { // Наследуем BaseTest

        public TestDropdownListFirstQuestionInImportantQuestions(String browser) {
            super(browser); // Передаём браузер в BaseTest
        }

        @Parameterized.Parameters
        public static Collection<Object[]> browsers() {
            return Arrays.asList(new Object[][]{
                    {"chrome"},
                    {"firefox"}
            });
        }

        @Test
        public void checkDropdownListFirstAnswerOnFirstQuestion() {
            mainPage.checkClickOnImportantQuestion("Сутки — 400 рублей. Оплата курьеру — наличными или картой.");
        }

    }

