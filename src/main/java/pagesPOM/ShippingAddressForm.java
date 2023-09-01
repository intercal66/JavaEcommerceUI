package pagesPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingAddressForm {

    // ---> # Shipping Address Input Elements #  <---
    @FindBy(id = "input-shipping-firstname")
    public WebElement firstNameShippingInput;
    @FindBy(id = "input-shipping-lastname")
    public WebElement lastNameShippingInput;
    @FindBy(id = "input-shipping-company")
    public WebElement companyShippingInput;
    @FindBy(id = "input-shipping-address-1")
    public WebElement addressShippingInput1;
    @FindBy(id = "input-shipping-address-2")
    public WebElement addressShippingInput2;
    @FindBy(id = "input-shipping-city")
    public WebElement cityShippingInput;
    @FindBy(id = "input-shipping-postcode")
    public WebElement postCodeShippingInput;
    @FindBy(id = "input-shipping-country")
    public WebElement countryShippingInput;
    @FindBy(id = "input-shipping-zone")
    public WebElement regionStateShippingInput;

    // ---> # Shipping Address Label Elements # <---
    @FindBy(xpath = "//label[@for='input-shipping-firstname']")
    public WebElement firstNameShippingLabel;
    @FindBy(xpath = "//label[@for='input-shipping-lastname']")
    public WebElement lastNameShippingLabel;
    @FindBy(xpath = "//label[@for='input-shipping-company']")
    public WebElement companyShippingLabel;
    @FindBy(xpath = "//label[@for='input-shipping-address-1']")
    public WebElement address1ShippingLabel;
    @FindBy(xpath = "//label[@for='input-shipping-address-2']")
    public WebElement address2ShippingLabel;
    @FindBy(xpath = "//label[@for='input-shipping-city']")
    public WebElement cityShippingLabel;
    @FindBy(xpath = "//label[@for='input-shipping-postcode']")
    public WebElement postCodeShippingLabel;
    @FindBy(xpath = "//label[@for='input-shipping-country']")
    public WebElement countryShippingLabel;
    @FindBy(xpath = "//label[@for='input-shipping-zone']")
    public WebElement regionStateShippingLabel;

    public ShippingAddressForm(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
