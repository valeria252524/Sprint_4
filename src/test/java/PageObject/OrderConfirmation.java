package PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

//Класс модального окна подтверждения заказа "Хотите оформить заказ?"
public class OrderConfirmation {
    private WebDriver driver;
    //Модальное окно "Хотите оформить заказ?"
    private By modalWindow = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ']");
    //Кнопка подтверждения заказа "Да"
    private By orderConfirmationYes = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");
    //Кнопка отмены заказа "Нет"
    private By getOrderConfirmationNo = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM Button_Inverted__3IF-i' and text()='Нет']");

    // Ожидание загрузки модального окна
    public void waitForPageLoading(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(modalWindow));
    }
    public OrderConfirmation (WebDriver driver){
        this.driver = driver;
    }
    //Клик по кнопке "Да" на модальном окне "Хотите оформить заказ?"
    public void confirmOrderYes(){
        driver.findElement(orderConfirmationYes).click();
    }
    //Клик по кнопке "Нет" на модальном окне "Хотите оформить заказ?"
    public void cancelOrderNo(){
        driver.findElement(getOrderConfirmationNo).click();
    }

}
