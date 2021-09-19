package tests.tvs;

import helpers.JSExec;
import helpers.WaitFor;
import models.*;
import org.junit.jupiter.api.Test;
import pages.*;
import tests.BaseTest;

public class TVPage1_Test extends BaseTest {

    @Test
    public void firstTest()
    {
        StartPageWithElements page = getTVPage(new TV(new Producer(Producer.SAMSUNG), new Frequency(120), new LightType(LightType.DIRECT_LED), new DiagonalInterval(60,80)));
        try {
            Thread.sleep(10000);
        }
        catch (java.lang.InterruptedException e)
        {

        }
    }

    public StartPageWithElements getTVPage(TV tv)
    {
        driver.get("https://www.dns-shop.ru/");
        StartPageWithElements startPage = new StartPageWithElements(driver);
        startPage.linkTVAndMultimediaMove();
        startPage.linkTVsClick();

        TVPageWithElements tvPage = new TVPageWithElements(driver);
        JSExec.scrollBy(0,500);
        tvPage.setProducer(tv.getProducer().getProducer());

        JSExec.scrollBy(0,800);
        tvPage.setAccordeonDiagonalClick();
        tvPage.setDiagonalInterval(tv.getDiagonalInterval().getMin(),tv.getDiagonalInterval().getMax());

        JSExec.scrollBy(0,1000);
        tvPage.setFreq(tv.getFrequency().toString());

        tvPage.setLight(tv.getLightType().getLightType());

        JSExec.scrollBy(0,1300);
        tvPage.clickApplyBtn();

        JSExec.scrollBy(0, -500);
        tvPage.clickFirstItem("65\" (163 см) Телевизор LED Samsung QE65Q70AAUXRU серый [4K UltraHD, 3840x2160, DVB-S2, DVB-S, DVB-C, DVB-T2, DLNA, Wi-Fi, Tizen, HDMI х 4, USB х 2]");

        TVProductPage tvProductPage = new TVProductPage(driver);
        TV resultTV=tvProductPage.getTV();
        return  startPage;
    }
}
