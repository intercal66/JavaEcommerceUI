package login;

import base.AutoTemplate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.Utils;

import java.io.IOException;

import static utilities.UrlPropertiesReader.getUrlProperty;

public class LoginLinkTests extends AutoTemplate {
    private static final Logger logger = LogManager.getLogger(LoginLinkTests.class);
    private static final String LOGIN_URL = "LoginEndpointUrl";
    private static final String FORGOTTEN_URL = "ForgottenEndpointUrl";

    @BeforeMethod
    public void setupTest() {
        logger.info("Starting Test: {}", getClass().getSimpleName());
        Utils.setPageLoadTimeout(10);
        Utils.explicitWaitForWebElementToBeClickableAndClick(mainHomePage.myAccountButton, 10);
    }

    @Test
    public void verifyLoginPageLink() throws IOException {
        logger.info("Starting Test: Verify Login Page link when navigate to Login Page");
        String expectedLink = getUrlProperty(LOGIN_URL);
        String actualLink = driver.getCurrentUrl();
        logger.debug("Asserting Login Page link: actual = '{}', expected = '{}'", actualLink, expectedLink);
        Assert.assertEquals(actualLink, expectedLink, "Error: Incorrect Login Page link");
        logger.info("Test Completed: Login Page link verification on the Login Page");
    }

    @Test
    public void verifyForgotPasswordLinkSetOnLoginPage() throws IOException {
        logger.info("Starting Test: Verify Forgotten Password link set when navigate to Login Page");
        String expectedLink = getUrlProperty(FORGOTTEN_URL);
        String actualLink = contentFormLinks.contentFormLinkElement.getAttribute("href");
        logger.debug("Asserting Forgotten Password link set: actual = '{}', expected = '{}'", actualLink, expectedLink);
        Assert.assertEquals(actualLink, expectedLink, "Error: Incorrect Forgotten Password link");
        logger.info("Test Completed: Forgotten Password link set verification on the Login Page");
    }
}
