package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomePage {
    BaseFunc baseFunc;


    private final By ARTICLES = By.xpath(".//a[@class = 'location-tab-title']");
    private final By VALUES = By.xpath(".//div[@class = 'forecast-temp']");
    private final By SIDE_MENU = By.xpath(".//a[@class = 'menu-open']");
    private final By SIDE_MENU_ITEM = By.xpath(".//span[@class = 'link-title']");
    private final By IMG_AD = By.xpath("");


    public HomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public Map<String, List> getElementsFromHomePage() {
        Map<String, List> homePageMap = new HashMap<String, List>();
        List<WebElement> citiesFromHomePage = baseFunc.getElements(ARTICLES);

        for (WebElement homePageCity : citiesFromHomePage) {
            homePageCity.click();
            List<WebElement> temperatureValues = baseFunc.getElements(VALUES);

            List<Integer> temperaturesFromHomePage = new ArrayList<Integer>();
            for (WebElement valueHomePage : temperatureValues) {
                String tempetature = valueHomePage.getText();
                tempetature = tempetature.substring(0, tempetature.length() - 1);
                temperaturesFromHomePage.add(Integer.valueOf(tempetature));
            }

            homePageMap.put(homePageCity.getText(), temperaturesFromHomePage);
        }

        return homePageMap;
    }


    public void openSideMenu() {
        baseFunc.scrollTo(0, 0);
        baseFunc.waitForElementToBeClickable(SIDE_MENU);
        baseFunc.getElement(SIDE_MENU).click();
    }

    public WeatherPage selectSideMenuItem(String name) {
        List<WebElement> menuItems = baseFunc.getElements(SIDE_MENU_ITEM);

        for (WebElement we : menuItems) {
            if (we.getText().equals(name)) {
                we.click();
                break;
            }
        }

        return new WeatherPage(baseFunc);
    }


}
