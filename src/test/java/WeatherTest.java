import pages.BaseFunc;
import pages.HomePage;
import pages.WeatherPage;
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
        WeatherPage weatherPage = homePage.




    }
}
