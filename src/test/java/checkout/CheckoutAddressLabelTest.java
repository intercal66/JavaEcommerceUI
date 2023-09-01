package checkout;

import base.AutoTemplate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.Utils;

import java.io.IOException;

public class CheckoutAddressLabelTest extends AutoTemplate {
    private static final Logger logger = LogManager.getLogger(CheckoutAddressLabelTest.class);
    private static final String PAGE_TITLE = "Account";
    private static final String BUTTON_NAME = "Continue";
    private static final String COUPON_BUTTON = "Apply Coupon";

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
    public void firstNameCorrectLabelTextDisplayedOnCheckoutPage() throws IOException {
        logger.info("Starting Test: Verify that the 'First Name' label and correct text is displayed on the Checkout Page");
        performCheckoutFlow();
        Assert.assertTrue(paymentAddressFormLabels.firstNamePaymentLabel.isDisplayed(),
                "Error: 'First Name' label is not displayed on the Checkout Page");
        checkoutAddressLabelAssertion.assertFirstNameLabel();
        logger.debug("Test Completed: 'First Name' label and text verification on the Checkout Page");
    }

    @Test
    public void lastNameCorrectLabelTextDisplayedOnCheckoutPage() throws IOException {
        logger.info("Starting Test: Verify that the 'Last Name' label and correct text is displayed on the Checkout Page");
        performCheckoutFlow();
        Assert.assertTrue(paymentAddressFormLabels.lastNamePaymentLabel.isDisplayed(),
                "Error: 'Last Name' label is not displayed on the Checkout Page");
        checkoutAddressLabelAssertion.assertLastNameLabel();
        logger.debug("Test Completed: 'Last Name' label and text verification on the Checkout Page");
    }

    @Test
    public void emailCorrectLabelTextDisplayedOnCheckoutPage() throws IOException {
        logger.info("Starting Test: Verify that the 'E-Mail' label and correct text is displayed on the Checkout Page");
        performCheckoutFlow();
        Assert.assertTrue(paymentAddressFormLabels.emailPaymentLabel.isDisplayed(),
                "Error: 'E-Mail' label is not displayed on the Checkout Page");
        checkoutAddressLabelAssertion.assertEmailLabel();
        logger.debug("Test Completed: 'E-Mail' label and text verification on the Checkout Page");
    }

    @Test
    public void telephoneCorrectLabelTextDisplayedOnCheckoutPage() throws IOException {
        logger.info("Starting Test: Verify that the 'Telephone' label and correct text is displayed on the Checkout Page");
        performCheckoutFlow();
        Assert.assertTrue(paymentAddressFormLabels.telephonePaymentLabel.isDisplayed(),
                "Error: 'Telephone' label is not displayed on the Checkout Page");
        checkoutAddressLabelAssertion.assertTelephoneLabel();
        logger.debug("Test Completed: 'Telephone' label and text verification on the Checkout Page");
    }

    @Test
    public void passwordCorrectLabelTextDisplayedOnCheckoutPage() throws IOException {
        logger.info("Starting Test: Verify that the 'Password' label and correct text is displayed on the Checkout Page");
        performCheckoutFlow();
        Assert.assertTrue(paymentAddressFormLabels.passwordPaymentLabel.isDisplayed(),
                "Error: 'Password' label is not displayed on the Checkout Page");
        checkoutAddressLabelAssertion.assertPasswordLabel();
        logger.debug("Test Completed: 'Password' label and text verification on the Checkout Page");
    }

    @Test
    public void passwordConfirmCorrectLabelTextDisplayedOnCheckoutPage() throws IOException {
        logger.info("Starting Test: Verify that the 'Password Confirm' label and correct text is displayed on the Checkout Page");
        performCheckoutFlow();
        Assert.assertTrue(paymentAddressFormLabels.passwordConfirmPaymentLabel.isDisplayed(),
                "Error: 'Password Confirm' label is not displayed on the Checkout Page");
        checkoutAddressLabelAssertion.assertPasswordConfirmLabel();
        logger.debug("Test Completed: 'Password Confirm' label and text verification on the Checkout Page");
    }

    @Test
    public void companyCorrectLabelTextDisplayedOnCheckoutPage() throws IOException {
        logger.info("Starting Test: Verify that the 'Company' label and correct text is displayed on the Checkout Page");
        performCheckoutFlow();
        Assert.assertTrue(paymentAddressFormLabels.companyPaymentLabel.isDisplayed(),
                "Error: 'Company' label is not displayed on the Checkout Page");
        checkoutAddressLabelAssertion.assertCompanyLabel();
        logger.debug("Test Completed: 'Company' label and text verification on the Checkout Page");
    }

    @Test
    public void address1CorrectLabelTextDisplayedOnCheckoutPage() throws IOException {
        logger.info("Starting Test: Verify that the 'Address 1' label and correct text is displayed on the Checkout Page");
        performCheckoutFlow();
        Assert.assertTrue(paymentAddressFormLabels.address1PaymentLabel.isDisplayed(),
                "Error: 'Address 1' label is not displayed on the Checkout Page");
        checkoutAddressLabelAssertion.assertAddress1Label();
        logger.debug("Test Completed: 'Address 1' label and text verification on the Checkout Page");
    }

    @Test
    public void address2CorrectLabelTextDisplayedOnCheckoutPage() throws IOException {
        logger.info("Starting Test: Verify that the 'Address 2' label and correct text is displayed on the Checkout Page");
        performCheckoutFlow();
        Assert.assertTrue(paymentAddressFormLabels.address2PaymentLabel.isDisplayed(),
                "Error: 'Address 2' label is not displayed on the Checkout Page");
        checkoutAddressLabelAssertion.assertAddress2Label();
        logger.debug("Test Completed: 'Address 2' label and text verification on the Checkout Page");
    }

    @Test
    public void cityCorrectLabelTextDisplayedOnCheckoutPage() throws IOException {
        logger.info("Starting Test: Verify that the 'City' label and correct text is displayed on the Checkout Page");
        performCheckoutFlow();
        Assert.assertTrue(paymentAddressFormLabels.cityPaymentLabel.isDisplayed(),
                "Error: 'City' label is not displayed on the Checkout Page");
        checkoutAddressLabelAssertion.assertCityLabel();
        logger.debug("Test Completed: 'City' label and text verification on the Checkout Page");
    }

    @Test
    public void postCodeCorrectLabelTextDisplayedOnCheckoutPage() throws IOException {
        logger.info("Starting Test: Verify that the 'Post' label and correct text is displayed on the Checkout Page");
        performCheckoutFlow();
        Assert.assertTrue(paymentAddressFormLabels.postCodePaymentLabel.isDisplayed(),
                "Error: 'Post' label is not displayed on the Checkout Page");
        checkoutAddressLabelAssertion.assertPostCodeLabel();
        logger.debug("Test Completed: 'Post' label and text verification on the Checkout Page");
    }

    @Test
    public void countryCorrectLabelTextDisplayedOnCheckoutPage() throws IOException {
        logger.info("Starting Test: Verify that the 'Country' label and correct text is displayed on the Checkout Page");
        performCheckoutFlow();
        Assert.assertTrue(paymentAddressFormLabels.countryPaymentLabel.isDisplayed(),
                "Error: 'Country' label is not displayed on the Checkout Page");
        checkoutAddressLabelAssertion.assertCountryLabel();
        logger.debug("Test Completed: 'Country' label and text verification on the Checkout Page");
    }

    @Test
    public void regionStateCorrectLabelTextDisplayedOnCheckoutPage() throws IOException {
        logger.info("Starting Test: Verify that the 'Region/State' label and correct text is displayed on the Checkout Page");
        performCheckoutFlow();
        Assert.assertTrue(paymentAddressFormLabels.regionStatePaymentLabel.isDisplayed(),
                "Error: 'Region/State' label is not displayed on the Checkout Page");
        checkoutAddressLabelAssertion.assertRegionStateLabel();
        logger.debug("Test Completed: 'Region/State' label and text verification on the Checkout Page");
    }

    @Test
    public void cashDeliveryCorrectLabelTextDisplayedOnCheckoutPage() throws IOException {
        logger.info("Starting Test: Verify that the 'Cash on Delivery' label and correct text is displayed on the Checkout Page");
        performCheckoutFlow();
        Assert.assertTrue(checkoutFormPage.cashOnDeliveryLabel.isDisplayed(),
                "Error: 'Cash on Delivery' label is not displayed on the Checkout Page");
        checkoutAddressLabelAssertion.assertCashDeliveryLabel();
        logger.debug("Test Completed: 'Cash on Delivery' label and text verification on the Checkout Page");
    }

    @Test
    public void flatShipRateCorrectLabelTextDisplayedOnCheckoutPage() throws IOException {
        logger.info("Starting Test: Verify that the 'Flat Shipping Rate' label and correct text is displayed on the Checkout Page");
        performCheckoutFlow();
        Assert.assertTrue(checkoutFormPage.flatShippingLabel.isDisplayed(),
                "Error: 'Flat Shipping Rate' label is not displayed on the Checkout Page");
        checkoutAddressLabelAssertion.assertFlatShipRateLabel();
        logger.debug("Test Completed: 'Flat Shipping Rate' label and text verification on the Checkout Page");
    }

    @Test
    public void verifyCheckoutAccountTitleOnCheckoutPage() throws IOException {
        logger.info("Starting Test: Verify 'Account' title on the Checkout Page");
        performCheckoutFlow();
        String expectedTitle = PAGE_TITLE;
        String actualTitle = mainHomePage.mainHeadingH4Element.getText();
        logger.debug("Verify checkout 'Account' title: actual = '{}', expected = '{}'", actualTitle, expectedTitle);
        Assert.assertEquals(actualTitle, expectedTitle, "Error: Incorrect Checkout title");
        logger.debug("Test Completed: 'Account' title verification on the Checkout Page");
    }

    @Test
    public void verifyContinueButtonNameOnCheckoutPage() throws IOException {
        logger.info("Starting Test: Verify 'Continue' button name on the Checkout Page");
        performCheckoutFlow();
        String expectedButtonName = BUTTON_NAME;
        String actualButtonName = checkoutFormPage.continueSaveButton.getText();
        logger.debug("Verify 'Continue' button name: actual = '{}', expected = '{}'", actualButtonName, expectedButtonName);
        Assert.assertEquals(actualButtonName, expectedButtonName, "Error: Incorrect 'Continue' button name");
        logger.debug("Test Completed: 'Continue' button name verification on the Checkout Page");
    }

    @Test
    public void verifyApplyCouponButtonNameOnCheckoutPage() throws IOException {
        logger.info("Starting Test: Verify 'Apply Coupon' button name on the Checkout Page");
        performCheckoutFlow();
        String expectedButtonName = COUPON_BUTTON;
        String actualButtonName = checkoutFormPage.couponCodeApplyButton.getText();
        logger.debug("Verify 'Apply Coupon' button name: actual = '{}', expected = '{}'", actualButtonName, expectedButtonName);
        Assert.assertEquals(actualButtonName, expectedButtonName, "Error: Incorrect 'Apply Coupon' button name");
        logger.debug("Test Completed: 'Apply Coupon' button name verification on the Checkout Page");
    }

    @Test
    public void loginCheckboxOnCheckoutPage() throws IOException {
        logger.info("Starting Test: Verify that the 'Login' checkbox label and correct text is displayed on the Checkout Page");
        performCheckoutFlow();
        Assert.assertTrue(checkoutFormPage.loginCheckboxLabel.isDisplayed(),
                "Error: 'Login' checkbox label is not displayed on the Checkout Page");
        checkoutAddressLabelAssertion.assertLoginCheckoutLabel();
        logger.debug("Test Completed: 'Login' checkbox label and text verification on the Checkout Page");
    }

    @Test
    public void registerCheckboxOnCheckoutPage() throws IOException {
        logger.info("Starting Test: Verify that the 'Register' checkbox label and correct text is displayed on the Checkout Page");
        performCheckoutFlow();
        Assert.assertTrue(checkoutFormPage.registerAccountCheckboxLabel.isDisplayed(),
                "Error: 'Register' checkbox label is not displayed on the Checkout Page");
        checkoutAddressLabelAssertion.assertRegisterCheckoutLabel();
        logger.debug("Test Completed: 'Register' checkbox label and text verification on the Checkout Page");
    }

    @Test
    public void guestCheckboxOnCheckoutPage() throws IOException {
        logger.info("Starting Test: Verify that the 'Guest' checkbox label and correct text is displayed on the Checkout Page");
        performCheckoutFlow();
        Assert.assertTrue(checkoutFormPage.guestCheckoutCheckboxLabel.isDisplayed(),
                "Error: 'Guest' checkbox label is not displayed on the Checkout Page");
        checkoutAddressLabelAssertion.assertGuestCheckoutLabel();
        logger.debug("Test Completed: 'Guest' checkbox label and text verification on the Checkout Page");
    }

    @Test
    public void sameAddressCorrectLabelTextDisplayedOnCheckoutPage() throws IOException {
        logger.info("Starting Test: Verify that the 'Delivery and Billing Addresses' checkbox label and correct text is displayed on the Checkout Page");
        performCheckoutFlow();
        Assert.assertTrue(checkoutFormPage.sameAddressPaymentCheckbox.isDisplayed(),
                "Error: 'Delivery and Billing Addresses' checkbox label is not displayed on the Checkout Page");
        checkoutAddressLabelAssertion.assertShippingSameAddressLabel();
        logger.debug("Test Completed: 'Delivery and Billing Addresses' checkbox label and text verification on the Checkout Page");
    }
}
