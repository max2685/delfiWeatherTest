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


    @Test
    public void weatherToCheck() {
        baseFunc.goToURL(HOME_PAGE);
        HomePage homePage = new HomePage(baseFunc);
        Map<String, List> valuesfromHomePage = homePage.getElementsFromHomePage();

        homePage.openSideMenu();
        homePage.selectSideMenuItem("Прогноз погоды");

        WeatherPage weatherPage = new WeatherPage(baseFunc);
        Map<String, List> valuesFromWeatherPage = weatherPage.getElementsFromWeatherPage();

        weatherPage.fillField("Rezekne");

        CitiesPage cityPage = new CitiesPage(baseFunc);

        valuesFromWeatherPage = cityPage.addThirdCity(valuesFromWeatherPage);

        cityPage.fillField("Daugavpils");

        valuesFromWeatherPage = cityPage.addFourthCity(valuesFromWeatherPage);

        Assertions.assertEquals(valuesfromHomePage, valuesFromWeatherPage, "Cities and temperatures are not equal");

//        if (valuesfromHomePage.equals(valuesFromWeatherPage)){
//
////
////        }

    }

}

