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
    private final By DROPMENU = By.xpath("//*[@id=\"md-header\"]/a[1]");


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
    public  DropDownToggle clickDropdownToggle () {
        baseFunc.getElement(DROPMENU).click();
        return new DropDownToggle(baseFunc);
    }
}
