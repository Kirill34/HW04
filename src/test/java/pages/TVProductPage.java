package pages;

import elements.Img;
import elements.Link;
import elements.Span;
import models.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;

public class TVProductPage extends BasePage{

    public TVProductPage(WebDriver driver) {
        super(driver);
    }

    //Производитель
    private String imgProducerXptath = "//img[contains(@class,'product-card-top__brand-image')]";

    //Ссылка "Характеристики"
    private String linkCharsXpath = "//a[(normalize-space(text())='Характеристики')]";

    //Диагональ экрана
    private String spanDiagonalXpath = "(//span[contains(text(),'Диагональ экрана')][1]/following::span[1])[1]";

    //Частота обновления экрана
    private String spanFreqXpath = "//span[normalize-space(text())='Частота обновления экрана']/following::span[1]";

    //Тип подсветки экрана
    private String spanLightTypeXpath = "//span[normalize-space(text())='Тип подсветки экрана']/following::span[1]";

    //Модель
    private String spanModelXpath = "//span[normalize-space(text())='Модель']/following::span[1]";


    public TV getTV()
    {
        Link linkChars = new Link(driver, By.xpath(linkCharsXpath));
        linkChars.click();

        Img imgProducer = new Img(driver, By.xpath(imgProducerXptath));
        Span spanModel = new Span(driver, By.xpath(spanModelXpath));
        Span spanLightType = new Span(driver, By.xpath(spanLightTypeXpath));
        Span spanDiagonal = new Span(driver, By.xpath( spanDiagonalXpath));
        Span spanFreq = new Span(driver, By.xpath(spanFreqXpath));

        //Выделение частоты из текста
        String freqString =  (spanFreq.text().substring(0, spanFreq.text().lastIndexOf(' ')));
        int freq = Integer.parseInt(freqString);

        //Выделение диагонали из текста
        String diagonalString =  (spanDiagonal.text().substring(0, spanDiagonal.text().lastIndexOf(' ')));
        int diagonal = Integer.parseInt(diagonalString);

        return new
                TV( new Producer(imgProducer.getAttribute("alt")),
                new Frequency(freq), new LightType(spanLightType.text()), new DiagonalInterval(diagonal,diagonal)
        );


    }

}
