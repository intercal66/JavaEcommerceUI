package assertions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pagesPOM.RegistrationFormLabels;

public class LoginLabelAssertion {
    private static final Logger logger = LogManager.getLogger(LoginLabelAssertion.class);
    private final RegistrationFormLabels registrationFormLabels;

    public void assertLabel(WebElement labelElement, String expectedLabelText) {
        logger.info("'{}' label text asserting Started", expectedLabelText);
        String actualLabelText = labelElement.getText();
        logger.debug("Asserting label text: actual = '{}', expected = '{}'", actualLabelText, expectedLabelText);
        Assert.assertEquals(actualLabelText, expectedLabelText, "Label text for " + expectedLabelText + " does not match.");
        logger.debug("'{}' Label text assertion Passed: actual = '{}'", expectedLabelText, actualLabelText);
    }

    public void assertEmailLabel() {
        assertLabel(registrationFormLabels.emailLabel, "E-Mail Address");
    }

    public void assertPasswordLabel() {
        assertLabel(registrationFormLabels.passwordLabel, "Password");
    }

    public LoginLabelAssertion(WebDriver driver) {
        this.registrationFormLabels = new RegistrationFormLabels(driver);
    }
}
