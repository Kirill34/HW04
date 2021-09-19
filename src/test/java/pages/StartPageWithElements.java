package pages;

import elements.Link;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// Стартовая страница сайта DNS
public class StartPageWithElements extends BasePage {
    // Логгер
    private Logger logger = LogManager.getLogger(StartPageWithElements.class);
    // URL страницы
    private final String URL = "https://www.dns-shop.ru/";

    // ***** Локаторы *****
    // Кнопка "Да" на всплывашке
    String linkYesXpath = "//a[contains(text(),\"Да\")]";
    // Ссылка "Смартфоны и гаджеты"
    String linkTVAndMultimediaXpath = "(//a[contains(text(), \"ТВ и мультимедиа\")])[1]";
    // Ссылка "Смартфоны"
    String linkTVsXpath = "//a[normalize-space(text())='Телевизоры']";

    // Конструктор класса
    public StartPageWithElements(WebDriver driver) {
        // Вызов родительского конструктора
        super(driver);
    }

    // Получение URL страницы
    public String getURL() {
        return this.URL;
    }

    // Открытие страницы
    public void openPage() {
        driver.get(this.URL);
        logger.info("Открыта страница https://www.dns-shop.ru/");
    }

    // Нажатие на кнопку "Да"
    public void linkYesClick() {
        Link linkYes = new Link(driver, By.xpath(linkYesXpath));
        linkYes.click();
        logger.info("Нажата кнопка \"Да\"");
    }

    // Наведение курсора мыши на ссылку "ТВ и мультимедиа"
    public void linkTVAndMultimediaMove() {
        Link linkTVAndMultimedia = new Link(driver, By.xpath(linkTVAndMultimediaXpath));
        linkTVAndMultimedia.focusOnLink();
        logger.info("Курсор мыши наведен на ссылку \"Телевизоры и мультимедиа\"");
    }

    // Нажатие на ссылку "Телевизоры"
    public void linkTVsClick() {
        Link linkTVs = new Link(driver, By.xpath(linkTVsXpath));
        linkTVs.click();
        logger.info("Нажата ссылка \"Телевизоры\"");
    }
}