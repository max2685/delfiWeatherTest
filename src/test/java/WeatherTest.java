import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import pages.BaseFunc;
import pages.HomePage;
import org.junit.jupiter.api.Test;
import pages.CitiesPage;
import pages.WeatherPage;

import java.util.List;
import java.util.Map;

public class WeatherTest {
    private BaseFunc baseFunc = new BaseFunc();
    private final String HOME_PAGE = "m.rus.delfi.lv";
    private final Logger LOGGER = LogManager.getLogger(WeatherTest.class);


    @Test
    public void weatherToCheck() {
        baseFunc.goToURL(HOME_PAGE);
        LOGGER.info("Opening home page");

        HomePage homePage = new HomePage(baseFunc);
        Map<String, List> valuesfromHomePage = homePage.getElementsFromHomePage();
        LOGGER.info("Getting elements from Home Page");

        homePage.openSideMenu();
        LOGGER.info("Opening side menu");

        homePage.selectSideMenuItem("Прогноз погоды");

        WeatherPage weatherPage = new WeatherPage(baseFunc);
        Map<String, List> valuesFromWeatherPage = weatherPage.getElementsFromWeatherPage();
        LOGGER.info("Getting elements from Weather Page");

        weatherPage.fillField("Rezekne");

        CitiesPage cityPage = new CitiesPage(baseFunc);

        valuesFromWeatherPage = cityPage.addThirdCity(valuesFromWeatherPage);
        LOGGER.info("Adding another city in the second map");

        cityPage.fillField("Daugavpils");

        valuesFromWeatherPage = cityPage.addFourthCity(valuesFromWeatherPage);
        LOGGER.info("Adding another city in the second map");


        Assertions.assertEquals(valuesfromHomePage, valuesFromWeatherPage, "Cities,or temperatures,or both of them are not equal");


    }

}

