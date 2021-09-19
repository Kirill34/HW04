package elements;

import helpers.WaitFor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Input extends BaseElement{
    public Input(WebDriver driver, By by) {
        super(driver, by);
    }

    public void setValue(String value)
    {
        WaitFor.clickabilityOfElement(webElement);
        webElement.click();
        webElement.sendKeys(value);
    }
}
