package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CitiesPage {
    BaseFunc baseFunc;

    private final By CITY_NAME = By.xpath(".//div[@class = 'country-name-date']/h1");
    private final By CITY_TEMBERATURE = By.xpath(".//span[@class = 'temp']");
    private final By FORM = By.xpath(".//div[@class = 'dweather2-search-field-inner-wrapper']");
    private final By TEXT_FIELD = By.xpath(".//input[@placeholder = 'Поиск']");

    public CitiesPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public Map<String, List> addWeather(Map<String, List> mapToAdd) {
        //Создаём новый метод addWeather ,который возвращает карту

        baseFunc.waitForElement(CITY_NAME);
        WebElement rezekne = baseFunc.getElement(CITY_NAME);

        List<WebElement> rezekneDegrees = baseFunc.getElements(CITY_TEMBERATURE);
        List<Integer> rezekneTemperatures = new ArrayList<Integer>();
        for (WebElement rezekneTemperature : rezekneDegrees) {
            rezekneTemperatures.add(Integer.valueOf(rezekneTemperature.getText().substring(0, rezekneTemperature.getText().length() - 1)));
        }
        mapToAdd.put(rezekne.getText(), rezekneTemperatures);


        return mapToAdd;
    }
}