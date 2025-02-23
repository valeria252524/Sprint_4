package PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

// Класс для второй страницы оформления заказа "Про аренду"
public class AboutRent {
    private WebDriver driver;
    // Поле "Когда привезти самокат"
    private By dateField = By.xpath(".//input[contains(@class, 'Input_Responsible__1jDKN') and @placeholder='* Когда привезти самокат']");
    // Поле "Срок аренды"
    private By rentTermField = By.xpath(".//div[@class='Dropdown-placeholder' and text()='* Срок аренды']");
    //Поле для чекбокса "Цвет самоката", убрала поле, так как сразу передаю значение в метод для заполнения поля
   // private By colorField = By.xpath(".//input[@class='Checkbox_Input__14A2w']");
    //Поле "Комментарий для курьера"
    private By commentForCourierField = By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='Комментарий для курьера']");
    //Кнопка "Заказать"
    private By orderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");

    public AboutRent (WebDriver driver){
        this.driver = driver;
    }
    // Ожидание загрузки страницы с предыдущей страницы "Для кого самокат"
    public void waitForPageLoading(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(orderButton));
    }
    // Заполнение переданным значением поля "Когда привезти самокат"
    public void setDateField (String date){
        driver.findElement(dateField).click();
        driver.findElement(dateField).sendKeys(date);
        driver.findElement(dateField).sendKeys(Keys.ENTER);
    }
    // Заполнение переданным значением поля "Срок аренды"
    public void setRentTermField(String rentTerm){
        //Так как список выпадающий, сначала кликаем на поле
        driver.findElement(rentTermField).click();
        //Выбираем срок из списка переданным значением
        driver.findElement(By.xpath(".//div[@class='Dropdown-option' and text()='" + rentTerm + "']")).click();
    }
    // Клик на чекбокс с переданным значением для поля "Цвет самоката"
    public void setColorField(String colorId){
        driver.findElement(By.id(colorId)).click();
    }
    //Заполнение поля "Комментарий для курьера"
    public void setCommentForCourierField(String commentForCourier){
        driver.findElement(commentForCourierField).sendKeys(commentForCourier);
    }
    //Клик на кнопку "Заказать"
    public void clickOrderButton(){
        driver.findElement(orderButton).click();
    }

}
