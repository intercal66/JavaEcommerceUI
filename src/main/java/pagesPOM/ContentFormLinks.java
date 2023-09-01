package pagesPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContentFormLinks {
    @FindBy(xpath = "//div[@id=\"content\"]//form//a[contains(@href,'')]")
    public WebElement contentFormLinkElement;
    @FindBy(xpath = "//h1/following-sibling::p/a")
    public WebElement loginLinkElement;

    public ContentFormLinks(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
