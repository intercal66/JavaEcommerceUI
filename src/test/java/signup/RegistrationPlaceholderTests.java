package signup;

import base.AutoTemplate;
import models.UserInputPlaceholder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.Utils;

public class RegistrationPlaceholderTests extends AutoTemplate {
    private static final Logger logger = LogManager.getLogger(RegistrationPlaceholderTests.class);

    @BeforeMethod
    public void setupTest() {
        logger.info("Starting Test: {}", getClass().getSimpleName());
        Actions actions = new Actions(driver);
        Utils.setPageLoadTimeout(10);
        actions.moveToElement(mainHomePage.myAccountButton).perform();
        Utils.explicitWaitForWebElementToBeClickableAndClick(mainHomePage.registerButton, 10);
    }

    @Test
    public void firstNamePlaceholderDisplayedOnRegisterPage() {
        logger.info("Starting Test: Verify that the 'First Name' placeholder and correct text is displayed on the Registration Page");
        String expectedPlaceholderText = UserInputPlaceholder.getFirstNamePlaceholderText();
        userInputPlaceholderAssertion.assertPlaceholder(expectedPlaceholderText, userFormInputs.firstNameInput);
        logger.debug("Test Completed: 'First Name' placeholder and text verification on the Registration Page");
    }

    @Test
    public void lastNamePlaceholderDisplayedOnRegisterPage() {
        logger.info("Starting Test: Verify that the 'Last Name' placeholder and correct text is displayed on the Registration Page");
        String expectedPlaceholderText = UserInputPlaceholder.getLastNamePlaceholderText();
        userInputPlaceholderAssertion.assertPlaceholder(expectedPlaceholderText, userFormInputs.lastNameInput);
        logger.debug("Test Completed: 'Last Name' placeholder and text verification on the Registration Page");
    }

    @Test
    public void emailPlaceholderDisplayedOnRegisterPage() {
        logger.info("Starting Test: Verify that the 'E-Mail' placeholder and correct text is displayed on the Registration Page");
        String expectedPlaceholderText = UserInputPlaceholder.getEmailPlaceholderText();
        userInputPlaceholderAssertion.assertPlaceholder(expectedPlaceholderText, userFormInputs.emailInput);
        logger.debug("Test Completed: 'E-Mail' placeholder and text verification on the Registration Page");
    }

    @Test
    public void telephonePlaceholderDisplayedOnRegisterPage() {
        logger.info("Starting Test: Verify that the 'Telephone' placeholder and correct text is displayed on the Registration Page");
        String expectedPlaceholderText = UserInputPlaceholder.getTelephonePlaceholderText();
        userInputPlaceholderAssertion.assertPlaceholder(expectedPlaceholderText, userFormInputs.telephoneInput);
        logger.debug("Test Completed: 'Telephone' placeholder and text verification on the Registration Page");
    }

    @Test
    public void passwordPlaceholderDisplayedOnRegisterPage() {
        logger.info("Starting Test: Verify that the 'Password' placeholder and correct text is displayed on the Registration Page");
        String expectedPlaceholderText = UserInputPlaceholder.getPasswordPlaceholderText();
        userInputPlaceholderAssertion.assertPlaceholder(expectedPlaceholderText, userFormInputs.passwordInput);
        logger.debug("Test Completed: 'Password' placeholder and text verification on the Registration Page");
    }

    @Test
    public void passwordConfirmPlaceholderDisplayedOnRegisterPage() {
        logger.info("Starting Test: Verify that the 'Password Confirm' placeholder and correct text is displayed on the Registration Page");
        String expectedPlaceholderText = UserInputPlaceholder.getPasswordConfirmPlaceholderText();
        userInputPlaceholderAssertion.assertPlaceholder(expectedPlaceholderText, userFormInputs.passwordConfirmInput);
        logger.debug("Test Completed: 'Password Confirm' placeholder and text verification on the Registration Page");
    }
}
