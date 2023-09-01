package pagesPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmOrderPage {
    @FindBy(xpath = "//*[@id=\"content\"]/div[1]/table/tbody/tr/td[1]")
    public WebElement productNameConfirm;
    @FindBy(xpath = "//*[@id=\"content\"]/div[1]/table/tbody/tr/td[2]")
    public WebElement modelConfirm;
    @FindBy(xpath = "//*[@id=\"content\"]/div[1]/table/tbody/tr/td[3]")
    public WebElement quantityConfirm;
    @FindBy(xpath = "//*[@id=\"content\"]/div[1]/table/tbody/tr/td[4]")
    public WebElement priceConfirm;
    @FindBy(xpath = "//*[@id=\"content\"]/div[1]/table/tfoot/tr[1]/td[2]")
    public WebElement subTotalConfirm;
    @FindBy(xpath = "//*[@id=\"content\"]/div[1]/table/tfoot/tr[2]/td[2]")
    public WebElement flatShipRateConfirm;
    @FindBy(xpath = "//*[@id=\"content\"]/div[1]/table/tfoot/tr[3]/td[2]")
    public WebElement totalValueConfirm;
    @FindBy(xpath = "//h1[contains(@class, 'page-title my-3')]")
    public WebElement confirmOrderMessage;

    public ConfirmOrderPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
