package pagesPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainHomePage {
    @FindBy(tagName = "h1")
    public WebElement mainHeadingH1Element;
    @FindBy(tagName = "h2")
    public WebElement mainHeadingH2Element;
    @FindBy(tagName = "h3")
    public WebElement mainHeadingH3Element;
    @FindBy(tagName = "h4")
    public WebElement mainHeadingH4Element;
    @FindBy(xpath = "//*[@id=\"content\"]/h1")
    public WebElement mainHeadingMessage;
    @FindBy(xpath = "//*[@id=\"content\"]/div/div[2]/div/div/h2")
    public WebElement mainHeadingH2Login;

    @FindBy(xpath = "//*[@id=\"widget-navbar-217834\"]/ul/li[6]/a")
    public WebElement myAccountButton;
    @FindBy(xpath = "//*[@id=\"widget-navbar-217834\"]/ul/li[6]/ul/li[2]/a")
    public WebElement registerButton;
    @FindBy(className = "panel-header")
    public WebElement firstAnnouncementPanelHeader;

    public MainHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
