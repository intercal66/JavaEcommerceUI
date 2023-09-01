package pagesPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartProductPage {
    @FindBy(xpath = "//*[@id=\"entry_217825\"]/a")
    public WebElement itemCheckCartButton;
    @FindBy(xpath = "//*[@id=\"entry_217850\"]/a")
    public WebElement editCartButton;
    @FindBy(xpath = "//*[@id=\"entry_217851\"]/a")
    public WebElement checkoutButton;
    @FindBy(xpath = "//*[@id=\"content\"]/div[2]/a[2]")
    public WebElement checkoutShoppingCartButton;

    public CartProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
