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
    private final By LINK = By.xpath(".//a[@data-seoname = 'latvija/daugavpils']");


    public CitiesPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public Map<String, List> addCityRezekne(Map<String, List> mapToAdd) {

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

    public CitiesPage fillField(String text) {

        WebElement field = baseFunc.getElement(FORM).findElement(TEXT_FIELD);
        baseFunc.writeInTextBox(field, text);

        baseFunc.waitForElement(LINK);
        baseFunc.getElement(LINK).click();
        return new CitiesPage(baseFunc);
    }

    public Map<String, List> addCityDaugavpils(Map<String, List> mapToAdd) {

        baseFunc.waitForElement(CITY_NAME);
        WebElement daugavpils = baseFunc.getElement(CITY_NAME);

        List<WebElement> daugavpilsDegrees = baseFunc.getElements(CITY_TEMBERATURE);
        List<Integer> daugavpilsTemperatures = new ArrayList<Integer>();
        for (WebElement daugavpilsTemperature : daugavpilsDegrees) {
            daugavpilsTemperatures.add(Integer.valueOf(daugavpilsTemperature.getText().substring(0, daugavpilsTemperature.getText().length() - 1)));
        }
        mapToAdd.put(daugavpils.getText(), daugavpilsTemperatures);

        return mapToAdd;

    }
}