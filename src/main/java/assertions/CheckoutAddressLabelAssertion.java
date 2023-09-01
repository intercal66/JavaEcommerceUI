package assertions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pagesPOM.CheckoutFormPage;
import pagesPOM.PaymentAddressFormLabels;

public class CheckoutAddressLabelAssertion {
    private static final Logger logger = LogManager.getLogger(CheckoutAddressLabelAssertion.class);
    private final PaymentAddressFormLabels paymentAddressFormLabels;
    private final CheckoutFormPage checkoutFormPage;

    public void assertLabel(WebElement labelElement, String expectedLabelText) {
        logger.info("'{}' label text asserting Started", expectedLabelText);
        String actualLabelText = labelElement.getText();
        logger.debug("Asserting Label text: actual = '{}', expected = '{}'", actualLabelText, expectedLabelText);
        Assert.assertEquals(actualLabelText, expectedLabelText, "Label text for " + expectedLabelText + " does not match.");
        logger.debug("'{}' label text asserting Passed: actual = '{}'", expectedLabelText, actualLabelText);
    }

    public void assertFirstNameLabel() {
        assertLabel(paymentAddressFormLabels.firstNamePaymentLabel, "First Name");
    }

    public void assertLastNameLabel() {
        assertLabel(paymentAddressFormLabels.lastNamePaymentLabel, "Last Name");
    }

    public void assertEmailLabel() {
        assertLabel(paymentAddressFormLabels.emailPaymentLabel, "E-Mail");
    }

    public void assertTelephoneLabel() {
        assertLabel(paymentAddressFormLabels.telephonePaymentLabel, "Telephone");
    }

    public void assertPasswordLabel() {
        assertLabel(paymentAddressFormLabels.passwordPaymentLabel, "Password");
    }

    public void assertPasswordConfirmLabel() {
        assertLabel(paymentAddressFormLabels.passwordConfirmPaymentLabel, "Password Confirm");
    }

    public void assertCompanyLabel() {
        assertLabel(paymentAddressFormLabels.companyPaymentLabel, "Company");
    }

    public void assertAddress1Label() {
        assertLabel(paymentAddressFormLabels.address1PaymentLabel, "Address 1");
    }

    public void assertAddress2Label() {
        assertLabel(paymentAddressFormLabels.address2PaymentLabel, "Address 2");
    }

    public void assertCityLabel() {
        assertLabel(paymentAddressFormLabels.cityPaymentLabel, "City");
    }

    public void assertPostCodeLabel() {
        assertLabel(paymentAddressFormLabels.postCodePaymentLabel, "Post Code");
    }

    public void assertCountryLabel() {
        assertLabel(paymentAddressFormLabels.countryPaymentLabel, "Country");
    }

    public void assertRegionStateLabel() {
        assertLabel(paymentAddressFormLabels.regionStatePaymentLabel, "Region / State");
    }

    public void assertCashDeliveryLabel() {
        assertLabel(checkoutFormPage.cashOnDeliveryLabel, "Cash On Delivery");
    }

    public void assertFlatShipRateLabel() {
        assertLabel(checkoutFormPage.flatShippingLabel, "Flat Shipping Rate - $8.00");
    }

    public void assertLoginCheckoutLabel() {
        assertLabel(checkoutFormPage.loginCheckboxLabel, "Login");
    }

    public void assertRegisterCheckoutLabel() {
        assertLabel(checkoutFormPage.registerAccountCheckboxLabel, "Register Account");
    }

    public void assertGuestCheckoutLabel() {
        assertLabel(checkoutFormPage.guestCheckoutCheckboxLabel, "Guest Checkout");
    }

    public void assertShippingSameAddressLabel() {
        assertLabel(checkoutFormPage.sameAddressPaymentCheckbox, "My delivery and billing addresses are the same.");
    }

    public CheckoutAddressLabelAssertion(WebDriver driver) {
        this.paymentAddressFormLabels = new PaymentAddressFormLabels(driver);
        this.checkoutFormPage = new CheckoutFormPage(driver);
    }
}
