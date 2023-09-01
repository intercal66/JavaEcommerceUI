package factories;

import models.UserInput;
import net.datafaker.Faker;

import java.io.IOException;

import static utilities.JsonUserDataReader.loadJsonUserData;
import static utilities.Utils.driver;

public class UserInputFactory {
    private static final String DEFAULT_PASSWORD = "DefaultPassword";
    private static final String DEFAULT_COUNTRY = "Country";
    private static final String DEFAULT_REGION = "RegionState";

    public static UserInput createDefaultUserInput() throws IOException {
        Faker faker = new Faker();
        UserInput userInput = new UserInput(driver);
        userInput.setFirstName(faker.name().firstName());
        userInput.setLastName(faker.name().lastName());
        userInput.setEmail(faker.internet().emailAddress());
        userInput.setTelephone(faker.phoneNumber().cellPhone());
        userInput.setPassword(loadJsonUserData().getString(DEFAULT_PASSWORD));
        userInput.setPasswordConfirm(loadJsonUserData().getString(DEFAULT_PASSWORD));
        userInput.setCompany(faker.company().name());
        userInput.setAddress1(faker.address().streetAddress());
        userInput.setAddress2(faker.address().secondaryAddress());
        userInput.setCity(faker.address().city());
        userInput.setPostCode(faker.address().zipCode());
        userInput.setAgreePrivacyPolicy(true);
        userInput.setNewsletterSubscribe(false);
        userInput.setAgreePrivacyTerms(true);
        userInput.setCountry(loadJsonUserData().getString(DEFAULT_COUNTRY));
        userInput.setRegionState(loadJsonUserData().getString(DEFAULT_REGION));
        return userInput;
    }
}
