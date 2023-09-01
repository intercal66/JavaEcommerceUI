package checkout;

import base.AutoTemplate;
import factories.UserInputFactory;
import models.UserInput;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.Utils;

import java.io.IOException;

public class CheckoutAddressValidationTests extends AutoTemplate {
    private static final Logger logger = LogManager.getLogger(CheckoutAddressValidationTests.class);
    private static final String EMPTY_INPUT_FIELD = "";
    private static final String USER_PASSWORD = "password";
    private static final String CONFIRM_PASSWORD = "password1";
    private static final String NO_SELECTED = " --- Please Select --- ";

    @BeforeMethod
    public void setupTest() throws IOException {
        logger.info("Starting Test: {}", getClass().getSimpleName());
        Utils.setPageLoadTimeout(10);
    }

    public void performCheckoutFlow() throws IOException {
        searchProduct.performSearchProduct();
        selectProduct.clickOnProductLocator();
        addProduct.addItemToCart();
    }

    public void completeCheckout() {
        Utils.explicitWaitElementToBeClickable(checkoutFormPage.continueSaveButton, 5);
        Utils.scrollToAnElementAndClick(checkoutFormPage.continueSaveButton);
        Utils.explicitWaitForVisibilityOfElement(errorMessageHandler.getMainErrorSummaryElement(), 5);
    }

    @Test
    public void firstNameAddressValidationWhenEmpty() throws IOException {
        logger.info("Starting Test: First Name Address validation displayed when 'First Name' is 'Empty'");
        performCheckoutFlow();
        UserInput userInput = UserInputFactory.createDefaultUserInput();
        userInput.setFirstName(EMPTY_INPUT_FIELD);
        addressFactory.billingAddressDefault(userInput);
        completeCheckout();
        registrationValidationAssertion.assertFirstNameValidation();
        logger.info("Test Completed: First Name Address validation displayed when 'First Name' is 'Empty'");
    }

    @Test
    public void firstNameAddressValidationWhenLength33Char() throws IOException {
        logger.info("Starting Test: First Name Address validation displayed when 'First Name' length is '33-Characters'");
        performCheckoutFlow();
        UserInput userInput = UserInputFactory.createDefaultUserInput();
        userInput.setFirstName(utils.randomAlphabetic(33));
        addressFactory.billingAddressDefault(userInput);
        completeCheckout();
        registrationValidationAssertion.assertFirstNameValidation();
        logger.info("Test Completed: First Name Address validation displayed when 'First Name' length is '33-Characters'");
    }

    @Test
    public void lastNameAddressValidationWhenEmpty() throws IOException {
        logger.info("Starting Test: Last Name Address validation displayed when 'Last Name' is 'Empty'");
        performCheckoutFlow();
        UserInput userInput = UserInputFactory.createDefaultUserInput();
        userInput.setLastName(EMPTY_INPUT_FIELD);
        addressFactory.billingAddressDefault(userInput);
        completeCheckout();
        registrationValidationAssertion.assertLastNameValidation();
        logger.info("Test Completed: Last Name Address validation displayed when 'Last Name' is 'Empty'");
    }

    @Test
    public void lastNameAddressValidationWhenLength33Char() throws IOException {
        logger.info("Starting Test: Last Name Address validation displayed when 'Last Name' length is '33-Characters'");
        performCheckoutFlow();
        UserInput userInput = UserInputFactory.createDefaultUserInput();
        userInput.setLastName(utils.randomAlphabetic(33));
        addressFactory.billingAddressDefault(userInput);
        completeCheckout();
        registrationValidationAssertion.assertLastNameValidation();
        logger.info("Test Completed: Last Name Address validation displayed when 'Last Name' length is '33-Characters'");
    }

    @Test
    public void emailAddressValidationWhenEmpty() throws IOException {
        logger.info("Starting Test: E-Mail Address validation displayed when 'E-Mail' is 'Empty'");
        performCheckoutFlow();
        UserInput userInput = UserInputFactory.createDefaultUserInput();
        userInput.setEmail(EMPTY_INPUT_FIELD);
        addressFactory.billingAddressDefault(userInput);
        completeCheckout();
        checkoutAddressValidationAssertion.assertEmailValidation();
        logger.info("Test Completed: E-Mail Address validation displayed when 'E-Mail' is 'Empty'");
    }

    @Test
    public void emailAddressValidationWhenSymbolSeparator() throws IOException {
        logger.info("Starting Test: E-Mail Address validation displayed when 'E-Mail' contains a 'Symbol Separator'");
        performCheckoutFlow();
        UserInput userInput = UserInputFactory.createDefaultUserInput();
        userInput.setEmail("email" + "@" + utils.randomAlphabetic(4));
        addressFactory.billingAddressDefault(userInput);
        completeCheckout();
        checkoutAddressValidationAssertion.assertEmailValidation();
        logger.info("Test Completed: E-Mail Address validation displayed when 'E-Mail' contains a 'Symbol Separator'");
    }

    @Test
    public void emailAddressValidationWhenIncorrectSet() throws IOException {
        logger.info("Starting Test: E-Mail Address validation displayed when 'E-Mail' is 'Incorrect Set' format");
        performCheckoutFlow();
        UserInput userInput = UserInputFactory.createDefaultUserInput();
        userInput.setEmail(EMPTY_INPUT_FIELD);
        addressFactory.billingAddressDefault(userInput);
        completeCheckout();
        checkoutAddressValidationAssertion.assertEmailValidation();
        logger.info("Test Completed: E-Mail Address validation displayed when 'E-Mail' is 'Incorrect Set' format");
    }

    @Test
    public void telephoneAddressValidationWhenEmpty() throws IOException {
        logger.info("Starting Test: Telephone Address validation displayed when 'Telephone' is 'Empty'");
        performCheckoutFlow();
        UserInput userInput = UserInputFactory.createDefaultUserInput();
        userInput.setTelephone(EMPTY_INPUT_FIELD);
        addressFactory.billingAddressDefault(userInput);
        completeCheckout();
        registrationValidationAssertion.assertTelephoneValidation();
        logger.info("Test Completed: Telephone Address validation displayed when 'Telephone' is 'Empty'");
    }

    @Test
    public void telephoneAddressValidationWhenLength1Char() throws IOException {
        logger.info("Starting Test: Telephone Address validation displayed when 'Telephone' is '1-Character'");
        performCheckoutFlow();
        UserInput userInput = UserInputFactory.createDefaultUserInput();
        userInput.setTelephone(utils.randomNumeric(1));
        addressFactory.billingAddressDefault(userInput);
        completeCheckout();
        registrationValidationAssertion.assertTelephoneValidation();
        logger.info("Test Completed: Telephone Address validation displayed when 'Telephone' is '1-Character'");
    }

    @Test
    public void telephoneAddressValidationWhenLength2Char() throws IOException {
        logger.info("Starting Test: Telephone Address validation displayed when 'Telephone' length is '2-Characters'");
        performCheckoutFlow();
        UserInput userInput = UserInputFactory.createDefaultUserInput();
        userInput.setTelephone(utils.randomNumeric(2));
        addressFactory.billingAddressDefault(userInput);
        completeCheckout();
        registrationValidationAssertion.assertTelephoneValidation();
        logger.info("Test Completed: Telephone Address validation displayed when 'Telephone' length is '2-Characters'");
    }

    @Test
    public void telephoneAddressValidationWhenLength33Char() throws IOException {
        logger.info("Starting Test: Telephone Address validation displayed when 'Telephone' length is '33-Characters'");
        performCheckoutFlow();
        UserInput userInput = UserInputFactory.createDefaultUserInput();
        userInput.setTelephone(utils.randomNumeric(33));
        addressFactory.billingAddressDefault(userInput);
        completeCheckout();
        registrationValidationAssertion.assertTelephoneValidation();
        logger.info("Test Completed: Telephone Address validation displayed when 'Telephone' length is '33-Characters'");
    }

    @Test
    public void passwordDisplayedEncrypted() throws IOException {
        logger.debug("Starting Test: Password Address displayed 'Encrypted' when type Password");
        performCheckoutFlow();
        String actualType = userFormInputs.passwordInput.getAttribute("type");
        Assert.assertEquals(USER_PASSWORD, actualType, "Error: Password input field is not encrypted");
        logger.debug("Password input field is 'Encrypted': actual = '{}'", actualType);
        logger.debug("Test Completed: Password Address displayed 'Encrypted' when type Password");
    }

    @Test
    public void passwordAddressValidationWhenEmpty() throws IOException {
        logger.info("Starting Test: Password Address validation displayed when 'Password' is 'Empty'");
        performCheckoutFlow();
        UserInput userInput = UserInputFactory.createDefaultUserInput();
        userInput.setPassword(EMPTY_INPUT_FIELD);
        addressFactory.billingAddressDefault(userInput);
        completeCheckout();
        registrationValidationAssertion.assertPasswordValidation();
        logger.info("Test Completed: Password Address validation displayed when 'Password' is 'Empty'");
    }

    @Test
    public void passwordAddressValidationWhenLength1Char() throws IOException {
        logger.info("Starting Test: Password Address validation displayed when 'Password' is '1-Character'");
        performCheckoutFlow();
        UserInput userInput = UserInputFactory.createDefaultUserInput();
        userInput.setPassword(utils.randomAlphaNumeric(1));
        addressFactory.billingAddressDefault(userInput);
        completeCheckout();
        registrationValidationAssertion.assertPasswordValidation();
        logger.info("Test Completed: Password Address validation displayed when 'Password' is '1-Character'");
    }

    @Test
    public void passwordAddressValidationWhenLength2Char() throws IOException {
        logger.info("Starting Test: Password Address validation displayed when 'Password' length is '2-Characters'");
        performCheckoutFlow();
        UserInput userInput = UserInputFactory.createDefaultUserInput();
        userInput.setPassword(utils.randomAlphaNumeric(2));
        addressFactory.billingAddressDefault(userInput);
        completeCheckout();
        registrationValidationAssertion.assertPasswordValidation();
        logger.info("Test Completed: Password Address validation displayed when 'Password' length is '2-Characters'");
    }

    @Test
    public void passwordAddressValidationWhenLength3Char() throws IOException {
        logger.info("Starting Test: Password Address validation displayed when 'Password' length is '3-Characters'");
        performCheckoutFlow();
        UserInput userInput = UserInputFactory.createDefaultUserInput();
        userInput.setPassword(utils.randomAlphaNumeric(3));
        addressFactory.billingAddressDefault(userInput);
        completeCheckout();
        registrationValidationAssertion.assertPasswordValidation();
        logger.info("Test Completed: Password Address validation displayed when 'Password' length is '3-Characters'");
    }

    @Test
    public void passwordAddressValidationWhenLength41Char() throws IOException {
        logger.info("Starting Test: Password Address validation displayed when 'Password' length is '41-Characters'");
        performCheckoutFlow();
        UserInput userInput = UserInputFactory.createDefaultUserInput();
        userInput.setPassword(utils.randomAlphaNumeric(41));
        addressFactory.billingAddressDefault(userInput);
        completeCheckout();
        registrationValidationAssertion.assertPasswordValidation();
        logger.info("Test Completed: Password Address validation displayed when 'Password' length is '41-Characters'");
    }

    @Test
    public void passwordConfirmDisplayedEncrypted() throws IOException {
        logger.debug("Starting Test: Password Confirmation Address displayed 'Encrypted' when type 'Password'");
        performCheckoutFlow();
        String actualType = userFormInputs.passwordConfirmInput.getAttribute("type");
        Assert.assertEquals(USER_PASSWORD, actualType, "Error: Password input field is not encrypted");
        logger.debug("Password input field is 'Encrypted': actual = '{}'", actualType);
        logger.debug("Test Completed: Password Confirmation Address displayed 'Encrypted' when type 'Password'");
    }

    @Test
    public void passwordConfirmAddressValidationWhenEmpty() throws IOException {
        logger.info("Starting Test: Password Confirmation Address validation displayed when 'Password Confirm' is 'Empty'");
        performCheckoutFlow();
        UserInput userInput = UserInputFactory.createDefaultUserInput();
        userInput.setPasswordConfirm(utils.randomAlphaNumeric(2));
        addressFactory.billingAddressDefault(userInput);
        completeCheckout();
        registrationValidationAssertion.assertPasswordConfirmValidation();
        logger.info("Test Completed: Password Confirmation Address validation displayed when 'Password Confirm' is 'Empty'");
    }

    @Test
    public void passwordConfirmAddressValidationWhenMismatch() throws IOException {
        logger.info("Starting Test: Password Confirmation Address validation displayed when 'Password Confirm' 'Mismatch'");
        performCheckoutFlow();
        UserInput userInput = UserInputFactory.createDefaultUserInput();
        userInput.setPassword(USER_PASSWORD);
        userInput.setPasswordConfirm(CONFIRM_PASSWORD);
        addressFactory.billingAddressDefault(userInput);
        completeCheckout();
        registrationValidationAssertion.assertPasswordConfirmValidation();
        logger.info("Test Completed: Password Confirmation Address validation displayed when 'Password Confirm' 'Mismatch'");
    }

    @Test
    public void address1AddressValidationWhenEmpty() throws IOException {
        logger.info("Starting Test: Address 1 Address validation displayed when 'Address 1' is 'Empty'");
        performCheckoutFlow();
        UserInput userInput = UserInputFactory.createDefaultUserInput();
        userInput.setAddress1(EMPTY_INPUT_FIELD);
        addressFactory.billingAddressDefault(userInput);
        completeCheckout();
        checkoutAddressValidationAssertion.assertAddress1Validation();
        logger.info("Test Completed: Address 1 Address validation displayed when 'Address 1' is 'Empty'");
    }

    @Test
    public void address1AddressValidationWhenLength1Char() throws IOException {
        logger.info("Starting Test: Address 1 Address validation displayed when 'Address 1' is '1-Character'");
        performCheckoutFlow();
        UserInput userInput = UserInputFactory.createDefaultUserInput();
        userInput.setAddress1(utils.randomAlphabetic(1));
        addressFactory.billingAddressDefault(userInput);
        completeCheckout();
        checkoutAddressValidationAssertion.assertAddress1Validation();
        logger.info("Test Completed: Address 1 Address validation displayed when 'Address 1' is '1-Character'");
    }

    @Test
    public void address1AddressValidationWhenLength2Char() throws IOException {
        logger.info("Starting Test: Address 1 Address validation displayed when 'Address 1' length is '2-Characters'");
        performCheckoutFlow();
        UserInput userInput = UserInputFactory.createDefaultUserInput();
        userInput.setAddress1(utils.randomAlphabetic(2));
        addressFactory.billingAddressDefault(userInput);
        completeCheckout();
        checkoutAddressValidationAssertion.assertAddress1Validation();
        logger.info("Test Completed: Address 1 Address validation displayed when 'Address 1' length is '2-Characters'");
    }

    @Test
    public void address1AddressValidationWhenLength129Char() throws IOException {
        logger.info("Starting Test: Address 1 Address validation displayed when 'Address 1' length is '129-Characters'");
        performCheckoutFlow();
        UserInput userInput = UserInputFactory.createDefaultUserInput();
        userInput.setAddress1(utils.randomAlphabetic(129));
        addressFactory.billingAddressDefault(userInput);
        completeCheckout();
        checkoutAddressValidationAssertion.assertAddress1Validation();
        logger.info("Test Completed: Address 1 Address validation displayed when 'Address 1' length is '129-Characters'");
    }

    @Test
    public void cityAddressValidationWhenEmpty() throws IOException {
        logger.info("Starting Test: City Address validation displayed when 'City' is 'Empty'");
        performCheckoutFlow();
        UserInput userInput = UserInputFactory.createDefaultUserInput();
        userInput.setCity(utils.randomAlphabetic(129));
        addressFactory.billingAddressDefault(userInput);
        completeCheckout();
        checkoutAddressValidationAssertion.assertCityValidation();
        logger.info("Test Completed: City Address validation displayed when 'City' is 'Empty'");
    }

    @Test
    public void cityAddressValidationWhenLength1Char() throws IOException {
        logger.info("Starting Test: City Address validation displayed when 'City' is '1-Character'");
        performCheckoutFlow();
        UserInput userInput = UserInputFactory.createDefaultUserInput();
        userInput.setCity(utils.randomAlphabetic(1));
        addressFactory.billingAddressDefault(userInput);
        completeCheckout();
        checkoutAddressValidationAssertion.assertCityValidation();
        logger.info("Test Completed: City Address validation displayed when 'City' is '1-Character'");
    }

    @Test
    public void cityAddressValidationWhenLength129Char() throws IOException {
        logger.info("Starting Test: City Address validation displayed when 'City' length is '129-Characters'");
        performCheckoutFlow();
        UserInput userInput = UserInputFactory.createDefaultUserInput();
        userInput.setCity(utils.randomAlphabetic(129));
        addressFactory.billingAddressDefault(userInput);
        completeCheckout();
        checkoutAddressValidationAssertion.assertCityValidation();
        logger.info("Test Completed: City Address validation displayed when 'City' length is '129-Characters'");
    }

    @Test
    public void countryAddressValidationWhenNoSelected() throws IOException {
        logger.info("Starting Test: Country Address validation displayed when 'Country' is 'Not Selected'");
        performCheckoutFlow();
        UserInput userInput = UserInputFactory.createDefaultUserInput();
        userInput.setCountry(NO_SELECTED);
        userInput.setRegionState(NO_SELECTED);
        addressFactory.billingAddressDefault(userInput);
        completeCheckout();
        checkoutAddressValidationAssertion.assertCountryValidation();
        logger.info("Test Completed: Country Address validation displayed when 'Country' is 'Not Selected'");
    }

    @Test
    public void regionStateAddressValidationWhenNoSelected() throws IOException {
        logger.info("Starting Test: Region/State Address validation displayed when 'Region/State' is 'Not Selected'");
        performCheckoutFlow();
        UserInput userInput = UserInputFactory.createDefaultUserInput();
        userInput.setRegionState(NO_SELECTED);
        addressFactory.billingAddressDefault(userInput);
        completeCheckout();
        checkoutAddressValidationAssertion.assertRegionStateValidation();
        logger.info("Test Completed: Region/State Address validation displayed when 'Region/State' is 'Not Selected'");
    }

    @Test // ---> bug ?! <---
    public void postCodeAddressValidationWhenEmpty() throws IOException {
        logger.info("Starting Test: ");
        performCheckoutFlow();
        UserInput userInput = UserInputFactory.createDefaultUserInput();
        userInput.setPostCode(EMPTY_INPUT_FIELD);
        addressFactory.billingAddressDefault(userInput);
        completeCheckout();
        checkoutAddressValidationAssertion.assertPostCodeValidation();
        logger.info("Test Completed: ");
    }

    @Test // ---> bug ?! <---
    public void postCodeAddressValidationWhenLength1Char() throws IOException {
        logger.info("Starting Test: ");
        performCheckoutFlow();
        UserInput userInput = UserInputFactory.createDefaultUserInput();
        userInput.setPostCode(utils.randomAlphaNumeric(1));
        addressFactory.billingAddressDefault(userInput);
        completeCheckout();
        checkoutAddressValidationAssertion.assertPostCodeValidation();
        logger.info("Test Completed: ");
    }

    @Test // ---> bug ?! <---
    public void postCodeAddressValidationWhenLength11Char() throws IOException {
        logger.info("Starting Test: ");
        performCheckoutFlow();
        UserInput userInput = UserInputFactory.createDefaultUserInput();
        userInput.setPostCode(utils.randomAlphaNumeric(11));
        addressFactory.billingAddressDefault(userInput);
        completeCheckout();
        checkoutAddressValidationAssertion.assertPostCodeValidation();
        logger.info("Test Completed: ");
    }

    @Test
    public void privacyPolicyAddressValidationWhenNotAgree() throws IOException {
        logger.info("Starting Test: Privacy Policy Address not checked validation displayed when 'Not Agree'");
        performCheckoutFlow();
        UserInput userInput = UserInputFactory.createDefaultUserInput();
        userInput.setAgreePrivacyTerms(false);
        addressFactory.billingAddressDefault(userInput);
        completeCheckout();
        checkoutAddressValidationAssertion.assertCheckoutPrivacyPolicyValidation();
        logger.info("Test Completed: Privacy Policy Address not checked validation displayed when 'Not Agree'");
    }

    @Test
    public void termsConditionsAddressValidationWhenNotAgree() throws IOException {
        logger.info("Starting Test: Terms & Conditions Address not checked validation displayed when 'Not Agree'");
        performCheckoutFlow();
        UserInput userInput = UserInputFactory.createDefaultUserInput();
        userInput.setAgreePrivacyPolicy(false);
        addressFactory.billingAddressDefault(userInput);
        completeCheckout();
        checkoutAddressValidationAssertion.assertCheckoutTermsConditionsValidation();
        logger.info("Test Completed: Terms & Conditions Address not checked validation displayed when 'Not Agree'");
    }
}
