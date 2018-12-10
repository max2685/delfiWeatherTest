package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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


    public HomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public Map<String, List> getElementsFromHomePage() {
        Map<String, List> homePagemap = new HashMap<String, List>();
        List<WebElement> citiesFromHomePage = baseFunc.getElements(ARTICLES);

        for (WebElement homePageCity : citiesFromHomePage) {
            homePageCity.click();
            List<WebElement> temperatureValues = baseFunc.getElements(VALUES);

            List<Integer> valuesIntegersFromHomePage = new ArrayList<Integer>();
            for (WebElement valueHomePage : temperatureValues) {
                String valuesStrings = valueHomePage.getText();
                valuesStrings = valuesStrings.substring(0, valuesStrings.length() - 1);
                valuesIntegersFromHomePage.add(Integer.valueOf(valuesStrings));
            }

            homePagemap.put(homePageCity.getText(), valuesIntegersFromHomePage);
        }

        return homePagemap;
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
