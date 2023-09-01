package pagesPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentAddressFormLabels {
    @FindBy(xpath = "//label[@for='input-payment-firstname']")
    public WebElement firstNamePaymentLabel;
    @FindBy(xpath = "//label[@for='input-payment-lastname']")
    public WebElement lastNamePaymentLabel;
    @FindBy(xpath = "//label[@for='input-payment-email']")
    public WebElement emailPaymentLabel;
    @FindBy(xpath = "//label[@for='input-payment-telephone']")
    public WebElement telephonePaymentLabel;
    @FindBy(xpath = "//label[@for='input-payment-password']")
    public WebElement passwordPaymentLabel;
    @FindBy(xpath = "//label[@for='input-payment-confirm']")
    public WebElement passwordConfirmPaymentLabel;
    @FindBy(xpath = "//label[@for='input-payment-company']")
    public WebElement companyPaymentLabel;
    @FindBy(xpath = "//label[@for='input-payment-address-1']")
    public WebElement address1PaymentLabel;
    @FindBy(xpath = "//label[@for='input-payment-address-2']")
    public WebElement address2PaymentLabel;
    @FindBy(xpath = "//label[@for='input-payment-city']")
    public WebElement cityPaymentLabel;
    @FindBy(xpath = "//label[@for='input-payment-postcode']")
    public WebElement postCodePaymentLabel;
    @FindBy(xpath = "//label[@for='input-payment-country']")
    public WebElement countryPaymentLabel;
    @FindBy(xpath = "//label[@for='input-payment-zone']")
    public WebElement regionStatePaymentLabel;

    public PaymentAddressFormLabels(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
