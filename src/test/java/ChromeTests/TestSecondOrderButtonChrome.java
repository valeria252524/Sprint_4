package ChromeTests;

import PageObject.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


@RunWith(Parameterized.class)
public class TestSecondOrderButtonChrome {
    private final String name;
    private final String lastName;
    private final String address;
    private final String metroStation;
    private final String phoneNumber;
    private final String date;
    private final String rentTerm;
    private final String color;
    private final String courierComment;
    private final String successWordOrderPlacing;

    public TestSecondOrderButtonChrome(String name, String lastName, String address, String metroStation,
                                      String phoneNumber, String date, String rentTerm,
                                      String color, String courierComment, String successWordOrderPlacing) {
        this.name = name;
        this.lastName = lastName ;
        this.address = address;
        this.metroStation = metroStation;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.rentTerm = rentTerm;
        this.color = color;
        this.courierComment = courierComment;
        this.successWordOrderPlacing = successWordOrderPlacing;
    }
    // Тестовые данные
    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
                { "Иван","Иванов", "г.Нижний Новгород, пр. Мира, 4",
                        "Черкизовская", "+79206981234", "25.02.2025", "двое суток",
                        "black", "Красная дверь", "Заказ оформлен"},
                {"Екатерина", "Дмитриева", "г. Тверь, пл. Конституции, д. 294",
                        "Комсомольская", "+79234568213", "30.04.2025", "сутки",
                        "grey", "Вход со двора", "Заказ оформлен"}
        };
    }
    @Test
    public void checkPlacingOrderSecondButton() {
        // создали драйвер для браузера Chrome
        WebDriver driver = new ChromeDriver();
        // перешли на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");
        // создаем объект главной страницы
        MainPage objMainPage = new MainPage(driver);
        //вызывали метод ожидания загрузки главной страницы
        objMainPage.waitForLoadHeader();
        // кликаем по второй кнопке "Заказать"
        objMainPage.clickSecondOrderButton();
        // создаем объект первой страницы "Для кого самокат"
        ForWhomSamokat objForWhomSamokat = new ForWhomSamokat(driver);
        //ожидаем загрузку страницы:
        objForWhomSamokat.waitForPageLoading();
        //Заполняем поля:
        objForWhomSamokat.setNameField(name);
        objForWhomSamokat.setLastnameField(lastName);
        objForWhomSamokat.setAddressField(address);
        objForWhomSamokat.setMetroStationField(metroStation);
        objForWhomSamokat.setPhoneField(phoneNumber);
        //кликаем на кнопку "Далее"
        objForWhomSamokat.clickNext();
        //создаем объект второй страницы "Про аренду"
        AboutRent objAboutRent = new AboutRent(driver);
        //ожидаем загрузку страницы
        objAboutRent.waitForPageLoading();
        //Заполняем поля:
        objAboutRent.setDateField(date);
        objAboutRent.setRentTermField(rentTerm);
        objAboutRent.setColorField(color);
        objAboutRent.setCommentForCourierField(courierComment);
        //Кликаем на кнопку "Заказать"
        objAboutRent.clickOrderButton();
        //Создаем объект для подтверждения заказа
        OrderConfirmation objOrderConfirmation = new OrderConfirmation(driver);
        //ожидаем загрузку модального окна
        objOrderConfirmation.waitForPageLoading();
        //кликаем на "Да"
        objOrderConfirmation.confirmOrderYes();
        //создаем объект для проверки создания заказа
        CheckOrderStatus objCheckOrderStatus = new CheckOrderStatus(driver);
        // проверяем, что есть модальное окно с текстом "Заказ оформлен"
        objCheckOrderStatus.сheckOrderPlacing(successWordOrderPlacing);


        driver.quit();
    }
}
