package pagesPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
    @FindBy(xpath = "//*[@id=\"content\"]/div/div[1]/div/div/a") //
    public WebElement registerButton;
    @FindBy(xpath = "//input[@value='Login']")
    public WebElement loginButton;
    @FindBy(xpath = "//input[@value='Continue']")
    public WebElement continueButton;

    public AccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
