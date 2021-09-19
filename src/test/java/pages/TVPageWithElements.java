package pages;

import elements.Accordeon;
import elements.CheckBox;
import elements.Input;
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

    //Тип подсветки

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

    public void setDiagonalInterval(String min, String max)
    {
        Input inputMin=new Input(driver, By.xpath(inputMinDiagonalXpath));
        Input inputMax = new Input(driver, By.xpath(inputMaxDiagonalXpath));
        inputMin.setValue(min);
        inputMax.setValue(max);
    }

}
