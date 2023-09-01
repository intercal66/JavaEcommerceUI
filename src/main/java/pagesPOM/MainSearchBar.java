package pagesPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainSearchBar {
    @FindBy(xpath = "//input[@name='search']")
    public WebElement searchInput;
    @FindBy(xpath = "//button[text()='Search']")
    public WebElement searchButton;

    public MainSearchBar(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
