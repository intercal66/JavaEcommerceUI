package assertions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pagesPOM.RegistrationFormLabels;

public class RegistrationLabelAssertion {
    private static final Logger logger = LogManager.getLogger(RegistrationValidationAssertion.class);
    private final RegistrationFormLabels registrationFormLabels;

    public void assertLabel(WebElement labelElement, String expectedLabelText) {
        logger.info("'{}' label text asserting Started", expectedLabelText);
        String actualLabelText = labelElement.getText();
        logger.debug("Asserting label text: actual = '{}', expected = '{}'", actualLabelText, expectedLabelText);
        Assert.assertEquals(actualLabelText, expectedLabelText, "Label text for " + expectedLabelText + " does not match.");
        logger.debug("'{}' label text assertion Passed: actual = '{}'", expectedLabelText, actualLabelText);
    }

    public void assertFirstNameLabel() {
        assertLabel(registrationFormLabels.firstNameLabel, "First Name");
    }

    public void assertLastNameLabel() {
        assertLabel(registrationFormLabels.lastNameLabel, "Last Name");
    }

    public void assertEmailLabel() {
        assertLabel(registrationFormLabels.emailLabel, "E-Mail");
    }

    public void assertTelephoneLabel() {
        assertLabel(registrationFormLabels.telephoneLabel, "Telephone");
    }

    public void assertPasswordLabel() {
        assertLabel(registrationFormLabels.passwordLabel, "Password");
    }

    public void assertPasswordConfirmLabel() {
        assertLabel(registrationFormLabels.passwordConfirmLabel, "Password Confirm");
    }

    public void assertNewsletterSubscribeLabel() {
        assertLabel(registrationFormLabels.newsletterSubscribeLabel, "Subscribe");
    }

    public void assertNewsletterYesSubscribeLabel() {
        assertLabel(registrationFormLabels.newsLetterSubscribeYesLabel, "Yes");
    }

    public void assertNewsletterNoSubscribeLabel() {
        assertLabel(registrationFormLabels.newsLetterSubscribeNoLabel, "No");
    }

    public RegistrationLabelAssertion(WebDriver driver) {
        this.registrationFormLabels = new RegistrationFormLabels(driver);
    }
}
