package signup;

import base.AutoTemplate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.Utils;

public class RegistrationLabelTests extends AutoTemplate {
    private static final Logger logger = LogManager.getLogger(RegistrationLabelTests.class);
    private static final String PAGE_TITLE = "Register Account";
    private static final String BUTTON_NAME = "Continue";

    @BeforeMethod
    public void setupTest() {
        logger.info("Starting Test: {}", getClass().getSimpleName());
        Actions actions = new Actions(driver);
        Utils.setPageLoadTimeout(10);
        actions.moveToElement(mainHomePage.myAccountButton).perform();
        Utils.explicitWaitForWebElementToBeClickableAndClick(mainHomePage.registerButton, 10);
    }

    @Test
    public void firstNameCorrectLabelTextDisplayedOnRegisterPage() {
        logger.info("Starting Test: Verify that the 'First Name' label and correct text is displayed on the Registration Page");
        Assert.assertTrue(registrationFormLabels.firstNameLabel.isDisplayed(),
                "Error: 'First Name' label is not displayed on the Registration Page");
        registrationLabelAssertion.assertFirstNameLabel();
        logger.debug("Test Completed: 'First Name' label and text verification on the Registration Page");
    }

    @Test
    public void lastNameCorrectLabelTextDisplayedOnRegisterPage() {
        logger.info("Starting Test: Verify that the 'Last Name' label and correct text is displayed on the Registration Page");
        Assert.assertTrue(registrationFormLabels.lastNameLabel.isDisplayed(),
                "Error: 'Last Name' label is not displayed on the Registration Page");
        registrationLabelAssertion.assertLastNameLabel();
        logger.debug("Test Completed: 'Last Name' label and text verification on the Registration Page");
    }

    @Test
    public void emailCorrectLabelTextDisplayedOnRegisterPage() {
        logger.info("Starting Test: Verify that the 'E-Mail' label and correct text is displayed on the Registration Page");
        Assert.assertTrue(registrationFormLabels.emailLabel.isDisplayed(),
                "Error: 'E-Mail' label is not displayed on the Registration Page");
        registrationLabelAssertion.assertEmailLabel();
        logger.debug("Test Completed: 'E-Mail' label and text verification on the Registration Page");
    }

    @Test
    public void telephoneCorrectLabelTextDisplayedOnRegisterPage() {
        logger.info("Starting Test: Verify that the 'Telephone' label and correct text is displayed on the Registration Page");
        Assert.assertTrue(registrationFormLabels.telephoneLabel.isDisplayed(),
                "Error: 'Telephone' label is not displayed on the Registration Page");
        registrationLabelAssertion.assertTelephoneLabel();
        logger.debug("Test Completed: 'Telephone' label and text verification on the Registration Page");
    }

    @Test
    public void passwordCorrectLabelTextDisplayedOnRegisterPage() {
        logger.info("Starting Test: Verify that the 'Password' label and correct text is displayed on the Registration Page");
        Assert.assertTrue(registrationFormLabels.passwordLabel.isDisplayed(),
                "Error: 'Password' label is not displayed on the Registration Page");
        registrationLabelAssertion.assertPasswordLabel();
        logger.debug("Test Completed: 'Password' label and text verification on the Registration Page");
    }

    @Test
    public void passwordConfirmCorrectLabelTextDisplayedOnRegisterPage() {
        logger.info("Starting Test: Verify that the 'Password Confirm' label and correct text is displayed on the Registration Page");
        Assert.assertTrue(registrationFormLabels.passwordConfirmLabel.isDisplayed(),
                "Error: 'Password Confirm' label is not displayed on the Registration Page");
        registrationLabelAssertion.assertPasswordConfirmLabel();
        logger.debug("Test Completed: 'Password Confirm' label and text verification on the Registration Page");
    }

    @Test
    public void newsletterSubscribeCorrectLabelTextDisplayedOnRegisterPage() {
        logger.info("Starting Test: Verify that the 'Newsletter Subscribe' label and correct text is displayed on the Registration Page");
        Assert.assertTrue(registrationFormLabels.newsletterSubscribeLabel.isDisplayed(),
                "Error: 'Newsletter' label is not displayed on the Registration Page");
        registrationLabelAssertion.assertNewsletterSubscribeLabel();
        logger.debug("Test Completed: 'Newsletter' label and text verification on the Registration Page");
    }

    @Test
    public void newsletterSubscribeYesCorrectLabelTextDisplayedOnRegisterPage() {
        logger.info("Starting Test: Verify that the 'Newsletter Subscribe Yes' label and correct text is displayed on the Registration Page");
        Assert.assertTrue(registrationFormLabels.newsLetterSubscribeYesLabel.isDisplayed(),
                "Error: 'Newsletter Subscribe Yes' label is not displayed on the Registration Page");
        registrationLabelAssertion.assertNewsletterYesSubscribeLabel();
        logger.debug("Test Completed: 'Newsletter Subscribe Yes' label and text verification on the Registration Page");
    }

    @Test
    public void newsletterSubscribeNoCorrectLabelTextDisplayedOnRegisterPage() {
        logger.info("Starting Test: Verify that the 'Newsletter Subscribe No' label and correct text is displayed on the Registration Page");
        Assert.assertTrue(registrationFormLabels.newsLetterSubscribeYesLabel.isDisplayed(),
                "Error: 'Newsletter Subscribe No' label is not displayed on the Registration Page");
        registrationLabelAssertion.assertNewsletterNoSubscribeLabel();
        logger.debug("Test Completed: 'Newsletter Subscribe No' label and text verification on the Registration Page");
    }

    @Test
    public void verifyRegisterAccountTitleOnRegisterPage() {
        logger.info("Starting Test: Verify 'Register Account' title on the Registration Page");
        String expectedTitle = PAGE_TITLE;
        String actualTitle = mainHomePage.mainHeadingH1Element.getText();
        logger.debug("Verify 'Register Account' title: actual = '{}', expected = '{}'", actualTitle, expectedTitle);
        Assert.assertEquals(actualTitle, expectedTitle, "Error: Incorrect Register title");
        logger.debug("Test Completed: 'Register Account' title verification on the Registration Page");
    }

    @Test
    public void verifyContinueButtonNameOnRegisterPage() {
        logger.info("Starting Test: Verify 'Continue' button name on the Registration Page");
        String expectedButtonName = BUTTON_NAME;
        String actualButtonName = accountPage.continueButton.getAttribute("value");
        logger.debug("Verify 'Continue' button name: actual = '{}', expected = '{}'", actualButtonName, expectedButtonName);
        Assert.assertEquals(actualButtonName, expectedButtonName, "Error: Incorrect 'Continue' button name");
        logger.debug("Test Completed: 'Continue' button name verification on the Registration Page");
    }
}
