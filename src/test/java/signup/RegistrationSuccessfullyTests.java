package signup;

import base.AutoTemplate;
import factories.UserInputFactory;
import models.UserInput;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.JsonTelephoneDataReader;
import utilities.Utils;

import java.io.FileNotFoundException;
import java.io.IOException;

public class RegistrationSuccessfullyTests extends AutoTemplate {
    private static final Logger logger = LogManager.getLogger(RegistrationSuccessfullyTests.class);
    private static final String SAMPLE_PASSWORD = "pass";

    @BeforeMethod
    public void setupTest() {
        logger.info("Starting Test: {}", getClass().getSimpleName());
        Actions actions = new Actions(driver);
        Utils.setPageLoadTimeout(10);
        actions.moveToElement(mainHomePage.myAccountButton).perform();
        Utils.explicitWaitForWebElementToBeClickableAndClick(mainHomePage.registerButton, 10);
    }

    @DataProvider(name = "validTelephoneNumbers")
    public Object[][] validTelephoneNumbers() throws FileNotFoundException {
        JSONObject phoneData = JsonTelephoneDataReader.loadJsonTelephoneData();
        return new Object[][]{
                {phoneData.getString("ValidTelephoneNumberUk")},
                {phoneData.getString("ValidTelephoneNumberDe")},
                {phoneData.getString("ValidTelephoneNumberCh")},
        };
    }

    public void assertRegistrationSuccess() {
        registrationSuccessfullyAssertion.assertAccountCreationSuccess();
    }

    public void performLogout() {
        rightColumnButtons.logOutButton().click();
    }

    @Test
    public void registerSuccessWithAllFieldsFilled() throws IOException {
        logger.info("Starting Test: User Register Successfully with all fields filled");
        UserInput userInput = UserInputFactory.createDefaultUserInput();
        registerFactory.registerDefault(userInput);
        accountPage.continueButton.click();
        assertRegistrationSuccess();
        performLogout();
        logger.info("Test Completed: User Created Successfully when all required fields filled");
    }

    @Test
    public void registerSuccessWithAllFieldsFieldFilledKeyEnter() throws IOException {
        logger.info("Starting Test: User Register Successfully with all fields filled and press Enter");
        UserInput userInput = UserInputFactory.createDefaultUserInput();
        registerFactory.registerDefault(userInput);
        accountPage.continueButton.sendKeys(Keys.ENTER);
        assertRegistrationSuccess();
        performLogout();
        logger.info("Test Completed: User Created Successfully when all required fields filled and pressed Enter");
    }

    @Test
    public void registerSuccessWhenFirstNameLength1Char() throws IOException {
        logger.info("Starting Test: User Registration Success with '1-Character First Name'");
        UserInput userInput = UserInputFactory.createDefaultUserInput();
        userInput.setFirstName(utils.randomAlphabetic(1));
        registerFactory.registerDefault(userInput);
        accountPage.continueButton.click();
        assertRegistrationSuccess();
        performLogout();
        logger.info("Test Completed: User Successfully Created with '1-Character First Name'");
    }

    @Test
    public void registerSuccessWhenFirstNameLength32Char() throws IOException {
        logger.info("Starting Test: User Registration Success with '32-Characters First Name'");
        UserInput userInput = UserInputFactory.createDefaultUserInput();
        userInput.setFirstName(utils.randomAlphabetic(32));
        registerFactory.registerDefault(userInput);
        accountPage.continueButton.click();
        assertRegistrationSuccess();
        performLogout();
        logger.info("Test Completed: User Successfully Created with '32-Characters First Name'");
    }

    @Test
    public void registerSuccessWhenLastNameLength1Char() throws IOException {
        logger.info("Starting Test: User Registration Success with '1-Character Last Name'");
        UserInput userInput = UserInputFactory.createDefaultUserInput();
        userInput.setLastName(utils.randomAlphabetic(1));
        registerFactory.registerDefault(userInput);
        accountPage.continueButton.click();
        assertRegistrationSuccess();
        performLogout();
        logger.info("Test Completed: User Successfully Created with '1-Character Last Name'");
    }

    @Test
    public void registerSuccessWhenLastNameLength32Char() throws IOException {
        logger.info("Starting Test: User Registration Success with '32-Characters Last Name'");
        UserInput userInput = UserInputFactory.createDefaultUserInput();
        userInput.setLastName(utils.randomAlphabetic(32));
        registerFactory.registerDefault(userInput);
        accountPage.continueButton.click();
        assertRegistrationSuccess();
        performLogout();
        logger.info("Test Completed: User Successfully Created with '32-Characters Last Name'");
    }

    @Test
    public void registerSuccessWhenEmailLength4Char() throws IOException {
        logger.info("Starting Test: User Registration Success with '4-Characters E-Mail'");
        UserInput userInput = UserInputFactory.createDefaultUserInput();
        userInput.setEmail(utils.randomAlphaNumeric(1) + "@" + utils.randomAlphabetic(1) + ".a");
        registerFactory.registerDefault(userInput);
        accountPage.continueButton.click();
        assertRegistrationSuccess();
        performLogout();
        logger.info("Test Completed: User Successfully Created with '4-Characters E-Mail'");
    }

    @Test
    public void registerSuccessWhenEmailLength32Char() throws IOException {
        logger.info("Starting Test: User Registration Success with '32-Characters E-Mail'");
        UserInput userInput = UserInputFactory.createDefaultUserInput();
        userInput.setEmail(utils.randomAlphaNumeric(11) + "@" + utils.randomAlphabetic(11) + ".com");
        registerFactory.registerDefault(userInput);
        accountPage.continueButton.click();
        assertRegistrationSuccess();
        performLogout();
        logger.info("Test Completed: User Successfully Created with '32-Characters E-Mail'");
    }

    @Test
    public void registerSuccessWhenTelephoneLength3Char() throws IOException {
        logger.info("Starting Test: User Registration Success with '3-Characters Telephone'");
        UserInput userInput = UserInputFactory.createDefaultUserInput();
        userInput.setTelephone(utils.randomNumeric(3));
        registerFactory.registerDefault(userInput);
        accountPage.continueButton.click();
        assertRegistrationSuccess();
        performLogout();
        logger.info("Test Completed: User Successfully Created with '3-Characters Telephone'");
    }

    @Test
    public void registerSuccessWhenTelephoneLength32Char() throws IOException {
        logger.info("Starting Test: User Registration Success with '32-Characters Telephone'");
        UserInput userInput = UserInputFactory.createDefaultUserInput();
        userInput.setTelephone(utils.randomNumeric(32));
        registerFactory.registerDefault(userInput);
        accountPage.continueButton.click();
        assertRegistrationSuccess();
        performLogout();
        logger.info("Test Completed: User Successfully Created with '32-Characters Telephone'");
    }

    @Test(dataProvider = "validTelephoneNumbers")
    public void registerSuccessWhenTelephoneCorrectSetCountry(String telephoneNumber) throws IOException {
        logger.debug("Starting Test: User Registration Success with 'Correct Set for Country Telephone': {}", telephoneNumber);
        UserInput userInput = UserInputFactory.createDefaultUserInput();
        userInput.setTelephone(telephoneNumber);
        registerFactory.registerDefault(userInput);
        accountPage.continueButton.click();
        assertRegistrationSuccess();
        performLogout();
        logger.debug("Test Completed: User Successfully Created with 'Correct Set for Country Telephone': {}", telephoneNumber);
    }

    @Test
    public void registerSuccessWhenPasswordLength4Char() throws IOException {
        logger.info("Starting Test: User Registration Success with '4-Characters Password'");
        UserInput userInput = UserInputFactory.createDefaultUserInput();
        userInput.setPassword(SAMPLE_PASSWORD);
        userInput.setPasswordConfirm(SAMPLE_PASSWORD);
        registerFactory.registerDefault(userInput);
        accountPage.continueButton.click();
        assertRegistrationSuccess();
        performLogout();
        logger.info("Test Completed: User Successfully Created with '4-Characters Password'");
    }

    @Test
    public void registerSuccessWhenPasswordLength20Char() throws IOException {
        logger.info("Starting Test: User Registration Success with '20-Characters Password'");
        UserInput userInput = UserInputFactory.createDefaultUserInput();
        userInput.setPassword(utils.repeatCharacter("1", 20));
        userInput.setPasswordConfirm(utils.repeatCharacter("1", 20));
        registerFactory.registerDefault(userInput);
        accountPage.continueButton.click();
        assertRegistrationSuccess();
        performLogout();
        logger.info("Test Completed: User Successfully Created with '20-Characters Password'");
    }

    @Test
    public void registerSuccessWhenNewsletterSubscribeYes() throws IOException {
        logger.info("Starting Test: User Registration Success when 'Newsletter Subscribe is Selected'");
        UserInput userInput = UserInputFactory.createDefaultUserInput();
        userInput.setNewsletterSubscribe(true);
        registerFactory.registerDefault(userInput);
        accountPage.continueButton.click();
        assertRegistrationSuccess();
        performLogout();
        logger.info("Test Completed: User Successfully Created with 'Newsletter Subscribe Yes'");
    }
}
