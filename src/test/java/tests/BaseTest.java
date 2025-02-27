package tests;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageobject.MainPage;

public class BaseTest {
    protected WebDriver driver; // Доступен в наследниках
    protected MainPage mainPage; // Главная страница
    private final String browser;

    public BaseTest(String browser) {
        this.browser = browser;
    }
    @Before
    public void setUp() {
        if ("chrome".equals(browser)) {
            driver = new ChromeDriver();
        } else if ("firefox".equals(browser)) {
            driver = new FirefoxDriver();
        }

        mainPage = new MainPage(driver);
        mainPage.open();

    }
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}

