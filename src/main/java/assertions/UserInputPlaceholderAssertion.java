package assertions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class UserInputPlaceholderAssertion {
    private static final Logger logger = LogManager.getLogger(UserInputPlaceholderAssertion.class);

    public void assertPlaceholder(String expectedText, WebElement element) {
        String actualText = getPlaceholder(element);
        logger.debug("Asserting Placeholder text: actual = '{}', expected = '{}'", actualText, expectedText);
        Assert.assertEquals(actualText, expectedText, "Error: Placeholder text mismatch");
    }

    public String getPlaceholder(WebElement element) {
        return element.getAttribute("placeholder");
    }

    public UserInputPlaceholderAssertion(WebDriver driver) {
    }
}
