package pagesPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutLoginForm {
    @FindBy(id = "input-login-email")
    public WebElement emailInput;
    @FindBy(id = "input-login-password")
    public WebElement passwordInput;
    public CheckoutLoginForm(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
