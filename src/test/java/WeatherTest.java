import org.junit.jupiter.api.Assertions;
import pages.BaseFunc;
import pages.HomePage;
import org.junit.jupiter.api.Test;
import pages.RezeknePage;
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

        //Open side Menu
        homePage.openSideMenu();

        //Select Menu Item by name
        homePage.selectSideMenuItem("Прогноз погоды");

        WeatherPage weatherPage = new WeatherPage(baseFunc);
        Map<String, List> valuesFromWeatherPage = weatherPage.getElementsFromWeatherPage();

        weatherPage.fillField("Rezekne");

        RezeknePage rezeknePage = new RezeknePage(baseFunc);

//        Assertions.assertEquals(valuesfromHomePage.keySet(), valuesFromWeatherPage.keySet(), "Cities and temperatures are not equal");



    }

}
