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
    private final By DROPMENU = By.xpath("//*[@id=\"md-header\"]/a[1]");
    private final By SIDE_MENU = By.xpath(".//a[@class = 'menu-open']");
    private final By SIDE_MENU_ITEM = By.xpath(".//span[@class = 'link-title']");


    public HomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public Map<String, List> getElements() {
        Map<String, List> map = new HashMap<String, List>();
        List<WebElement> articles = baseFunc.getElements(ARTICLES);

        for (WebElement element : articles) {
            element.click();
            List<WebElement> temperatureValues = baseFunc.getElements(VALUES);

            List<Integer> valuesIntegers = new ArrayList<Integer>();
            for (WebElement value : temperatureValues) {
                String valuesStrings = value.getText();
                valuesStrings = valuesStrings.substring(0, valuesStrings.length() - 1);
                valuesIntegers.add(Integer.valueOf(valuesStrings));
            }

            map.put(element.getText(), valuesIntegers);
        }

        return map;
    }

//    public  DropDownToggle clickDropdownToggle () {
////        baseFunc.getElement(DROPMENU);
////        WebElement menu = baseFunc.getElement(DROPMENU);
//
//        Actions actions = new Actions(baseFunc.browser);
//        JavascriptExecutor jse = (JavascriptExecutor)baseFunc.browser;
//        jse.executeScript("window.scrollBy(0,-250)", "");
//        (new WebDriverWait(baseFunc.browser, 10)).until(ExpectedConditions.visibilityOfElementLocated(DROPMENU));
//        actions.click() ;
////        (new WebDriverWait(baseFunc.browser, 10)).until(ExpectedConditions.visibilityOfElementLocated(DROPMENU));
//
////        actions.moveToElement(menu,1,1).click().build().perform();
//        return new DropDownToggle(baseFunc);
//    }

    public void openSideMenu() {
        baseFunc.scrollTo(0, 0);
        baseFunc.waitForElement(SIDE_MENU);
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

        return new WeatherPage();
    }
}
