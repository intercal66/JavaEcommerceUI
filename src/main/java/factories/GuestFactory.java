package factories;

import base.AutoTemplate;
import methods.SelectCountryState;
import models.UserInput;
import org.openqa.selenium.WebDriver;
import pagesPOM.UserFormInputs;
import utilities.Utils;

public class GuestFactory extends AutoTemplate {
    public void guestUserDefault(UserInput userInput) {
        utils.clearAndSendKeys(userFormInputs.firstNameInput, userInput.getFirstName());
        utils.clearAndSendKeys(userFormInputs.lastNameInput, userInput.getLastName());
        utils.clearAndSendKeys(userFormInputs.emailInput, userInput.getEmail());
        utils.clearAndSendKeys(userFormInputs.telephoneInput, userInput.getTelephone());
        utils.clearAndSendKeys(userFormInputs.companyInput, userInput.getCompany());
        utils.clearAndSendKeys(userFormInputs.addressInput1, userInput.getAddress1());
        utils.clearAndSendKeys(userFormInputs.addressInput2, userInput.getAddress2());
        utils.clearAndSendKeys(userFormInputs.cityInput, userInput.getCity());
        utils.clearAndSendKeys(userFormInputs.postCodeInput, userInput.getPostCode());
        selectCountryState.selectCountry(userInput.getCountry());
        selectCountryState.selectRegionState(userInput.getRegionState());

        if (userInput.getAgreePrivacyPolicy()) {
            Utils.scrollToAnElementAndClick(userFormInputs.privacyPolicyCheckbox);
        }
    }

    public void guestNameDefault(UserInput userInput) {
        utils.clearAndSendKeys(userFormInputs.firstNameInput, userInput.getFirstName());
        utils.clearAndSendKeys(userFormInputs.lastNameInput, userInput.getLastName());
    }
    public GuestFactory(WebDriver driver) {
        this.userFormInputs = new UserFormInputs(driver);
        this.utils = new Utils(driver);
        this.selectCountryState = new SelectCountryState(driver);
    }
}
