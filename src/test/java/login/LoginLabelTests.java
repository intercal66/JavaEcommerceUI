package login;

import base.AutoTemplate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.Utils;

public class LoginLabelTests extends AutoTemplate {
    private static final Logger logger = LogManager.getLogger(LoginLabelTests.class);
    private static final String PAGE_TITLE = "New Customer";
    private static final String LOGIN_TITLE = "Returning Customer";
    private static final String BUTTON_NAME = "Login";

    @BeforeMethod
    public void setupTest() {
        logger.info("Starting Test: {}", getClass().getSimpleName());
        Utils.setPageLoadTimeout(10);
        Utils.explicitWaitForWebElementToBeClickableAndClick(mainHomePage.myAccountButton, 10);
    }

    @Test
    public void emailCorrectLabelTextDisplayedOnLoginPage() {
        logger.info("Starting Test: Verify that the 'E-Mail' label and correct text is displayed on the Login Page");
        Assert.assertTrue(registrationFormLabels.emailLabel.isDisplayed(),
                "Error: 'E-Mail' label is not displayed on the Login Page");
        loginLabelAssertion.assertEmailLabel();
        logger.debug("Test Completed: 'E-Mail' label and text verification on the Login Page");
    }

    @Test
    public void passwordCorrectLabelTextDisplayedOnLoginPage() {
        logger.info("Starting Test: Verify that the 'Password' label and correct text is displayed on the Login Page");
        Assert.assertTrue(registrationFormLabels.emailLabel.isDisplayed(),
                "Error: 'Password' label is not displayed on the Login Page");
        loginLabelAssertion.assertPasswordLabel();
        logger.debug("Test Completed: 'Password' label and text verification on the Login Page");
    }

    @Test
    public void verifyLoginPageNewCustomerTitle() {
        logger.info("Starting Test: Verify 'New Customer' title on the Login Page");
        String expectedTitle = PAGE_TITLE;
        String actualTitle = mainHomePage.mainHeadingH2Element.getText();
        logger.debug("Verify New Customer title: actual = '{}', expected = '{}'", actualTitle, expectedTitle);
        Assert.assertEquals(actualTitle, expectedTitle, "Error: Incorrect New Customer title");
        logger.debug("Test Completed: 'New Customer' title verification on the Login Page");
    }

    @Test
    public void verifyLoginPageReturningCustomerTitle() {
        logger.info("Starting Test: Verify 'Returning Customer' title on the Login Page");
        String expectedTitle = LOGIN_TITLE;
        String actualTitle = mainHomePage.mainHeadingH2Login.getText();
        logger.debug("Verify Returning Customer title: actual = '{}', expected = '{}'", actualTitle, expectedTitle);
        Assert.assertEquals(actualTitle, expectedTitle, "Error: Incorrect Returning Customer title");
        logger.debug("Test Completed: 'Returning Customer' title verification on the Login Page");
    }

    @Test
    public void verifyLoginButtonName() {
        logger.info("Starting Test: Verify 'Login' button name on the Login Page");
        String expectedButtonName = BUTTON_NAME;
        String actualButtonName = accountPage.loginButton.getAttribute("value");
        logger.debug("Verify Login button name: actual = '{}', expected = '{}'", actualButtonName, expectedButtonName);
        Assert.assertEquals(actualButtonName, expectedButtonName, "Error: Incorrect 'Login' button name");
        logger.debug("Test Completed: 'Login' button name verification on the Login Page");
    }
}
