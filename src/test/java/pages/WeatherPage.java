package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeatherPage {
    BaseFunc baseFunc;
    private final By ALL_ELEMENTS = By.xpath(".//ul[@class = 'dweather2-recent-locations']/li/a");
    private final By SECONDARTICLES = By.xpath(".//span[@class = 'name']");
    private final By SECONDVALUES = By.xpath(".//span[@class = 'temp']");

    public WeatherPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public Map<String, List> getElementsFromWeatherPage() {
        Map<String, List> weatherPageMap = new HashMap<String, List>();
        List<WebElement> elementsFromWeatherPage = baseFunc.getElements(ALL_ELEMENTS);

        List<Integer> valuesIntegersFromWeatherPage = new ArrayList<Integer>();
        for (WebElement weatherPageElements : elementsFromWeatherPage) {
            String secondValue = weatherPageElements.findElement(SECONDVALUES).getText();
            secondValue = secondValue.substring(0, secondValue.length() - 1);
            valuesIntegersFromWeatherPage.add(Integer.valueOf(secondValue));
            String secondCities = weatherPageElements.findElement(SECONDVALUES).getText();

            weatherPageMap.put(secondCities, valuesIntegersFromWeatherPage);
        }

        return weatherPageMap;
    }
}