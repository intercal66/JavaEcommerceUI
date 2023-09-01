package pagesPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationFormLabels {
    @FindBy(xpath = "//label[@for='input-firstname']")
    public WebElement firstNameLabel;
    @FindBy(xpath = "//label[@for='input-lastname']")
    public WebElement lastNameLabel;
    @FindBy(xpath = "//label[@for='input-email']")
    public WebElement emailLabel;
    @FindBy(xpath = "//label[@for='input-telephone']")
    public WebElement telephoneLabel;
    @FindBy(xpath = "//label[@for='input-password']")
    public WebElement passwordLabel;
    @FindBy(xpath = "//label[@for='input-confirm']")
    public WebElement passwordConfirmLabel;
    @FindBy(xpath = "//label[text()='Subscribe']")
    public WebElement newsletterSubscribeLabel;
    @FindBy(xpath = "//label[@for='input-newsletter-yes']")
    public WebElement newsLetterSubscribeYesLabel;
    @FindBy(xpath = "//label[@for='input-newsletter-no']")
    public WebElement newsLetterSubscribeNoLabel;

    public RegistrationFormLabels(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
}
