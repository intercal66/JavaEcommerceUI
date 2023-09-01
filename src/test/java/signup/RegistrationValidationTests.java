package signup;

import base.AutoTemplate;
import factories.UserInputFactory;
import models.UserInput;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.Utils;

import java.io.IOException;

public class RegistrationValidationTests extends AutoTemplate {
    private static final Logger logger = LogManager.getLogger(RegistrationValidationTests.class);
    private static final String EMPTY_INPUT_FIELD = "";
    private static final String INVALID_EMAIL = "mail";
    private static final String USER_PASSWORD = "password";
    private static final String CONFIRM_PASSWORD = "password1";

    @BeforeMethod
    public void setupTest() {
        logger.info("Starting Test: {}", getClass().getSimpleName());
        Actions actions = new Actions(driver);
        Utils.setPageLoadTimeout(10);
        actions.moveToElement(mainHomePage.myAccountButton).perform();
        Utils.explicitWaitForWebElementToBeClickableAndClick(mainHomePage.registerButton, 10);
    }

    @Test
    public void firstNameValidationWhenEmpty() throws IOException {
        logger.debug("Starting Test: First Name validation displayed when 'First Name' is 'Empty'");
        UserInput userInput = UserInputFactory.createDefaultUserInput();
        userInput.setFirstName(EMPTY_INPUT_FIELD);
        registerFactory.registerDefault(userInput);
        accountPage.continueButton.click();
        registrationValidationAssertion.assertFirstNameValidation();
        logger.debug("Test Completed: First Name validation displayed when 'First Name' is 'Empty'");
    }

    @Test
    public void firstNameValidationWhenLength33Char() throws IOException {
        logger.debug("Starting Test: First Name validation displayed when 'First Name' length is '33-Characters'");
        UserInput userInput = UserInputFactory.createDefaultUserInput();
        userInput.setFirstName(utils.randomAlphabetic(33));
        registerFactory.registerDefault(userInput);
        accountPage.continueButton.click();
        registrationValidationAssertion.assertFirstNameValidation();
        logger.debug("Test Completed: First Name validation displayed when 'First Name' length is '33-Characters'");
    }

    @Test
    public void lastNameValidationWhenEmpty() throws IOException {
        logger.debug("Starting Test: Last Name validation displayed when 'Last Name' is 'Empty'");
        UserInput userInput = UserInputFactory.createDefaultUserInput();
        userInput.setLastName(EMPTY_INPUT_FIELD);
        registerFactory.registerDefault(userInput);
        accountPage.continueButton.click();
        registrationValidationAssertion.assertLastNameValidation();
        logger.debug("Test Completed: Last Name validation displayed when 'Last Name' is 'Empty'");
    }

    @Test
    public void lastNameValidationWhenLength33Char() throws IOException {
        logger.debug("Starting Test: Last Name validation displayed when 'Last Name' length is '33-Characters'");
        UserInput userInput = UserInputFactory.createDefaultUserInput();
        userInput.setLastName(utils.randomAlphabetic(33));
        registerFactory.registerDefault(userInput);
        accountPage.continueButton.click();
        registrationValidationAssertion.assertLastNameValidation();
        logger.debug("Test Completed: Last Name validation displayed when 'Last Name' length is '33-Characters'");
    }

    @Test
    public void emailValidationWhenEmpty() throws IOException {
        logger.debug("Starting Test: E-Mail validation displayed when 'E-Mail' is 'Empty'");
        UserInput userInput = UserInputFactory.createDefaultUserInput();
        userInput.setEmail(EMPTY_INPUT_FIELD);
        registerFactory.registerDefault(userInput);
        accountPage.continueButton.click();
        registrationValidationAssertion.assertEmailValidation();
        logger.debug("Test Completed: E-Mail validation displayed when 'E-Mail' is 'Empty'");
    }

    @Test
    public void emailValidationWhenSymbolSeparator() throws IOException {
        logger.debug("Starting Test: E-Mail validation displayed when 'E-Mail' contains a 'Symbol Separator'");
        UserInput userInput = UserInputFactory.createDefaultUserInput();
        userInput.setEmail("email" + "@" + utils.randomAlphabetic(4));
        registerFactory.registerDefault(userInput);
        accountPage.continueButton.click();
        registrationValidationAssertion.assertEmailValidation();
        logger.debug("Test Completed: E-Mail validation displayed when 'E-Mail' contains a 'Symbol Separator'");
    }

    @Test
    public void emailValidationWhenIncorrectSet() throws IOException {
        logger.debug("Starting Test: E-Mail validation displayed when 'E-Mail' is 'Incorrect Set' format");
        UserInput userInput = UserInputFactory.createDefaultUserInput();
        userInput.setEmail(INVALID_EMAIL);
        registerFactory.registerDefault(userInput);
        accountPage.continueButton.click();
        registrationValidationAssertion.assertEmailInvalidSet(userInput.getEmail());
        logger.debug("Test Completed: E-Mail validation displayed when 'E-Mail' is 'Incorrect Set' format");
    }

    @Test
    public void telephoneValidationWhenEmpty() throws IOException {
        logger.debug("Starting Test: Telephone validation displayed when 'Telephone' is 'Empty'");
        UserInput userInput = UserInputFactory.createDefaultUserInput();
        userInput.setTelephone(EMPTY_INPUT_FIELD);
        registerFactory.registerDefault(userInput);
        accountPage.continueButton.click();
        registrationValidationAssertion.assertTelephoneValidation();
        logger.debug("Test Completed: Telephone validation displayed when 'Telephone' is 'Empty'");
    }

    @Test
    public void telephoneValidationWhenLength1Char() throws IOException {
        logger.debug("Starting Test: Telephone validation displayed when 'Telephone' is '1-Character'");
        UserInput userInput = UserInputFactory.createDefaultUserInput();
        userInput.setTelephone(utils.randomNumeric(1));
        registerFactory.registerDefault(userInput);
        accountPage.continueButton.click();
        registrationValidationAssertion.assertTelephoneValidation();
        logger.debug("Test Completed: Telephone validation displayed when 'Telephone' is '1-Character'");
    }

    @Test
    public void telephoneValidationWhenLength2Char() throws IOException {
        logger.debug("Starting Test: Telephone validation displayed when 'Telephone' length is '2-Characters'");
        UserInput userInput = UserInputFactory.createDefaultUserInput();
        userInput.setTelephone(utils.randomNumeric(2));
        registerFactory.registerDefault(userInput);
        accountPage.continueButton.click();
        registrationValidationAssertion.assertTelephoneValidation();
        logger.debug("Test Completed: Telephone validation displayed when 'Telephone' length is '2-Characters'");
    }

    @Test
    public void telephoneValidationWhenLength33Char() throws IOException {
        logger.debug("Starting Test: Telephone validation displayed when 'Telephone' length is '33-Characters'");
        UserInput userInput = UserInputFactory.createDefaultUserInput();
        userInput.setTelephone(utils.randomNumeric(33));
        registerFactory.registerDefault(userInput);
        accountPage.continueButton.click();
        registrationValidationAssertion.assertTelephoneValidation();
        logger.debug("Test Completed: Telephone validation displayed when 'Telephone' length is '33-Characters'");
    }

    @Test
    public void passwordDisplayedEncrypted() {
        logger.debug("Starting Test: Password displayed 'Encrypted' when type Password");
        String actualType = userFormInputs.passwordInput.getAttribute("type");
        Assert.assertEquals(USER_PASSWORD, actualType, "Error: Password input field is not encrypted");
        logger.debug("Password input field is 'Encrypted': actual = '{}'", actualType);
        logger.debug("Test Completed: Password displayed 'Encrypted' when type Password");
    }

    @Test
    public void passwordValidationWhenEmpty() throws IOException {
        logger.debug("Starting Test: Password validation displayed when 'Password' is 'Empty'");
        UserInput userInput = UserInputFactory.createDefaultUserInput();
        userInput.setPassword(EMPTY_INPUT_FIELD);
        registerFactory.registerDefault(userInput);
        accountPage.continueButton.click();
        registrationValidationAssertion.assertPasswordValidation();
        logger.debug("Test Completed: Password validation displayed when 'Password' is 'Empty'");
    }

    @Test
    public void passwordValidationWhenLength1Char() throws IOException {
        logger.debug("Starting Test: Password validation displayed when 'Password' is '1-Character'");
        UserInput userInput = UserInputFactory.createDefaultUserInput();
        userInput.setPassword(utils.randomAlphaNumeric(1));
        registerFactory.registerDefault(userInput);
        accountPage.continueButton.click();
        registrationValidationAssertion.assertPasswordValidation();
        logger.debug("Test Completed: Password validation displayed when 'Password' is '1-Character'");
    }

    @Test
    public void passwordValidationWhenLength2Char() throws IOException {
        logger.debug("Starting Test: Password validation displayed when 'Password' length is '2-Characters'");
        UserInput userInput = UserInputFactory.createDefaultUserInput();
        userInput.setPassword(utils.randomAlphaNumeric(2));
        registerFactory.registerDefault(userInput);
        accountPage.continueButton.click();
        registrationValidationAssertion.assertPasswordValidation();
        logger.debug("Test Completed: Password validation displayed when 'Password' length is '2-Characters'");
    }

    @Test
    public void passwordValidationWhenLength3Char() throws IOException {
        logger.debug("Starting Test: Password validation displayed when 'Password' length is '3-Characters'");
        UserInput userInput = UserInputFactory.createDefaultUserInput();
        userInput.setPassword(utils.randomAlphaNumeric(3));
        registerFactory.registerDefault(userInput);
        accountPage.continueButton.click();
        registrationValidationAssertion.assertPasswordValidation();
        logger.debug("Test Completed: Password validation displayed when 'Password' length is '3-Characters'");
    }

    @Test // ---------------> Bug <-----------------
    public void passwordValidationWhenLength21Char() throws IOException {
        logger.debug("Starting Test: Password validation displayed when 'Password' length is '21-Characters'");
        UserInput userInput = UserInputFactory.createDefaultUserInput();
        userInput.setPassword(utils.randomAlphaNumeric(21));
        registerFactory.registerDefault(userInput);
        accountPage.continueButton.click();
        registrationValidationAssertion.assertPasswordValidation();
        logger.debug("Test Completed: Password validation displayed when 'Password' length is '21-Characters'");
    }

    @Test
    public void passwordValidationWhenLength41Char() throws IOException {
        logger.debug("Starting Test: Password validation displayed when 'Password' length is '41-Characters'");
        UserInput userInput = UserInputFactory.createDefaultUserInput();
        userInput.setPassword(utils.randomAlphaNumeric(41));
        registerFactory.registerDefault(userInput);
        accountPage.continueButton.click();
        registrationValidationAssertion.assertPasswordValidation();
        logger.debug("Test Completed: Password validation displayed when 'Password' length is '41-Characters'");
    }

    @Test
    public void passwordConfirmDisplayedEncrypted() {
        logger.debug("Starting Test: Password Confirmation displayed 'Encrypted' when type 'Password'");
        String actualType = userFormInputs.passwordConfirmInput.getAttribute("type");
        Assert.assertEquals(USER_PASSWORD, actualType, "Error: Password input field is not encrypted");
        logger.debug("Password input field is 'Encrypted': actual = '{}'", actualType);
        logger.debug("Test Completed: Password Confirmation displayed 'Encrypted' when type 'Password'");
    }

    @Test
    public void passwordConfirmValidationWhenEmpty() throws IOException {
        logger.debug("Starting Test: Password Confirmation validation displayed when 'Password Confirm' is 'Empty'");
        UserInput userInput = UserInputFactory.createDefaultUserInput();
        userInput.setPassword(USER_PASSWORD);
        userInput.setPasswordConfirm(EMPTY_INPUT_FIELD);
        registerFactory.registerDefault(userInput);
        accountPage.continueButton.click();
        registrationValidationAssertion.assertPasswordConfirmValidation();
        logger.debug("Test Completed: Password Confirmation validation displayed when 'Password Confirm' is 'Empty'");
    }

    @Test
    public void passwordConfirmValidationWhenMismatch() throws IOException {
        logger.debug("Starting Test: Password Confirmation validation displayed when Password Confirm 'Mismatch'");
        UserInput userInput = UserInputFactory.createDefaultUserInput();
        userInput.setPassword(USER_PASSWORD);
        userInput.setPasswordConfirm(CONFIRM_PASSWORD);
        registerFactory.registerDefault(userInput);
        accountPage.continueButton.click();
        registrationValidationAssertion.assertPasswordConfirmValidation();
        logger.debug("Test Completed: Password Confirmation validation displayed when Password Confirm 'Mismatch'");
    }

    @Test
    public void privacyPolicyValidationWhenNotAgree() throws IOException {
        logger.debug("Starting Test: Privacy Policy not checked validation displayed when 'Not Agree'");
        UserInput userInput = UserInputFactory.createDefaultUserInput();
        userInput.setAgreePrivacyPolicy(false);
        registerFactory.registerDefault(userInput);
        accountPage.continueButton.click();
        registrationValidationAssertion.assertPrivacyPolicyValidation();
        logger.debug("Test Completed: Privacy Policy not checked validation displayed when 'Not Agree'");
    }
}
