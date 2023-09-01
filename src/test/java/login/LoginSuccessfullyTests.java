package login;

import base.AutoTemplate;
import factories.UserInputFactory;
import models.UserInput;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.JsonUserDataReader;
import utilities.Utils;

import java.io.IOException;

public class LoginSuccessfullyTests extends AutoTemplate {
    private static final Logger logger = LogManager.getLogger(LoginSuccessfullyTests.class);
    private static final String USER_EMAIL = "Email";
    private static final String USER_PASSWORD = "Password";

    @BeforeMethod
    public void setupTest() {
        logger.info("Starting Test: {}", getClass().getSimpleName());
        Utils.setPageLoadTimeout(10);
        Utils.explicitWaitForWebElementToBeClickableAndClick(mainHomePage.myAccountButton, 10);
    }

    @Test
    public void loginSuccessfullyWhenExistingAccount() throws IOException {
        logger.info("Starting Test: Login Successfully with existing account");
        UserInput userInput = UserInputFactory.createDefaultUserInput();
        userInput.setEmail(JsonUserDataReader.loadJsonUserData().getString(USER_EMAIL));
        userInput.setPassword(JsonUserDataReader.loadJsonUserData().getString(USER_PASSWORD));
        loginFactory.loginDefault(userInput);
        accountPage.loginButton.click();
        loginSuccessfullyAssertion.assertLoginSuccess();
        logger.info("Test Completed: Login Successfully with existing account");
    }

    @Test
    public void loginSuccessfullyWhenExistingAccountKeyEnter() throws IOException {
        logger.info("Starting Test: Login Successfully with existing account using Key Enter");
        UserInput userInput = UserInputFactory.createDefaultUserInput();
        userInput.setEmail(JsonUserDataReader.loadJsonUserData().getString(USER_EMAIL));
        userInput.setPassword(JsonUserDataReader.loadJsonUserData().getString(USER_PASSWORD));
        loginFactory.loginDefault(userInput);
        accountPage.loginButton.sendKeys(Keys.ENTER);
        loginSuccessfullyAssertion.assertLoginSuccess();
        logger.info("Test Completed: Login Successfully with existing account using Key Enter");
    }
}
