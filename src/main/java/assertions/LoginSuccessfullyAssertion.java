package assertions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pagesPOM.MainHomePage;

public class LoginSuccessfullyAssertion {
    private static final Logger logger = LogManager.getLogger(LoginSuccessfullyAssertion.class);
    private final MainHomePage mainHomePage;

    public void assertLoginSuccess() {
        String expectedMessage = "My Account";
        String actualMessage = mainHomePage.mainHeadingH2Element.getText().trim();
        logger.debug("Asserting Login: actual = '{}', expected = '{}'", actualMessage, expectedMessage);
        Assert.assertEquals(actualMessage, expectedMessage, "Error: Login was not successful");
    }

    public LoginSuccessfullyAssertion(WebDriver driver) {
        this.mainHomePage = new MainHomePage(driver);
    }

}
