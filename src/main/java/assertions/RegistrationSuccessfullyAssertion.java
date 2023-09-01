package assertions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pagesPOM.MainHomePage;

import java.io.IOException;

import static utilities.UrlPropertiesReader.getUrlProperty;
import static utilities.Utils.driver;

public class RegistrationSuccessfullyAssertion {
    private static final Logger logger = LogManager.getLogger(RegistrationSuccessfullyAssertion.class);
    private final MainHomePage mainHomePage;
    private static final String REGISTER_SUCCESS_URL = "RegisterSuccessUrl";

    public RegistrationSuccessfullyAssertion(WebDriver driver) {
        this.mainHomePage = new MainHomePage(driver);
    }

    public void assertAccountCreationSuccess() {
        String expectedMessage = "Your Account Has Been Created!";
        String actualMessage = mainHomePage.mainHeadingH1Element.getText().trim();
        logger.debug("Asserting Account Successfully created: expected = '{}', actual = '{}'", expectedMessage, actualMessage);
        Assert.assertEquals(expectedMessage, actualMessage, "Error: Account creation success message does not match");
    }

    public void assertAccountCreationSuccessUrl() throws IOException {
        String expectedLink = getUrlProperty(REGISTER_SUCCESS_URL);
        String actualLink = driver.getCurrentUrl();
        logger.debug("Asserting Success Register Page link: expected = '{}', actual = '{}'", expectedLink, actualLink);
        Assert.assertEquals(actualLink, expectedLink, "Error: Incorrect Success Register Page link");
    }
}
