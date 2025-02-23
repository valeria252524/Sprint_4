package PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

//Класс для первой страницы оформления заказа "Для кого самокат"
public class ForWhomSamokat {
    private WebDriver driver;
    //Поле "Имя"
    private By nameField = By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='* Имя']");
    //Поле "Фамилия"
    private By lastnameField = By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='* Фамилия']");
    // Поле "Адрес, куда привезти самокат"
    private By addressField = By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='* Адрес: куда привезти заказ']");
    //Поле "Станция метро"
    private By metroStationField = By.xpath(".//div[@class='select-search__value']/input[@placeholder='* Станция метро']");
    //Поле "Номер телефона"
    private By phoneField = By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='* Телефон: на него позвонит курьер']");
    //Кнопка "Далее"
    private By nextButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");


    public ForWhomSamokat(WebDriver driver){

        this.driver = driver;

    }

    // Ожидание загрузки страницы "Для кого самокат"
    public void waitForPageLoading(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(nextButton));
    }
    //Заполнение поля "Имя"
    public void setNameField(String name){
        driver.findElement(nameField).sendKeys(name);
    }
    //Заполнения поля "Фамилия"
    public void setLastnameField(String lastname){
        driver.findElement(lastnameField).sendKeys(lastname);
    }
    //Заполнения поля "Адрес, куда доставить самокат"
    public void setAddressField(String address){
        driver.findElement(addressField).sendKeys(address);
    }
    //Заполнение поля "Станция метро"
    public void setMetroStationField(String metroStation){
        driver.findElement(metroStationField).click();
        driver.findElement(metroStationField).sendKeys(metroStation);
        driver.findElement(By.xpath(".//div[text()='" + metroStation + "']")).click();


    }
    //Заполнение поля "Номер телефона"
    public void setPhoneField(String phoneNumber){
        driver.findElement(phoneField).sendKeys(phoneNumber);
    }
    //Клик на кнопку "Далее"
    public void clickNext(){
        driver.findElement(nextButton).click();
    }
}
