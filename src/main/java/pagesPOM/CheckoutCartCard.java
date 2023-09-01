package pagesPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutCartCard {
    @FindBy(xpath = "//td[@class='text-center']/a/img")
    public WebElement imageItem;
    @FindBy(xpath = "//td[@class=\"text-left\"]/a[@data-toggle=\"tooltip\"]")
    public WebElement productName;
    @FindBy(xpath = "//td[@class=\"text-left\"]/a[@data-toggle=\"tooltip\"]/following-sibling::small")
    public WebElement productModel;
    @FindBy(xpath = "//*[@class=\"form-control remove-spin-button\"]")
    public WebElement quantityInput;
    @FindBy(xpath = "//button[@data-original-title='Update']")
    public WebElement updateButton;
    @FindBy(xpath = "//button[@data-original-title='Remove']")
    public WebElement removeButton;
    @FindBy(xpath = "//*[@id=\"checkout-cart\"]/table/tbody/tr/td[4]")
    public WebElement unitPrice;
    @FindBy(xpath = "//*[@id=\"checkout-cart\"]/table/tbody/tr/td[5]")
    public WebElement totalPrice;
    @FindBy(xpath = "//*[@id=\"checkout-total\"]/tbody/tr[1]/td[2]")
    public WebElement subTotalPrice;
    @FindBy(xpath = "//*[@id=\"checkout-total\"]/tbody/tr[2]/td[2]")
    public WebElement flatShipRatePrice;
    @FindBy(xpath = "//*[@id=\"checkout-total\"]/tbody/tr[3]/td[2]")
    public WebElement totalValue;

    public CheckoutCartCard(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
