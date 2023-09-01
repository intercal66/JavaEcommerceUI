package base;

import assertions.*;
import factories.*;
import methods.AddProduct;
import methods.SearchProduct;
import methods.SelectCountryState;
import methods.SelectProduct;
import models.UserInput;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pagesPOM.AccountPage;
import pagesPOM.*;
import pagesPOM.PaymentAddressFormLabels;
import pagesPOM.RegistrationFormLabels;
import pagesPOM.UserFormInputs;
import utilities.Utils;

import java.io.IOException;

import static utilities.PathPropertiesReader.getPathProperty;
import static utilities.UrlPropertiesReader.getUrlProperty;

public class AutoTemplate {
    private static final Logger logger = LogManager.getLogger(AutoTemplate.class);
    protected final String BASE_URL = "EcommerceUrl";
    protected final String CHROME_PATH = "ChromePath116";
    protected final String FIREFOX_PATH = "FirefoxPath033";

    protected WebDriver driver;
    protected AccountPage accountPage;
    protected RightColumnButtons rightColumnButtons;
    protected AddProduct addProduct;
    protected AddressFactory addressFactory;
    protected CartProductPage cartProductPage;
    protected CheckoutAddressLabelAssertion checkoutAddressLabelAssertion;
    protected CheckoutAddressValidationAssertion checkoutAddressValidationAssertion;
    protected CheckoutFormPage checkoutFormPage;
    protected CheckoutLoginForm checkoutLoginForm;
    protected CheckoutOrderAssertion checkoutOrderAssertion;
    protected ConfirmOrderPage confirmOrderPage;
    protected ContentFormLinks contentFormLinks;
    protected ErrorMessageHandler errorMessageHandler;
    protected GuestFactory guestFactory;
    protected LoginFactory loginFactory;
    protected LoginLabelAssertion loginLabelAssertion;
    protected LoginSuccessfullyAssertion loginSuccessfullyAssertion;
    protected LoginValidationAssertion loginValidationAssertion;
    protected MainHomePage mainHomePage;
    protected MainProductPage mainProductPage;
    protected MainSearchBar mainSearchBar;
    protected PaymentAddressFormLabels paymentAddressFormLabels;
    protected RegistrationFormLabels registrationFormLabels;
    protected RegisterFactory registerFactory;
    protected RegistrationLabelAssertion registrationLabelAssertion;
    protected RegistrationSuccessfullyAssertion registrationSuccessfullyAssertion;
    protected RegistrationValidationAssertion registrationValidationAssertion;
    protected SearchProduct searchProduct;
    protected SelectCountryState selectCountryState;
    protected SelectProduct selectProduct;

    protected ShippingAddressForm shippingAddressForm;
    protected UserFormInputs userFormInputs;
    protected UserInput userInput;
    protected UserInputPlaceholderAssertion userInputPlaceholderAssertion;
    protected UserInputFactory userInputFactory;
    protected Utils utils;

    @BeforeTest
    public void setUpDriver() throws IOException {
        System.setProperty("web-driver.chrome.driver", getPathProperty(CHROME_PATH));
        driver = new ChromeDriver();
        accountPage = new AccountPage(driver);
        rightColumnButtons = new RightColumnButtons(driver);
        addProduct = new AddProduct(driver);
        addressFactory = new AddressFactory(driver);
        cartProductPage = new CartProductPage(driver);
        checkoutAddressLabelAssertion = new CheckoutAddressLabelAssertion(driver);
        checkoutAddressValidationAssertion = new CheckoutAddressValidationAssertion(driver);
        checkoutFormPage = new CheckoutFormPage(driver);
        checkoutLoginForm = new CheckoutLoginForm(driver);
        checkoutOrderAssertion = new CheckoutOrderAssertion(driver);
        confirmOrderPage = new ConfirmOrderPage(driver);
        contentFormLinks = new ContentFormLinks(driver);
        errorMessageHandler = new ErrorMessageHandler(driver);
        guestFactory = new GuestFactory(driver);
        loginFactory = new LoginFactory(driver);
        loginLabelAssertion = new LoginLabelAssertion(driver);
        loginSuccessfullyAssertion = new LoginSuccessfullyAssertion(driver);
        loginValidationAssertion = new LoginValidationAssertion(driver);
        mainHomePage = new MainHomePage(driver);
        mainProductPage = new MainProductPage(driver);
        mainSearchBar = new MainSearchBar(driver);
        paymentAddressFormLabels = new PaymentAddressFormLabels(driver);
        registrationFormLabels = new RegistrationFormLabels(driver);
        registerFactory = new RegisterFactory(driver);
        registrationLabelAssertion = new RegistrationLabelAssertion(driver);
        registrationSuccessfullyAssertion = new RegistrationSuccessfullyAssertion(driver);
        registrationValidationAssertion = new RegistrationValidationAssertion(driver);
        searchProduct = new SearchProduct(driver);
        selectCountryState = new SelectCountryState(driver);
        selectProduct = new SelectProduct(driver);
        shippingAddressForm = new ShippingAddressForm(driver);
        userFormInputs = new UserFormInputs(driver);
        userInput = new UserInput(driver);
        userInputFactory = new UserInputFactory();
        userInputPlaceholderAssertion = new UserInputPlaceholderAssertion(driver);
        utils = new Utils(driver);
    }

    @BeforeMethod
    public void loadStartPage() throws IOException {
        driver.manage().window().maximize();
        String baseUrl = getUrlProperty(BASE_URL);
        driver.get(baseUrl);
        logger.info("Starting Page URL: {}", baseUrl);
        logger.info("Current Page URL: {}", driver.getCurrentUrl());
    }

    /*@AfterTest
    public void tearDownDriver() {
        if (driver != null) {
            driver.quit();
            logger.info("WebDriver closed successfully.");
        }
    }*/
}
