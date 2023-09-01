package pagesPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainProductPage {
    @FindBy(xpath = "//*[@id=\"entry_216842\"]/button")
    public WebElement addToCartButton;
    @FindBy(xpath = "//*[@id=\"entry_216843\"]/button")
    public WebElement buyNowButton;
    @FindBy(xpath = "//*[@id=\"button-review\"]")
    public WebElement writeReviewButton;
    @FindBy(xpath = "//button[@class='btn btn-light' and @data-spinner='down']") // //*[@id="entry_216841"]/div/div[1]/button
    public WebElement decreaseQuantityButton;
    @FindBy(xpath = "//button[@class='btn btn-light' and @data-spinner='up']") // //*[@id="entry_216841"]/div/div[2]/button
    public WebElement increaseQuantityButton;
    @FindBy(xpath = "//div[@id='entry_216844']/button[@title='Compare this ProductProperties']")
    public WebElement compareProductButton;
    @FindBy(xpath = "//div[@id='entry_216848']/a[@href='#mz-component-78181048']")
    public WebElement sizeChartButton;
    @FindBy(xpath = "//div[@id='entry_216849']/a[@href='#mz-component-983507417']")
    public WebElement popupButton;
    @FindBy(xpath = "//div[@id='entry_216850']/a[@href='#mz-component-752738972']")
    public WebElement askQuestionButton;

    public MainProductPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
}
