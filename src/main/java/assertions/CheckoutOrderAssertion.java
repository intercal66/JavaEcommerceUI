package assertions;

import models.ProductProperties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pagesPOM.ConfirmOrderPage;
import pagesPOM.MainHomePage;

import java.io.IOException;

public class CheckoutOrderAssertion {
    private static final Logger logger = LogManager.getLogger(CheckoutOrderAssertion.class);
    private final ConfirmOrderPage confirmOrderPage;
    private final MainHomePage mainHomePage;

    public void assertProductName() throws IOException {
        String actualText = confirmOrderPage.productNameConfirm.getText();
        String expectedText = ProductProperties.getSearchItem();
        logger.debug("Asserting Product Name: actual = '{}', expected = '{}'", actualText, expectedText);
        Assert.assertEquals(actualText, expectedText, "Product Name does not match");
    }
    public void assertOrderConfirm() {
        String actualMessage = mainHomePage.mainHeadingH1Element.getText().trim();
        String expectedMessage = "Your order has been placed!";
        logger.debug("Asserting Order Confirmation message: actual = '{}', expected = '{}'", actualMessage, expectedMessage);
        Assert.assertEquals(actualMessage, expectedMessage, "ERROR!: Order Confirmation message does not match");
    }

    public CheckoutOrderAssertion(WebDriver driver) {
        this.confirmOrderPage = new ConfirmOrderPage(driver);
        this.mainHomePage = new MainHomePage(driver);
    }
}