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

public class PurchaseItemGuestTest extends AutoTemplate {
    private static final Logger logger = LogManager.getLogger(PurchaseItemGuestTest.class);

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
    public void purchaseItemGuestAccountWithPaymentAddress() throws IOException {
        logger.info("Starting Test: Purchase item as 'Guest' with 'Payment Billing Address'");
        performCheckoutFlow();
        checkoutFormPage.guestCheckoutCheckbox.click();
        UserInput userInput = UserInputFactory.createDefaultUserInput();
        guestFactory.guestUserDefault(userInput);
        completeCheckout();
        confirmOrder();
        checkoutOrderAssertion.assertOrderConfirm();
        logger.debug("Test Completed: Item purchased as 'Guest' with 'Payment Billing Address'");
    }

    @Test
    public void purchaseItemGuestAccountWithPaymentAddressShippingAddress() throws IOException {
        logger.info("Starting Test: Purchase item as 'Guest' with 'Payment Billing Address' and 'Shipping Address'");
        performCheckoutFlow();
        checkoutFormPage.guestCheckoutCheckbox.click();
        UserInput userInput = UserInputFactory.createDefaultUserInput();
        guestFactory.guestUserDefault(userInput);
        checkoutFormPage.sameAddressPaymentCheckbox.click();
        addressFactory.shippingAddressDefault(userInput);
        completeCheckout();
        confirmOrder();
        checkoutOrderAssertion.assertOrderConfirm();
        logger.debug("Test Completed: Item purchased as 'Guest' with 'Payment Billing Address' and 'Shipping Address'");
    }
}
