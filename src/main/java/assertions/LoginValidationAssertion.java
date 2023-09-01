package assertions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pagesPOM.ErrorMessageHandler;

public class LoginValidationAssertion {
    private static final Logger logger = LogManager.getLogger(LoginValidationAssertion.class);
private final ErrorMessageHandler errorMessageHandler;
    public LoginValidationAssertion(WebDriver driver) {
        this.errorMessageHandler = new ErrorMessageHandler(driver);
    }

    public void assertLoginValidation() {
        String expectedMessage = "Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour.";
        String actualMessage = errorMessageHandler.getLoginWarningMessage();
        logger.debug("Asserting Login validation: actual = '{}', expected = '{}'", actualMessage, expectedMessage);
        Assert.assertEquals(actualMessage, expectedMessage, "Error: Login warning message does not match");
    }

    public void assertLoginIncorrectValidation() {
        String expectedMessage = "Warning: No match for E-Mail Address and/or Password.";
        String actualMessage = errorMessageHandler.getLoginWarningMessage();
        logger.debug("Asserting Incorrect Login validation: actual = '{}', expected = '{}'", actualMessage, expectedMessage);
        Assert.assertEquals(actualMessage, expectedMessage, "Error: Incorrect Login warning message does not match");
    }
}
