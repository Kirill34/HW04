package pages;

import elements.*;
import helpers.WaitFor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TVPageWithElements extends  BasePage{

    private Logger logger = LogManager.getLogger(TVPageWithElements.class);

    public TVPageWithElements(WebDriver driver) {
        super(driver);

    }

    private final String URL = "https://www.dns-shop.ru/";
    //Список производителей
    String accordeonProducerXpath = "//span[normalize-space(text())='Производитель']";
    String chbxProducerXpath="//span[(normalize-space(text())='company')]";

    //Диагональ
    String accordeonDiagonalXpath= "//span[normalize-space(text())='Диагональ экрана (дюйм)']";
    String inputMinDiagonalXpath = "(//input[@type='number'])[3]";
    String inputMaxDiagonalXpath = "(//input[@type='number'])[4]";

    //Частота обновления
    String accordeonFreqXpath = "//span[contains(text(),'Частота обновления экрана')][1]";
    String chbxFreqXpath="//span[(contains(text(),'freq'))]";

    //Тип подсветки
    String accordeonLightXpath = "//span[contains(text(),'Тип подсветки экрана')][1]";
    String chbxLightXpath="//span[(contains(text(),'lighttype'))]";

    //Кнопка "Применить"
    String btnApplyXpath = "//button[contains(text(),'Применить')]";

    //Ссылка на первый результат в поиске
    String linkFirstItemXpath = "(//a[contains(@class, \"catalog-product__name\")])[1]";

    //Фильтр "сначала недорогие"
    String spanBeginNotExpensiveXpath = "//span[contains(text(),'Сначала недорогие')]";

    //Фильтр "сначала дорогие"
    String spanBeginExpensiveXpath = "//span[contains(text(),'Сначала дорогие')]";

    // Сортировка
    // - Выпадашка "Сортировка"
    String accordeonSortXpath = "//span[contains(text(), \"Сортировка:\")]/following::a";

    public void setProducer(String producer)
    {
        chbxProducerXpath = chbxProducerXpath.replace("company",producer);
        CheckBox chbxProducer = new CheckBox(driver, By.xpath(chbxProducerXpath));
        chbxProducer.setChecked(true);
        logger.info("Был выбран производитель "+producer);
    }

    public void setAccordeonProducerClick()
    {
        Accordeon accordeonProducer = new Accordeon(driver, By.xpath(accordeonProducerXpath));
        accordeonProducer.show();
    }

    public void setAccordeonDiagonalClick()
    {
        Accordeon accordeonDiagonal = new Accordeon(driver, By.xpath(accordeonDiagonalXpath));
        accordeonDiagonal.show();
    }

    public void setDiagonalInterval(int min, int max)
    {
        Input inputMin=new Input(driver, By.xpath(inputMinDiagonalXpath));
        Input inputMax = new Input(driver, By.xpath(inputMaxDiagonalXpath));
        inputMin.setValue(String.valueOf(min));
        inputMax.setValue(String.valueOf(max));
    }

    public void setFreq(String freq)
    {
        Accordeon accordeonFreq = new Accordeon(driver, By.xpath(accordeonFreqXpath));
        accordeonFreq.show();
        chbxFreqXpath = chbxFreqXpath.replace("freq", freq);
        CheckBox chbxFreq = new CheckBox(driver, By.xpath(chbxFreqXpath));
        chbxFreq.setChecked(true);
    }

    public void setLight(String light)
    {
        Accordeon accordeonLight = new Accordeon(driver, By.xpath(accordeonLightXpath));
        accordeonLight.show();
        chbxLightXpath = chbxLightXpath.replace("lighttype", light);
        CheckBox chbxLight = new CheckBox(driver, By.xpath(chbxLightXpath));
        chbxLight.setChecked(true);
    }

    public void clickApplyBtn()
    {
        Button btnApply = new Button(driver, By.xpath(btnApplyXpath));
        btnApply.click();
    }

    public void clickFirstItem(String product)
    {
        WaitFor.firstProductMustBe(By.xpath(linkFirstItemXpath), product);
        Link link = new Link(driver, By.xpath(linkFirstItemXpath));
        link.click();
    }

    public void clickBeginExpensiveSpan()
    {
        Accordeon accordeonSort = new Accordeon(driver, By.xpath(accordeonSortXpath));
        accordeonSort.show();
        logger.info("Найден аккордеон для сортировки");
        RadioButton rbtnBeginExpensive = new RadioButton(driver, By.xpath(spanBeginExpensiveXpath));
        rbtnBeginExpensive.setSelected(true);
        logger.info("Установлена сортировка \"сначала дорогие\"");
    }

}
