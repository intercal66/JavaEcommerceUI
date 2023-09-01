package checkout;

import base.AutoTemplate;
import models.UserInputPlaceholder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.Utils;

import java.io.IOException;

public class CheckoutAddressPlaceholderTests extends AutoTemplate {
    private static final Logger logger = LogManager.getLogger(CheckoutAddressPlaceholderTests.class);

    @BeforeMethod
    public void setupTest() throws IOException {
        logger.info("Starting Test: {}", getClass().getSimpleName());
        Utils.setPageLoadTimeout(10);
    }

    public void performCheckoutFlow() throws IOException {
        searchProduct.performSearchProduct();
        selectProduct.clickOnProductLocator();
        addProduct.addItemToCart();
    }

    @Test
    public void firstNamePlaceholderDisplayedOnCheckoutPage() throws IOException {
        logger.info("Starting Test: Verify that the 'First Name' placeholder and correct text is displayed on the Checkout Page");
        performCheckoutFlow();
        String expectedPlaceholderText = UserInputPlaceholder.getFirstNamePlaceholderText();
        userInputPlaceholderAssertion.assertPlaceholder(expectedPlaceholderText, userFormInputs.firstNameInput);
        logger.debug("Test Completed: 'First Name' placeholder and text verification on the Checkout Page");
    }

    @Test
    public void lastNamePlaceholderDisplayedOnCheckoutPage() throws IOException {
        logger.info("Starting Test: Verify that the 'Last Name' placeholder and correct text is displayed on the Checkout Page");
        performCheckoutFlow();
        String expectedPlaceholderText = UserInputPlaceholder.getLastNamePlaceholderText();
        userInputPlaceholderAssertion.assertPlaceholder(expectedPlaceholderText, userFormInputs.lastNameInput);
        logger.debug("Test Completed: 'Last Name' placeholder and text verification on the Checkout Page");
    }

    @Test
    public void emailPlaceholderDisplayedOnCheckoutPage() throws IOException {
        logger.info("Starting Test: Verify that the 'E-Mail' placeholder and correct text is displayed on the Checkout Page");
        performCheckoutFlow();
        String expectedPlaceholderText = UserInputPlaceholder.getEmailPlaceholderText();
        userInputPlaceholderAssertion.assertPlaceholder(expectedPlaceholderText, userFormInputs.emailInput);
        logger.debug("Test Completed: 'E-Mail' placeholder and text verification on the Checkout Page");
    }

    @Test
    public void telephonePlaceholderDisplayedOnCheckoutPage() throws IOException {
        logger.info("Starting Test: Verify that the 'Telephone' placeholder and correct text is displayed on the Checkout Page");
        performCheckoutFlow();
        String expectedPlaceholderText = UserInputPlaceholder.getTelephonePlaceholderText();
        userInputPlaceholderAssertion.assertPlaceholder(expectedPlaceholderText, userFormInputs.telephoneInput);
        logger.debug("Test Completed: 'Telephone' placeholder and text verification on the Checkout Page");
    }

    @Test
    public void passwordPlaceholderDisplayedOnCheckoutPage() throws IOException {
        logger.info("Starting Test: Verify that the 'Password' placeholder and correct text is displayed on the Checkout Page");
        performCheckoutFlow();
        String expectedPlaceholderText = UserInputPlaceholder.getPasswordPlaceholderText();
        userInputPlaceholderAssertion.assertPlaceholder(expectedPlaceholderText, userFormInputs.passwordInput);
        logger.debug("Test Completed: 'Password' placeholder and text verification on the Checkout Page");
    }

    @Test
    public void passwordConfirmPlaceholderDisplayedOnCheckoutPage() throws IOException {
        logger.info("Starting Test: Verify that the 'Password Confirm' placeholder and correct text is displayed on the Checkout Page");
        performCheckoutFlow();
        String expectedPlaceholderText = UserInputPlaceholder.getPasswordConfirmPlaceholderText();
        userInputPlaceholderAssertion.assertPlaceholder(expectedPlaceholderText, userFormInputs.passwordConfirmInput);
        logger.debug("Test Completed: 'Password Confirm' placeholder and text verification on the Checkout Page");
    }

    @Test
    public void companyPlaceholderDisplayedOnCheckoutPage() throws IOException {
        logger.info("Starting Test: Verify that the 'Company' placeholder and correct text is displayed on the Checkout Page");
        performCheckoutFlow();
        String expectedPlaceholderText = UserInputPlaceholder.getCompanyPlaceholderText();
        userInputPlaceholderAssertion.assertPlaceholder(expectedPlaceholderText, userFormInputs.companyInput);
        logger.debug("Test Completed: 'Company' placeholder and text verification on the Checkout Page");
    }

    @Test
    public void address1PlaceholderDisplayedOnCheckoutPage() throws IOException {
        logger.info("Starting Test: Verify that the 'Address 1' placeholder and correct text is displayed on the Checkout Page");
        performCheckoutFlow();
        String expectedPlaceholderText = UserInputPlaceholder.getAddress1PlaceholderText();
        userInputPlaceholderAssertion.assertPlaceholder(expectedPlaceholderText, userFormInputs.addressInput1);
        logger.debug("Test Completed: 'Address 1' placeholder and text verification on the Checkout Page");
    }

    @Test
    public void address2PlaceholderDisplayedOnCheckoutPage() throws IOException {
        logger.info("Starting Test: Verify that the 'Address 2' placeholder and correct text is displayed on the Checkout Page");
        performCheckoutFlow();
        String expectedPlaceholderText = UserInputPlaceholder.getAddress2PlaceholderText();
        userInputPlaceholderAssertion.assertPlaceholder(expectedPlaceholderText, userFormInputs.addressInput2);
        logger.debug("Test Completed: 'Address 2' placeholder and text verification on the Checkout Page");
    }

    @Test
    public void cityPlaceholderDisplayedOnCheckoutPage() throws IOException {
        logger.info("Starting Test: Verify that the 'City' placeholder and correct text is displayed on the Checkout Page");
        performCheckoutFlow();
        String expectedPlaceholderText = UserInputPlaceholder.getCityPlaceholderText();
        userInputPlaceholderAssertion.assertPlaceholder(expectedPlaceholderText, userFormInputs.cityInput);
        logger.debug("Test Completed: 'City' placeholder and text verification on the Checkout Page");
    }

    @Test
    public void postCodePlaceholderDisplayedOnCheckoutPage() throws IOException {
        logger.info("Starting Test: Verify that the 'Post Code' placeholder and correct text is displayed on the Checkout Page");
        performCheckoutFlow();
        String expectedPlaceholderText = UserInputPlaceholder.getPostCodePlaceholderText();
        userInputPlaceholderAssertion.assertPlaceholder(expectedPlaceholderText, userFormInputs.postCodeInput);
        logger.debug("Test Completed: 'Post Code' placeholder and text verification on the Checkout Page");
    }

    @Test
    public void couponCodePlaceholderDisplayedOnCheckoutPage() throws IOException {
        logger.info("Starting Test: Verify that the 'Coupon Code' placeholder and correct text is displayed on the Checkout Page");
        performCheckoutFlow();
        String expectedPlaceholderText = UserInputPlaceholder.getCouponPlaceholderText();
        userInputPlaceholderAssertion.assertPlaceholder(expectedPlaceholderText, checkoutFormPage.couponCodeInput);
        logger.debug("Test Completed: 'Coupon Code' placeholder and text verification on the Checkout Page");
    }

    @Test
    public void giftCertificatePlaceholderDisplayedOnCheckoutPage() throws IOException {
        logger.info("Starting Test: Verify that the 'Gift Certificate' placeholder and correct text is displayed on the Checkout Page");
        performCheckoutFlow();
        String expectedPlaceholderText = UserInputPlaceholder.getGiftCertificatePlaceholderText();
        userInputPlaceholderAssertion.assertPlaceholder(expectedPlaceholderText, checkoutFormPage.giftCertificateInput);
        logger.debug("Test Completed: 'Gift Certificate' placeholder and text verification on the Checkout Page");
    }
}
