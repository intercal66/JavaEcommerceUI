package methods;

import base.AutoTemplate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pagesPOM.CartProductPage;
import pagesPOM.MainProductPage;
import utilities.Utils;

public class AddProduct extends AutoTemplate {
    private static final Logger logger = LogManager.getLogger(AddProduct.class);

    public void addItemToCart() {
        logger.info("Adding item to cart.");
        mainProductPage.addToCartButton.click();
        cartProductPage.itemCheckCartButton.click();
        Utils.explicitWaitElementToBeClickable(cartProductPage.checkoutButton, 10);
        cartProductPage.editCartButton.click();
        cartProductPage.checkoutShoppingCartButton.click();
    }

    public AddProduct(WebDriver driver) {
        mainProductPage = new MainProductPage(driver);
        cartProductPage = new CartProductPage(driver);
        utils = new Utils(driver);
    }
}
