package factories;

import base.AutoTemplate;
import models.UserInput;
import models.UserProperties;
import org.openqa.selenium.WebDriver;
import pagesPOM.CheckoutLoginForm;
import pagesPOM.UserFormInputs;
import utilities.Utils;

import java.io.IOException;

public class LoginFactory extends AutoTemplate {

    public void loginDefault(UserInput userInput) {
        utils.clearAndSendKeys(userFormInputs.emailInput, userInput.getEmail());
        utils.clearAndSendKeys(userFormInputs.passwordInput, userInput.getPassword());
    }

    public void loginCheckoutDefault(UserInput userInput) throws IOException {
        utils.clearAndSendKeys(checkoutLoginForm.emailInput, UserProperties.getUserEmail());
        utils.clearAndSendKeys(checkoutLoginForm.passwordInput, UserProperties.getUserPassword());
    }

    public LoginFactory(WebDriver driver) {
        this.userFormInputs = new UserFormInputs(driver);
        this.checkoutLoginForm = new CheckoutLoginForm(driver);
        this.utils = new Utils(driver);
    }
}
