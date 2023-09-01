package signup;

import base.AutoTemplate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.Utils;

import java.io.IOException;

import static utilities.UrlPropertiesReader.getUrlProperty;

public class RegistrationLinkTests extends AutoTemplate {
    private static final Logger logger = LogManager.getLogger(RegistrationLinkTests.class);
    private static final String REGISTER_URL = "RegisterEndpointUrl";
    private static final String POLICY_URL = "PolicyEndpointUrl";
    private static final String LOGIN_URL = "LoginEndpointUrl";

    @BeforeMethod
    public void setupTest() {
        logger.info("Starting Test: {}", getClass().getSimpleName());
        Actions actions = new Actions(driver);
        Utils.setPageLoadTimeout(10);
        actions.moveToElement(mainHomePage.myAccountButton).perform();
        Utils.explicitWaitForWebElementToBeClickableAndClick(mainHomePage.registerButton, 10);
    }

    @Test
    public void verifyRegisterPageLink() throws IOException {
        logger.info("Starting Test: Verify Register Page link when navigate to Registration Page");
        String expectedLink = getUrlProperty(REGISTER_URL);
        String actualLink = driver.getCurrentUrl();
        logger.debug("Asserting Register Page link: actual = '{}', expected = '{}'", actualLink, expectedLink);
        Assert.assertEquals(actualLink, expectedLink, "Error: Incorrect Register Page link");
        logger.debug("Test Completed: Register Page link verification on the Registration Page");
    }

    @Test
    public void verifyPrivacyPolicyLinkSetOnRegisterPage() throws IOException {
        logger.info("Starting Test: Verify Privacy Policy link set when navigate to Registration Page");
        String expectedLink = getUrlProperty(POLICY_URL);
        String actualLink = userFormInputs.privacyPolicyLink.getAttribute("href");
        logger.debug("Asserting Privacy Policy link set: actual = '{}', expected = '{}'", actualLink, expectedLink);
        Assert.assertEquals(actualLink, expectedLink, "Error: Incorrect Privacy Policy link");
        logger.debug("Test Completed: Privacy Policy link set verification on the Registration Page");
    }

    @Test
    public void verifyLoginPageLinkSetOnRegisterPage() throws IOException {
        logger.info("Starting Test: Verify Login Page link set when navigate to Registration Page");
        String expectedLink = getUrlProperty(LOGIN_URL);
        String actualLink = userFormInputs.loginLink.getAttribute("href");
        logger.debug("Asserting Login Page link set: actual = '{}', expected = '{}'", actualLink, expectedLink);
        Assert.assertEquals(actualLink, expectedLink, "Error: Incorrect Login Page link");
        logger.debug("Test Completed: Login Page link set verification on the Registration Page");
    }
}
