package methods;

import base.AutoTemplate;
import models.ProductProperties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.Utils;

import java.io.IOException;

public class SelectProduct extends AutoTemplate {
    private static final Logger logger = LogManager.getLogger(SelectProduct.class);

    public void clickOnProductLocator() throws IOException {
        By elementLocator = By.xpath(ProductProperties.getXpathLocatorItem());
        Utils.explicitWaitForElementToBeClickableAndClick(elementLocator, 10);
        logger.info("Clicked on the Product locator: {}", elementLocator);
    }

    public SelectProduct(WebDriver driver) {
        this.driver = driver;
    }
}
