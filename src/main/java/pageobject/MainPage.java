package pageobject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.hamcrest.MatcherAssert;
import org.hamcrest.CoreMatchers;

// Главная страница
public class MainPage {
    private WebDriver driver;
    //Первая кнопка "Заказать"
    private By firstOrderButton = By.xpath(".//button[@class='Button_Button__ra12g' and text()='Заказать']");
    //Вторая кнопка "Заказать"
    private By secondOrderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");
    //Первый вопрос в блоке "Вопросы о важном"
    private By firstQuestionImportantQuestions = By.xpath(".//div[@id='accordion__heading-0']");
    //Первый ответ на первый вопрос в блоке "Вопросы о важном"
    private By firstAnswerImportantQuestions = By.xpath(".//div[@id='accordion__panel-0']");




    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    //Открываем главную страницу и ожидаем загрузку главной страницы
    public void open() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='Home_Header__iJKdX']")));
    }
    //Клик по первой кнопке "Заказать"
   public void clickFirstOrderButton(){
        driver.findElement(firstOrderButton).click();
   }
   //Клик по второй кнопке "Заказать" со скроллом, так как элемент может быть невидим
   public void clickSecondOrderButton(){
       WebElement element = driver.findElement(secondOrderButton);
       // Прокручиваем страницу до элемента
       ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
       // Выполняем клик по кнопке
       element.click();
   }
   //Проверка на открытие выпадающего списка в блоке "Вопросы о важном"
   //Предварительно скроллим вниз страницы, так как блок может быть невидим
   public void checkClickOnImportantQuestion(String valueForCheck){
       WebElement element = driver.findElement(firstQuestionImportantQuestions);
       // Прокручиваем страницу до элемента
       ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
       // Выполняем клик по кнопке
       element.click();
       //Получаем текст из ответа на первый вопрос
       String actualText = driver.findElement(firstAnswerImportantQuestions).getText();
       //Сравниваем с ожидаемым результатом
       MatcherAssert.assertThat(actualText, CoreMatchers.is(valueForCheck));
   }

}
