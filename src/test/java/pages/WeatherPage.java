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
    private final By CITY_NAME = By.xpath(".//span[@class = 'name']");
    private final By TEMPERATURE = By.xpath(".//span[@class = 'temp']");
    private final By FORM = By.xpath(".//div[@class = 'dweather2-search-field-inner-wrapper']");
    private final By TEXT_FIELD = By.xpath(".//input[@placeholder = 'Поиск']");
    private final By LINK = By.xpath(".//a[@data-seoname = 'latvija/rezekne']");


    public WeatherPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }


    public Map<String, List> getElementsFromWeatherPage() {
        Map<String, List> weatherPageMap = new HashMap<String, List>();

        List<WebElement> elementsFromWeatherPage = baseFunc.getElements(ALL_ELEMENTS);

        for (WebElement we : elementsFromWeatherPage) {
            String cityName = we.findElement(CITY_NAME).getText();

            List<WebElement> degrees = we.findElements(TEMPERATURE);
            List<Integer> temperatures = new ArrayList<Integer>();
            for (WebElement temperature : degrees) {
                temperatures.add(Integer.valueOf(temperature.getText().substring(0, temperature.getText().length() - 1)));
            }

            weatherPageMap.put(cityName, temperatures);
        }

        return weatherPageMap;
    }

    public RezeknePage fillField(String text) {

        WebElement field = baseFunc.getElement(FORM).findElement(TEXT_FIELD);
        baseFunc.writeInTextBox(field, text);

        baseFunc.waitForElement(LINK);
        baseFunc.getElement(LINK).click();
        return new RezeknePage(baseFunc);
    }


}