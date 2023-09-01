package factories;

import base.AutoTemplate;
import models.UserInput;
import org.openqa.selenium.WebDriver;
import pagesPOM.UserFormInputs;
import utilities.Utils;

public class FirstNameLastName extends AutoTemplate {
    public void addFirstNameLastNameDefault(UserInput userInput) {
        utils.clearAndSendKeys(userFormInputs.firstNameInput, userInput.getFirstName());
        utils.clearAndSendKeys(userFormInputs.lastNameInput, userInput.getLastName());
    }

    public FirstNameLastName(WebDriver driver) {
        this.userFormInputs = new UserFormInputs(driver);
        this.utils = new Utils(driver);
    }
}
