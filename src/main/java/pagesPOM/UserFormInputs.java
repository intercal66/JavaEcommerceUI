package pagesPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserFormInputs {
    @FindBy(name = "firstname")
    public WebElement firstNameInput;
    @FindBy(name = "lastname")
    public WebElement lastNameInput;
    @FindBy(name = "email")
    public WebElement emailInput;
    @FindBy(name = "telephone")
    public WebElement telephoneInput;
    @FindBy(name = "password")
    public WebElement passwordInput;
    @FindBy(name = "confirm")
    public WebElement passwordConfirmInput;
    @FindBy(name = "company")
    public WebElement companyInput;
    @FindBy(name = "address_1")
    public WebElement addressInput1;
    @FindBy(name = "address_2")
    public WebElement addressInput2;
    @FindBy(name = "city")
    public WebElement cityInput;
    @FindBy(name = "postcode")
    public WebElement postCodeInput;
    @FindBy(name = "country_id")
    public WebElement countryInput;
    @FindBy(name = "zone_id")
    public WebElement regionStateInput;
    @FindBy(xpath = "//label[@class='custom-control-label' and @for='input-newsletter-yes']")
    public WebElement newsletterSubscribeYes;
    @FindBy(xpath = "//label[@class='custom-control-label' and @for='input-newsletter-no']")
    public WebElement newsletterSubscribeNo;
    @FindBy(xpath = "//input[@id='input-agree']/following-sibling::label")
    public WebElement privacyPolicyCheckbox;
    @FindBy(xpath = "//a[@class='agree']")
    public WebElement privacyPolicyLink;
    @FindBy(xpath = "//input[@id='input-agree']/following-sibling::label//a[@class='agree']")
    public WebElement privacyTermsLink;
    @FindBy(xpath = "//input[@id='input-account-agree']/following-sibling::label")
    public WebElement privacyPolicyTerms;
    @FindBy(xpath = "//h1/following-sibling::p/a")
    public WebElement loginLink;

    public WebElement getNewsletterSubscribeYes() {
        return newsletterSubscribeYes;
    }
    public WebElement getNewsletterSubscribeNo() {
        return newsletterSubscribeNo;
    }
    public WebElement getPrivacyPolicyCheckbox() {
        return privacyPolicyCheckbox;
    }

    public UserFormInputs(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
