package elements;


import helpers.WaitFor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Span extends BaseElement {
    public Span(WebDriver driver, By by) {
        super(driver, by);
    }

    public String text()
    {
        return webElement.getText();
    }

    public void click()
    {
        WaitFor.visibilityOfElementLocated(by);
        WaitFor.clickabilityOfElement(webElement);
        webElement.click();
    }
}
