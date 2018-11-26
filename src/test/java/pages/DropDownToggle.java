package pages;

import org.openqa.selenium.By;

public class DropDownToggle {
    private final By WEATHER = By.xpath(".//span[contains(text(), 'Прогноз']");

    BaseFunc baseFunc;

    public DropDownToggle (BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void ClickOnWeather () {
        baseFunc.getElement(WEATHER).click();
    }
}
