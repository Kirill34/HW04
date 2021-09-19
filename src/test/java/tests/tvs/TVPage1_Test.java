package tests.tvs;

import helpers.JSExec;
import helpers.WaitFor;
import org.junit.jupiter.api.Test;
import pages.*;
import tests.BaseTest;

public class TVPage1_Test extends BaseTest {

    @Test
    public void firstTest()
    {
        StartPageWithElements page = getTVPage();
        try {
            Thread.sleep(10000);
        }
        catch (java.lang.InterruptedException e)
        {

        }
    }

    public StartPageWithElements getTVPage()
    {
        driver.get("https://www.dns-shop.ru/");
        StartPageWithElements startPage = new StartPageWithElements(driver);
        startPage.linkTVAndMultimediaMove();
        startPage.linkTVsClick();

        TVPageWithElements tvPage = new TVPageWithElements(driver);
        JSExec.scrollBy(0,500);
        tvPage.setProducer("Samsung");

        JSExec.scrollBy(0,800);
        tvPage.setAccordeonDiagonalClick();
        tvPage.setDiagonalInterval("60","80");

        JSExec.scrollBy(0,1000);
        tvPage.setFreq("120 Гц");

        tvPage.setLight("Direct LED");

        return  startPage;
    }
}
