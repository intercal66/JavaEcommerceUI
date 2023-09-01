package login;

import base.AutoTemplate;
import models.UserInputPlaceholder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.Utils;

public class LoginPlaceholderTests extends AutoTemplate {
    private static final Logger logger = LogManager.getLogger(LoginPlaceholderTests.class);

    @BeforeMethod
    public void setupTest() {
        logger.info("Starting Test: {}", getClass().getSimpleName());
        Utils.setPageLoadTimeout(10);
        Utils.explicitWaitForWebElementToBeClickableAndClick(mainHomePage.myAccountButton, 10);
    }

    @Test
    public void emailPlaceholderDisplayedOnLoginPage() {
        logger.info("Starting Test: Verify that the 'E-Mail' placeholder and correct text is displayed on the Login Page");
        String expectedPlaceholderText = UserInputPlaceholder.getEmailAddressPlaceholderText();
        userInputPlaceholderAssertion.assertPlaceholder(expectedPlaceholderText, userFormInputs.emailInput);
        logger.debug("Test Completed: 'E-Mail' placeholder and text verification on the Login Page");
    }

    @Test
    public void passwordPlaceholderDisplayedOnLoginPage() {
        logger.info("Starting Test: Verify that the 'Password' placeholder and correct text is displayed on the Login Page");
        String expectedPlaceholderText = UserInputPlaceholder.getPasswordPlaceholderText();
        userInputPlaceholderAssertion.assertPlaceholder(expectedPlaceholderText, userFormInputs.passwordInput);
        logger.debug("Test Completed: 'Password' placeholder and text verification on the Login Page");
    }
}
