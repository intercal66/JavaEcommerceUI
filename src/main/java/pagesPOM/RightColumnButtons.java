package pagesPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RightColumnButtons {
    private final WebDriver driver;

    public RightColumnButtons(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getButtonByText(String buttonText) {
        String cssLocator = String.format("#column-right a[href*='account/%s']", buttonText);
        return driver.findElement(By.cssSelector(cssLocator));
    }

    public WebElement myAccountButton() {
        return getButtonByText("account");
    }

    public WebElement registerAccountButton() {
        return getButtonByText("register");
    }

    public WebElement editAccountButton() {
        return getButtonByText("edit");
    }

    public WebElement passwordAccountButton() {
        return getButtonByText("password");
    }

    public WebElement forgottenPasswordButton() {
        return getButtonByText("forgotten");
    }

    public WebElement addressAccountButton() {
        return getButtonByText("address");
    }

    public WebElement wishlistButton() {
        return getButtonByText("wishlist");
    }

    public WebElement notificationButton() {
        return getButtonByText("notification");
    }

    public WebElement orderHistoryButton() {
        return getButtonByText("order");
    }

    public WebElement downloadsButton() {
        return getButtonByText("downloads");
    }

    public WebElement recurringPaymentsButton() {
        return getButtonByText("recurring");
    }

    public WebElement rewardsPointsButton() {
        return getButtonByText("reward");
    }

    public WebElement returnsButton() {
        return getButtonByText("return");
    }

    public WebElement transactionsButton() {
        return getButtonByText("transaction");
    }

    public WebElement newsletterButton() {
        return getButtonByText("newsletter");
    }

    public WebElement logOutButton() {
        return getButtonByText("logout");
    }
}
