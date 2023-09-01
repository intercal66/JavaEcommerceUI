package pagesPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ErrorMessageHandler {
    private final WebDriver driver;

    @FindBy(className = "alert-dismissible")
    private WebElement mainErrorSummaryElement;
    @FindBy(xpath = "//*[@id=\"collapse-coupon\"]/div/div[1]")
    private WebElement couponError;

    public ErrorMessageHandler(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getMainErrorSummaryElement() {
        return mainErrorSummaryElement;
    }
    public WebElement getCouponError(){
        return couponError;
    }

    // --> Get the error message associated with a specific input label <--
    public String getErrorMessageForLabel(String inputLabel) {
        String xpathLocator = String.format("//label[text()='%s']//following-sibling::div/div", inputLabel);
        WebElement errorElement = driver.findElement(By.xpath(xpathLocator));
        return errorElement.getText();
    }

    // --> Get the warning message displayed during registration <--
    public String getRegisterWarningMessage() {
        String REGISTER_WARNING_XPATH = "//*[@id=\"account-register\"]/div[1]";
        return driver.findElement(By.xpath(REGISTER_WARNING_XPATH)).getText();
    }

    // --> Get the warning message displayed during login <--
    public String getLoginWarningMessage() {
        String LOGIN_WARNING_XPATH = "//*[@id=\"account-login\"]/div[1]";
        return driver.findElement(By.xpath(LOGIN_WARNING_XPATH)).getText();
    }

    // --> Get the warning message displayed for a coupon <--
    public String getCouponWarningMessage() {
        String COUPON_WARNING_XPATH = "//*[@id=\"collapse-coupon\"]/div/div[1]";
        return driver.findElement(By.xpath(COUPON_WARNING_XPATH)).getText();
    }
}
