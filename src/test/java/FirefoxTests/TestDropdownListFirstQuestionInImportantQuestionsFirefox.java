package FirefoxTests;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import PageObject.MainPage;

public class TestDropdownListFirstQuestionInImportantQuestionsFirefox {
    @Test
    public void checkDropdownListFirstAnswerOnFirstQuestion() {
        // создали драйвер для браузера Firefox
        WebDriver driver = new FirefoxDriver();
        // перешли на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");
        // создаем объект главной страницы
        MainPage objMainPage = new MainPage(driver);
        //вызывали метод ожидания загрузки главной страницы
        objMainPage.waitForLoadHeader();
        //Проверяем, что при клике на выпадающий список отображается первый ответ на вопрос
        objMainPage.checkClickOnImportantQuestion("Сутки — 400 рублей. Оплата курьеру — наличными или картой.");


        driver.quit();
    }
}
