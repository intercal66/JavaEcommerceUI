package assertions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pagesPOM.ErrorMessageHandler;

public class CheckoutAddressValidationAssertion {
    private static final Logger logger = LogManager.getLogger(CheckoutAddressValidationAssertion.class);
    private final ErrorMessageHandler errorMessageHandler;

    public CheckoutAddressValidationAssertion(WebDriver driver) {
        this.errorMessageHandler = new ErrorMessageHandler(driver);
    }
    public void assertEmailValidation() {
        String actualMessage = errorMessageHandler.getErrorMessageForLabel("E-Mail");
        String expectedMessage = "E-Mail address does not appear to be valid!";
        logger.debug("Asserting E-Mail validation: actual = '{}', expected = '{}'", actualMessage, expectedMessage);
        Assert.assertEquals(actualMessage, expectedMessage, "Error message for E-Mail does not match");
    }
    public void assertAddress1Validation() {
        String actualMessage = errorMessageHandler.getErrorMessageForLabel("Address 1");
        String expectedMessage = "Address 1 must be between 3 and 128 characters!";
        logger.debug("Asserting Address 1 validation: actual = '{}', expected = '{}'", actualMessage, expectedMessage);
        Assert.assertEquals(actualMessage, expectedMessage, "Error message for Address 1 does not match");
    }

    public void assertCityValidation() {
        String actualError = errorMessageHandler.getErrorMessageForLabel("City");
        String expectedError = "City must be between 2 and 128 characters!";
        logger.debug("Asserting City validation: actual = '{}', expected = '{}'", actualError, expectedError);
        Assert.assertEquals(actualError, expectedError, "Error message for City does not match");
    }

    public void assertPostCodeValidation() {
        String actualError = errorMessageHandler.getErrorMessageForLabel("Post Code");
        String expectedError = "Postcode must be between 2 and 10 characters!";
        logger.debug("Asserting Post Code validation: actual = '{}', expected = '{}'", actualError, expectedError);
        Assert.assertEquals(actualError, expectedError, "Error message for Post Code does not match");
    }

    public void assertCountryValidation() {
        String actualError = errorMessageHandler.getErrorMessageForLabel("Country");
        String expectedError = "Please select a country!";
        logger.debug("Asserting Country validation: actual = '{}', expected = '{}'", actualError, expectedError);
        Assert.assertEquals(actualError, expectedError, "Error message for Country does not match");
    }

    public void assertRegionStateValidation() {
        String actualError = errorMessageHandler.getErrorMessageForLabel("Region / State");
        String expectedError = "Please select a region / state!";
        logger.debug("Asserting Region/State validation: actual = '{}', expected = '{}'", actualError, expectedError);
        Assert.assertEquals(actualError, expectedError, "Error message for Region/State does not match");
    }

    public void assertCheckoutPrivacyPolicyValidation() {
        String actualMessage = errorMessageHandler.getMainErrorSummaryElement().getText();
        String expectedMessage = "Warning: You must agree to the Privacy Policy!";
        logger.debug("Asserting Privacy Policy message: actual = '{}', expected = '{}'", actualMessage, expectedMessage);
        Assert.assertTrue(actualMessage.startsWith(expectedMessage), "Privacy Policy Warning message does not match");
    }

    public void assertCheckoutTermsConditionsValidation() {
        String actualMessage = errorMessageHandler.getMainErrorSummaryElement().getText();
        String expectedMessage = "Warning: You must agree to the Terms & Conditions!";
        logger.debug("Asserting Terms & Conditions message: actual = '{}', expected = '{}'", expectedMessage, expectedMessage);
        Assert.assertTrue(actualMessage.startsWith(expectedMessage), "Terms & Conditions Warning message does not match");
    }

    public void assertCouponValidation() {
        String actualError = errorMessageHandler.getCouponWarningMessage().trim();
        String expectedError = "Warning: Please enter a coupon code!";
        logger.debug("Asserting Coupon Code validation: actual = '{}', expected = '{}'", actualError, expectedError);
        Assert.assertEquals(actualError, expectedError, "Error message for Coupon Code does not match");
    }
    public void assertInvalidCouponValidation() {
        String actualError = errorMessageHandler.getCouponWarningMessage();
        String expectedError = "Warning: Coupon is either invalid, expired or reached its usage limit!";
        logger.debug("Asserting Coupon Code Invalid validation: actual = '{}', expected = '{}'", actualError, expectedError);
        Assert.assertEquals(actualError, expectedError, "Error message for Coupon Code Invalid does not match");
    }
}
