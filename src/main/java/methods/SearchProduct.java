package methods;

import base.AutoTemplate;
import models.ProductProperties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pagesPOM.MainSearchBar;

import java.io.IOException;

public class SearchProduct extends AutoTemplate {
    private static final Logger logger = LogManager.getLogger(SearchProduct.class);
    public void performSearchProduct() throws IOException {
        mainSearchBar.searchInput.sendKeys(ProductProperties.getSearchItem());
        logger.info("Performing Search for Product: {}", ProductProperties.getSearchItem());
        mainSearchBar.searchButton.click();
    }
    public SearchProduct(WebDriver driver){
        mainSearchBar = new MainSearchBar(driver);
    }
}
