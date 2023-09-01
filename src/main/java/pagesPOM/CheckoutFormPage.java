package pagesPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutFormPage {
    @FindBy(xpath = "//label[@class=\"custom-control-label\" and @for=\"input-account-login\"]")
    public WebElement loginCheckbox;
    @FindBy(id = "//label[@for=\"input-account-register\" and text()=\"register Account\"]")
    public WebElement registerAccountCheckbox;
    @FindBy(xpath = "//label[@class=\"custom-control-label\" and @for=\"input-account-guest\"]")
    public WebElement guestCheckoutCheckbox;
    @FindBy(xpath = "//*[@id=\"payment-address\"]")
    public WebElement paymentAddressPanel;
    @FindBy(xpath = "//*[@id=\"shipping-address\"]")
    public WebElement shippingAddressPanel;
    @FindBy(xpath = "//*[@id=\"button-login\"]")
    public WebElement loginButton;
    @FindBy(xpath = "//*[@id=\"button-save\"]")
    public WebElement continueSaveButton;
    @FindBy(id = "button-confirm")
    public WebElement confirmOrderButton;

    // ---> Checkout Addresses Checkboxes <---
    @FindBy(xpath = "//label[@class=\"custom-control-label\" and @for=\"input-shipping-address-same\"]")
    public WebElement myDeliveryBillingAddressSameCheckbox;
    @FindBy(xpath = "//*[@id=\"payment-address\"]/div[8]/label")
    public WebElement sameAddressPaymentCheckbox;
    @FindBy(xpath = "//*[@id=\"payment-address\"]/div[1]/div[1]/label")
    public WebElement existingAddressPaymentButton;
    @FindBy(xpath = "//*[@id=\"shipping-address\"]/div[1]/div[1]/label")
    public WebElement existingAddressShippingButton;
    @FindBy(xpath = "//*[@id=\"payment-address\"]/div[2]/div/label")
    public WebElement newAddressPaymentButton;
    @FindBy(xpath = "//*[@id=\"shipping-address\"]/div[2]/div/label")
    public WebElement newAddressShippingButton;

    // ---> Coupon & Gift Certificate <---
    @FindBy(xpath = "//*[@id=\"accordion\"]/div[1]/h5")
    public WebElement couponCodeButton;
    @FindBy(id = "input-coupon")
    public WebElement couponCodeInput;
    @FindBy(id = "button-coupon")
    public WebElement couponCodeApplyButton;
    @FindBy(xpath = "//*[@id=\"accordion\"]/div[2]/h5")
    public WebElement giftCertificateButton;
    @FindBy(id = "input-voucher")
    public WebElement giftCertificateInput;
    @FindBy(id = "button-voucher")
    public WebElement giftCertificateApplyButton;
    @FindBy(id = "input-comment")
    public WebElement inputComment;

    // ---> Checkout Page Labels <---
    @FindBy(xpath = "//label[@for='input-account-login']")
    public WebElement loginCheckboxLabel;
    @FindBy(xpath = "//label[@for='input-account-register']")
    public WebElement registerAccountCheckboxLabel;
    @FindBy(xpath = "//label[@for='input-account-guest']")
    public WebElement guestCheckoutCheckboxLabel;
    @FindBy(xpath = "//label[@for='input-payment-method-cod']")
    public WebElement cashOnDeliveryLabel;
    @FindBy(xpath = "//label[@for='input-shipping-method-flat.flat']")
    public WebElement flatShippingLabel;
    @FindBy(xpath = "//label[@for='input-newsletter']")
    public WebElement subscribeNewsLetterLabel;
    @FindBy(xpath = "//label[@for='input-account-agree']")
    public WebElement subscribePrivacyPolicyLabel;
    @FindBy(xpath = "//label[@for='input-agree']")
    public WebElement termsConditionsLabel;

    public CheckoutFormPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
