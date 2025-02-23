package ChromeTests;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import PageObject.MainPage;

public class TestDropdownListFirstQuestionInImportantQuestionsChrome {

    @Test
    public void checkDropdownListFirstAnswerOnFirstQuestion() {
        // создали драйвер для браузера Chrome
        WebDriver driver = new ChromeDriver();
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
