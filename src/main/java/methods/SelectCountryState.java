package methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Utils;

public class SelectCountryState {

    public void selectCountry(String country) {
        String xpathLocator = String.format("//*[@id=\"input-payment-country\"]/option[contains(text(), \"%s\")]", country);
        WebElement countryNameSelect = Utils.explicitWaitForElementLocator(By.xpath(xpathLocator), 6);
        countryNameSelect.click();
    }

    public void selectRegionState(String regionState) {
        String xpathLocator = String.format("//*[@id=\"input-payment-zone\"]/option[contains(text(), \"%s\")]", regionState);
        WebElement regionStateSelect = Utils.explicitWaitForElementLocator(By.xpath(xpathLocator), 6);
        regionStateSelect.click();
    }

    public SelectCountryState(WebDriver driver) {
    }
}
