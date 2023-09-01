package utilities;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utils {
    public static WebDriver driver;

    public Utils(WebDriver driver) {
        Utils.driver = driver;
    }

    public static void setPageLoadTimeout(int timeoutSeconds) {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(timeoutSeconds));
    }

    public static void explicitWaitElementToBeClickable(WebElement element, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void explicitWaitForWebElementToBeClickableAndClick(WebElement element, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public static void explicitWaitForElementToBeClickableAndClick(By element, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public static WebElement explicitWaitForVisibilityOfElement(WebElement element, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static void explicitWaitForVisibilityAndClick(WebElement element, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        wait.until(ExpectedConditions.visibilityOf(element)).click();
    }

    public static WebElement explicitWaitForElementLocator(By locator, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static String waitForURLToBeDisplayedAndGetCurrentURL(String getCurrentURL, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        wait.until(ExpectedConditions.urlToBe(getCurrentURL));
        return driver.getCurrentUrl();
    }
    public static void scrollToAnElementAndClick(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }

    public void clearAndSendKeys(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }

    public String randomAlphaNumeric(int x) {
        return RandomStringUtils.randomAlphanumeric(x);
    }

    public String randomNumeric(int x) {
        return RandomStringUtils.randomNumeric(x);
    }

    public String randomAlphabetic(int x) {
        return RandomStringUtils.randomAlphabetic(x);
    }

    public String repeatCharacter(String x, int count) {
        return StringUtils.repeat(x, count);
    }

    public static boolean isEmailFormatValid(String email) {
        // # Check if input text contains the "@" symbol -->
        if (email.contains("@")) {

            // # Split the input text into two parts: username and domain -->
            String[] parts = email.split("@");
            if (parts.length == 2) {
                String username = parts[0];
                String domain = parts[1];

                // # Check if domain contains a dot (.) -->
                if (domain.contains(".")) {

                    // # Split the domain into two parts: domain name and top-level domain -->
                    String[] domainParts = domain.split("\\.");
                    if (domainParts.length == 2) {
                        String domainName = domainParts[0];
                        String topLevelDomain = domainParts[1];

                        // # Check if username, domain name, and top-level domain contain only letters -->
                        if (username.matches("[a-zA-Z]+") &&
                                domainName.matches("[a-zA-Z]+") &&
                                topLevelDomain.matches("[a-zA-Z]+")) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }
}
