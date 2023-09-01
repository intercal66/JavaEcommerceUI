package login;

import base.AutoTemplate;
import factories.UserInputFactory;
import models.UserInput;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.Utils;

import java.io.IOException;

public class LoginValidationTests extends AutoTemplate {
    private static final Logger logger = LogManager.getLogger(LoginValidationTests.class);
    private static final String EMPTY_INPUT_FIELD = "";
    private static final String INVALID_EMAIL = "mail@mail.com";
    private static final String INVALID_PASSWORD = "password1";

    @BeforeMethod
    public void setupTest() {
        logger.info("Starting Test: {}", getClass().getSimpleName());
        Utils.setPageLoadTimeout(10);
        Utils.explicitWaitForWebElementToBeClickableAndClick(mainHomePage.myAccountButton, 10);
    }

    @Test
    public void loginValidationWhenEmailEmpty() throws IOException {
        logger.debug("Starting Test: Login E-Mail validation displayed when 'E-Mail' is 'Empty'");
        UserInput userInput = UserInputFactory.createDefaultUserInput();
        userInput.setEmail(EMPTY_INPUT_FIELD);
        loginFactory.loginDefault(userInput);
        accountPage.loginButton.click();
        loginValidationAssertion.assertLoginValidation();
        logger.debug("Test Completed: Login E-Mail validation displayed when 'E-Mail' is 'Empty'");
    }

    @Test
    public void loginValidationWhenPasswordEmpty() throws IOException {
        logger.debug("Starting Test: Login Password validation displayed when 'Password' is 'Empty'");
        UserInput userInput = UserInputFactory.createDefaultUserInput();
        userInput.setPassword(EMPTY_INPUT_FIELD);
        loginFactory.loginDefault(userInput);
        accountPage.loginButton.click();
        loginValidationAssertion.assertLoginIncorrectValidation();
        logger.debug("Test Completed: Login Password validation displayed when 'Password' is 'Empty'");
    }

    @Test
    public void loginValidationWhenEmailAndPasswordEmpty() throws IOException {
        logger.debug("Starting Test: Login validation displayed when 'E-Mail & Password' is 'Empty'");
        UserInput userInput = UserInputFactory.createDefaultUserInput();
        userInput.setEmail(EMPTY_INPUT_FIELD);
        userInput.setPassword(EMPTY_INPUT_FIELD);
        loginFactory.loginDefault(userInput);
        accountPage.loginButton.click();
        loginValidationAssertion.assertLoginIncorrectValidation();
        logger.debug("Test Completed: Login validation displayed when 'E-Mail & Password' is 'Empty'");
    }

    @Test
    public void loginValidationWhenInvalidEmailAndPassword() throws IOException {
        logger.debug("Starting Test: Login validation displayed when 'E-Mail & Password' is 'Invalid'");
        UserInput userInput = UserInputFactory.createDefaultUserInput();
        userInput.setEmail(INVALID_EMAIL);
        userInput.setPassword(INVALID_PASSWORD);
        loginFactory.loginDefault(userInput);
        accountPage.loginButton.click();
        loginValidationAssertion.assertLoginIncorrectValidation();
        logger.debug("Test Completed: Login validation displayed when 'E-Mail & Password' is 'Invalid'");
    }
}
