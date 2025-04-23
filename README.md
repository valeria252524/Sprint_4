# Sprint_4
Тесты для тестирования оформления заказа на сайте 
https://qa-scooter.praktikum-services.ru/

По пути src/main/java/pageobject находится пакет со классами страниц сайта

По пути src/main/target находятся тесты.

BaseTest - класс для общих действий с аннотациями @Before и @After, а также с выбором двух браузеров
TestDropdownListFirstQuestionInImportantQuestions - класс с тестами для проверки работы выпадающего списка
TestFirstOrderButton - класс для проверки оформления заказа по клику на первую кнопку "Заказать" в правом верхнем углу, тесты прогоняются с 2 наборами тестовых данных на 2 браузерах: Google Chrome и Mozilla Firefox
TestSecondOrderButton - класс для проверки оформления заказа по клику на вторую кнопку "Заказать" в середине страницы, тесты прогоняются с 2 наборами тестовых данных на 2 браузерах: Google Chrome и Mozilla Firefox