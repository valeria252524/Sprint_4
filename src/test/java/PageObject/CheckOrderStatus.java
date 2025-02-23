package PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import org.hamcrest.MatcherAssert;

// Класс для модального окна "Заказ оформлен"
public class CheckOrderStatus {
    private WebDriver driver;
    // Модальное окно "Заказ оформлен"
    private By modalWindowOrderPlaced = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ']");


    public CheckOrderStatus(WebDriver driver) {
        this.driver = driver;
    }

    public void сheckOrderPlacing(String successOrderPlacing) {
        //Дожидаемся загрузки модального окна
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(modalWindowOrderPlaced));
        //Получаем текст с модального окна, сравниваем с ожидаемым результатом
    String actualText = driver.findElement(modalWindowOrderPlaced).getText();
      MatcherAssert.assertThat(actualText, containsString(successOrderPlacing));

}
}
