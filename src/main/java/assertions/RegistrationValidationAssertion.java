package assertions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pagesPOM.ErrorMessageHandler;
import utilities.Utils;

public class RegistrationValidationAssertion {
    private static final Logger logger = LogManager.getLogger(RegistrationValidationAssertion.class);
    private final ErrorMessageHandler errorMessageHandler;

    public RegistrationValidationAssertion(WebDriver driver) {
        this.errorMessageHandler = new ErrorMessageHandler(driver);
    }

    public void assertFieldValidation(String fieldName, String expectedErrorMessage) {
        logger.info("'{}' validation asserting Started.", fieldName);
        String actualError = errorMessageHandler.getErrorMessageForLabel(fieldName);
        Assert.assertEquals(actualError, expectedErrorMessage, "Error message for " + fieldName + " was not as expected.");
        logger.debug("'{}' validation assertion Passed: {}", fieldName, actualError);
    }

    public void assertFirstNameValidation() {
        assertFieldValidation("First Name", "First Name must be between 1 and 32 characters!");
    }

    public void assertLastNameValidation() {
        assertFieldValidation("Last Name", "Last Name must be between 1 and 32 characters!");
    }

    public void assertEmailValidation() {
        assertFieldValidation("E-Mail", "E-Mail Address does not appear to be valid!");
    }

    public void assertTelephoneValidation() {
        assertFieldValidation("Telephone", "Telephone must be between 3 and 32 characters!");
    }

    public void assertPasswordValidation() {
        assertFieldValidation("Password", "Password must be between 4 and 20 characters!");
    }

    public void assertPasswordConfirmValidation() {
        assertFieldValidation("Password Confirm", "Password confirmation does not match password!");
    }

    public void assertWarningEmailValidation() {
        String actualMessage = errorMessageHandler.getRegisterWarningMessage();
        String expectedMessage = "Warning: E-Mail Address is already registered!";
        logger.debug("Asserting E-Mail validation Warning: actual = '{}', expected = '{}'", actualMessage, expectedMessage);
        Assert.assertEquals(actualMessage, expectedMessage, "Email validation warning message does not match");
    }

    public void assertEmailInvalidSet(String inputText) {
        boolean isValid = Utils.isEmailFormatValid(inputText);
        logger.debug("Validating E-Mail format set: input text = '{}', validation = '{}'", inputText, isValid);
        assert !isValid : "E-Mail format set is Valid";
    }

    public void assertPrivacyPolicyValidation() {
        String actualMessage = errorMessageHandler.getRegisterWarningMessage();
        String expectedMessage = "Warning: You must agree to the Privacy Policy!";
        logger.debug("Asserting Privacy Policy message: actual = '{}', expected = '{}'", actualMessage, expectedMessage);
        Assert.assertEquals(actualMessage, expectedMessage, "Error: Privacy Policy warning message does not match");
    }
}
