import pages.BaseFunc;
import pages.HomePage;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class WeatherTest {
    private BaseFunc baseFunc = new BaseFunc();
    private final String HOME_PAGE = "m.rus.delfi.lv";



    @Test
    public void weatherToCheck() {
        baseFunc.goToURL(HOME_PAGE);
        HomePage homePage = new HomePage(baseFunc);
        Map<String, List> fromHomePage = homePage.getElements();

        //Open side Menu
        homePage.openSideMenu();

        //Select Menu Item by name
        homePage.selectSideMenuItem("Прогноз погоды");

//        DropDownToggle dropDownToggle = homePage.clickDropdownToggle();
//        dropDownToggle.ClickOnWeather();


    }
}
