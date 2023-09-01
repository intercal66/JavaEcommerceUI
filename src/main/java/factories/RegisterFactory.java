package factories;

import base.AutoTemplate;
import models.UserInput;
import org.openqa.selenium.WebDriver;
import pagesPOM.UserFormInputs;
import utilities.Utils;

public class RegisterFactory extends AutoTemplate {

    public void registerDefault(UserInput userInput) {
        utils.clearAndSendKeys(userFormInputs.firstNameInput, userInput.getFirstName());
        utils.clearAndSendKeys(userFormInputs.lastNameInput, userInput.getLastName());
        utils.clearAndSendKeys(userFormInputs.emailInput, userInput.getEmail());
        utils.clearAndSendKeys(userFormInputs.telephoneInput, userInput.getTelephone());
        utils.clearAndSendKeys(userFormInputs.passwordInput, userInput.getPassword());
        utils.clearAndSendKeys(userFormInputs.passwordConfirmInput, userInput.getPasswordConfirm());

        if (userInput.getNewsletterSubscribe()) {
            if (!userFormInputs.newsletterSubscribeYes.isSelected()) {
                userFormInputs.newsletterSubscribeYes.click();
            }
        } else {
            if (!userFormInputs.newsletterSubscribeNo.isSelected()) {
                userFormInputs.newsletterSubscribeNo.click();
            }
        }
        if (userInput.getAgreePrivacyPolicy()) {
            userFormInputs.privacyPolicyCheckbox.click();
        }
    }

    public void registerCheckoutDefault(UserInput userInput) {
        utils.clearAndSendKeys(userFormInputs.firstNameInput, userInput.getFirstName());
        utils.clearAndSendKeys(userFormInputs.lastNameInput, userInput.getLastName());
        utils.clearAndSendKeys(userFormInputs.emailInput, userInput.getEmail());
        utils.clearAndSendKeys(userFormInputs.telephoneInput, userInput.getTelephone());
        utils.clearAndSendKeys(userFormInputs.passwordInput, userInput.getPassword());
        utils.clearAndSendKeys(userFormInputs.passwordConfirmInput, userInput.getPasswordConfirm());
    }

    public RegisterFactory(WebDriver driver) {
        this.userFormInputs = new UserFormInputs(driver);
        this.utils = new Utils(driver);
    }
}
