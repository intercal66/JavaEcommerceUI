package purchase;

import base.AutoTemplate;
import factories.UserInputFactory;
import models.UserInput;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.Utils;

import java.io.IOException;

public class PurchaseItemLoginTest extends AutoTemplate {
    private static final Logger logger = LogManager.getLogger(PurchaseItemLoginTest.class);

    @BeforeMethod
    public void setupTest() {
        logger.info("Starting Test: {}", getClass().getSimpleName());
        Utils.setPageLoadTimeout(10);
    }

    public void performCheckoutFlow() throws IOException {
        searchProduct.performSearchProduct();
        selectProduct.clickOnProductLocator();
        addProduct.addItemToCart();
    }

    public void completeCheckout() {
        Utils.explicitWaitElementToBeClickable(checkoutFormPage.continueSaveButton, 5);
        Utils.scrollToAnElementAndClick(checkoutFormPage.continueSaveButton);
    }

    public void confirmOrder() {
        Utils.explicitWaitElementToBeClickable(checkoutFormPage.confirmOrderButton, 5);
        Utils.scrollToAnElementAndClick(checkoutFormPage.confirmOrderButton);
        Utils.explicitWaitForVisibilityOfElement(confirmOrderPage.confirmOrderMessage, 5);
    }

    @Test
    public void purchaseItemLoginWithExistingPaymentAddress() throws IOException {
        logger.info("Starting Test: Purchase item using 'Login' with existing 'Payment Address'");
        performCheckoutFlow();
        checkoutFormPage.loginCheckbox.click();
        UserInput userInput = UserInputFactory.createDefaultUserInput();
        loginFactory.loginCheckoutDefault(userInput);
        checkoutFormPage.loginButton.click();
        Utils.explicitWaitForVisibilityAndClick(checkoutFormPage.existingAddressPaymentButton, 2);
        Utils.scrollToAnElementAndClick(userFormInputs.privacyPolicyCheckbox);
        completeCheckout();
        confirmOrder();
        checkoutOrderAssertion.assertOrderConfirm();
        logger.debug("Test Completed: Item purchased using 'Login' with existing 'Payment Address'");
    }

    @Test
    public void purchaseItemLoginWithNewPaymentAddress() throws IOException {
        logger.info("Starting Test: Purchase item using 'Login' with new 'Payment Address'");
        performCheckoutFlow();
        checkoutFormPage.loginCheckbox.click();
        UserInput userInput = UserInputFactory.createDefaultUserInput();
        loginFactory.loginCheckoutDefault(userInput);
        checkoutFormPage.loginButton.click();
        Utils.explicitWaitForVisibilityOfElement(checkoutFormPage.paymentAddressPanel, 4);
        addressFactory.paymentAddressDefault(userInput);
        Utils.scrollToAnElementAndClick(userFormInputs.privacyPolicyCheckbox);
        completeCheckout();
        confirmOrder();
        checkoutOrderAssertion.assertOrderConfirm();
        logger.debug("Test Completed: Item purchased using 'Login' with new 'Payment Address'");
    }

    @Test
    public void purchaseItemLoginWithExistPaymentAddressNewShippingAddress() throws IOException {
        logger.info("Starting Test: Purchase item using 'Login' with existing 'Payment Address' and new 'Shipping Address'");
        performCheckoutFlow();
        checkoutFormPage.loginCheckbox.click();
        UserInput userInput = UserInputFactory.createDefaultUserInput();
        loginFactory.loginCheckoutDefault(userInput);
        checkoutFormPage.loginButton.click();
        Utils.explicitWaitForVisibilityOfElement(checkoutFormPage.paymentAddressPanel, 4);
        checkoutFormPage.existingAddressPaymentButton.click();
        checkoutFormPage.myDeliveryBillingAddressSameCheckbox.click();
        checkoutFormPage.newAddressShippingButton.click();
        addressFactory.shippingAddressDefault(userInput);
        Utils.scrollToAnElementAndClick(userFormInputs.privacyPolicyCheckbox);
        completeCheckout();
        confirmOrder();
        checkoutOrderAssertion.assertOrderConfirm();
        logger.debug("Test Completed: Item purchased using 'Login' with existing 'Payment Address' and new 'Shipping Address''");
    }

    @Test
    public void purchaseItemLoginWithNewPaymentAddressNewShippingAddress() throws IOException {
        logger.info("Starting Test: Purchase item using 'Login' with new 'Payment Address' and new 'Shipping Address'");
        performCheckoutFlow();
        checkoutFormPage.loginCheckbox.click();
        UserInput userInput = UserInputFactory.createDefaultUserInput();
        loginFactory.loginCheckoutDefault(userInput);
        checkoutFormPage.loginButton.click();
        Utils.explicitWaitForVisibilityOfElement(checkoutFormPage.paymentAddressPanel, 4);
        addressFactory.paymentAddressDefault(userInput);
        checkoutFormPage.myDeliveryBillingAddressSameCheckbox.click();
        checkoutFormPage.newAddressShippingButton.click();
        addressFactory.shippingAddressDefault(userInput);
        Utils.scrollToAnElementAndClick(userFormInputs.privacyPolicyCheckbox);
        completeCheckout();
        confirmOrder();
        checkoutOrderAssertion.assertOrderConfirm();
        logger.debug("Test Completed: Item purchased using 'Login' with new 'Payment Address' and new 'Shipping Address''");
    }

    @Test
    public void purchaseItemLoginWithNewPaymentAddressExistShippingAddress() throws IOException {
        logger.info("Starting Test: Purchase item using 'Login' with new 'Payment Address' and existing 'Shipping Address'");
        performCheckoutFlow();
        checkoutFormPage.loginCheckbox.click();
        UserInput userInput = UserInputFactory.createDefaultUserInput();
        loginFactory.loginCheckoutDefault(userInput);
        checkoutFormPage.loginButton.click();
        Utils.explicitWaitForVisibilityOfElement(checkoutFormPage.paymentAddressPanel, 4);
        addressFactory.paymentAddressDefault(userInput);
        checkoutFormPage.myDeliveryBillingAddressSameCheckbox.click();
        Utils.scrollToAnElementAndClick(userFormInputs.privacyPolicyCheckbox);
        completeCheckout();
        confirmOrder();
        checkoutOrderAssertion.assertOrderConfirm();
        logger.debug("Test Completed: Item purchased using 'Login' with new 'Payment Address' and existing 'Shipping Address'");
    }

    @Test
    public void purchaseItemLoginWithExistPaymentAddressExistShippingAddress() throws IOException {
        logger.info("Starting Test: Purchase item using 'Login' with existing 'Payment Address' and 'Shipping Address'");
        performCheckoutFlow();
        checkoutFormPage.loginCheckbox.click();
        UserInput userInput = UserInputFactory.createDefaultUserInput();
        loginFactory.loginCheckoutDefault(userInput);
        checkoutFormPage.loginButton.click();
        Utils.explicitWaitForVisibilityAndClick(checkoutFormPage.existingAddressPaymentButton, 5);
        checkoutFormPage.myDeliveryBillingAddressSameCheckbox.click();
        checkoutFormPage.existingAddressShippingButton.click();
        Utils.scrollToAnElementAndClick(userFormInputs.privacyPolicyCheckbox);
        completeCheckout();
        confirmOrder();
        checkoutOrderAssertion.assertOrderConfirm();
        logger.debug("Test Completed: Item purchased using 'Login' with existing 'Payment Address' and 'Shipping Address'");
    }
}
