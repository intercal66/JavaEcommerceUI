package checkout;

import base.AutoTemplate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.Utils;

import java.io.IOException;

import static utilities.UrlPropertiesReader.getUrlProperty;

public class CheckoutAddressLinkTests extends AutoTemplate {
    private static final Logger logger = LogManager.getLogger(CheckoutAddressLinkTests.class);
    private static final String CHECKOUT_URL = "CheckoutEndpointUrl";
    private static final String POLICY_URL = "PolicyEndpointUrl";
    private static final String TERMS_URL = "TermsEndpointUrl";

    @BeforeMethod
    public void setupTest() throws IOException {
        logger.info("Starting Test: {}", getClass().getSimpleName());
        Utils.setPageLoadTimeout(10);
    }

    public void performCheckoutFlow() throws IOException {
        searchProduct.performSearchProduct();
        selectProduct.clickOnProductLocator();
        addProduct.addItemToCart();
    }

    @Test
    public void verifyCheckoutPageLinkOnCheckoutPage() throws IOException {
        logger.info("Starting Test: Verify Checkout Page link when navigate to Checkout Page");
        performCheckoutFlow();
        String expectedURL = getUrlProperty(CHECKOUT_URL);
        String actualURL = Utils.waitForURLToBeDisplayedAndGetCurrentURL(expectedURL, 4);
        logger.debug("Asserting Checkout Page link: actual = '{}', expected = '{}'", actualURL, expectedURL);
        Assert.assertEquals(actualURL, expectedURL, "Error: Incorrect Checkout Page link");
        logger.debug("Test Completed: Checkout Page link verification on the Checkout Page");
    }

    @Test
    public void verifyPrivacyPolicyLinkOnCheckoutPage() throws IOException {
        logger.info("Starting Test: Verify Privacy Policy link set when navigate to Checkout Page");
        performCheckoutFlow();
        String expectedURL = getUrlProperty(POLICY_URL);
        String actualURL = userFormInputs.privacyPolicyLink.getAttribute("href");
        logger.debug("Asserting Privacy Policy link set: actual = '{}', expected = '{}'", actualURL, expectedURL);
        Assert.assertEquals(actualURL, expectedURL, "Error: Incorrect Privacy Policy link set");
        logger.debug("Test Completed: Privacy Policy link verification on the Checkout Page");
    }

    @Test
    public void verifyTermsConditionsLinkOnCheckoutPage() throws IOException {
        logger.info("Starting Test: Verify Terms & Conditions link set when navigate to Checkout Page");
        performCheckoutFlow();
        String expectedURL = getUrlProperty(TERMS_URL);
        String actualURL = userFormInputs.privacyTermsLink.getAttribute("href");
        logger.debug("Asserting Terms & Conditions link set: actual = '{}', expected = '{}'", actualURL, expectedURL);
        Assert.assertEquals(actualURL, expectedURL, "Error: Incorrect Terms & Conditions link set");
        logger.debug("Test Completed: Terms & Conditions link verification on the Checkout Page");
    }
}
