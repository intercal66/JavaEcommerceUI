package factories;

import base.AutoTemplate;
import methods.SelectCountryState;
import models.UserInput;
import org.openqa.selenium.WebDriver;
import pagesPOM.UserFormInputs;
import pagesPOM.ShippingAddressForm;
import utilities.Utils;

public class AddressFactory extends AutoTemplate {
    public void billingAddressDefault(UserInput userInput) {
        utils.clearAndSendKeys(userFormInputs.firstNameInput, userInput.getFirstName());
        utils.clearAndSendKeys(userFormInputs.lastNameInput, userInput.getLastName());
        utils.clearAndSendKeys(userFormInputs.emailInput, userInput.getEmail());
        utils.clearAndSendKeys(userFormInputs.telephoneInput, userInput.getTelephone());
        utils.clearAndSendKeys(userFormInputs.passwordInput, userInput.getPassword());
        utils.clearAndSendKeys(userFormInputs.passwordConfirmInput, userInput.getPasswordConfirm());
        utils.clearAndSendKeys(userFormInputs.companyInput, userInput.getCompany());
        utils.clearAndSendKeys(userFormInputs.addressInput1, userInput.getAddress1());
        utils.clearAndSendKeys(userFormInputs.addressInput2, userInput.getAddress2());
        utils.clearAndSendKeys(userFormInputs.cityInput, userInput.getCity());
        utils.clearAndSendKeys(userFormInputs.postCodeInput, userInput.getPostCode());
        selectCountryState.selectCountry(userInput.getCountry());
        selectCountryState.selectRegionState(userInput.getRegionState());

        if (userInput.getAgreePrivacyTerms()) {
            Utils.scrollToAnElementAndClick(userFormInputs.privacyPolicyTerms);
        }
        if (userInput.getAgreePrivacyPolicy()) {
            Utils.scrollToAnElementAndClick(userFormInputs.privacyPolicyCheckbox);
        }
    }

    public void paymentAddressDefault(UserInput userInput){
        utils.clearAndSendKeys(userFormInputs.firstNameInput, userInput.getFirstName());
        utils.clearAndSendKeys(userFormInputs.lastNameInput, userInput.getLastName());
        utils.clearAndSendKeys(userFormInputs.companyInput, userInput.getCompany());
        utils.clearAndSendKeys(userFormInputs.addressInput1, userInput.getAddress1());
        utils.clearAndSendKeys(userFormInputs.addressInput2, userInput.getAddress2());
        utils.clearAndSendKeys(userFormInputs.cityInput, userInput.getCity());
        utils.clearAndSendKeys(userFormInputs.postCodeInput, userInput.getPostCode());
        selectCountryState.selectCountry(userInput.getCountry());
        selectCountryState.selectRegionState(userInput.getRegionState());
    }

    public void shippingAddressDefault(UserInput userInput) {
        utils.clearAndSendKeys(shippingAddressForm.firstNameShippingInput, userInput.getFirstName());
        utils.clearAndSendKeys(shippingAddressForm.lastNameShippingInput, userInput.getLastName());
        utils.clearAndSendKeys(shippingAddressForm.companyShippingInput, userInput.getCompany());
        utils.clearAndSendKeys(shippingAddressForm.addressShippingInput1, userInput.getAddress1());
        utils.clearAndSendKeys(shippingAddressForm.addressShippingInput2, userInput.getAddress2());
        utils.clearAndSendKeys(shippingAddressForm.cityShippingInput, userInput.getCity());
        utils.clearAndSendKeys(shippingAddressForm.postCodeShippingInput, userInput.getPostCode());
        selectCountryState.selectCountry(userInput.getCountry());
        selectCountryState.selectRegionState(userInput.getRegionState());
    }

    public AddressFactory(WebDriver driver) {
        this.selectCountryState = new SelectCountryState(driver);
        this.shippingAddressForm = new ShippingAddressForm(driver);
        this.userFormInputs = new UserFormInputs(driver);
        this.utils = new Utils(driver);
    }
}
