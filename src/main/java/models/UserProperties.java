package models;

import java.io.IOException;

import static utilities.JsonUserDataReader.loadJsonUserData;

public class UserProperties {
    private static final String USER_FIRST_NAME = "FirstName";
    private static final String USER_LAST_NAME = "LastName";
    private static final String USER_EMAIL = "Email";
    private static final String USER_PASSWORD = "Password";
    private static final String USER_COMPANY = "Company";
    private static final String USER_ADDRESS_1 = "Address1";
    private static final String USER_ADDRESS_2 = "Address2";
    private static final String USER_CITY = "City";
    private static final String USER_POST_CODE = "PostCode";
    private static final String USER_COUNTRY = "Country";
    private static final String USER_REGION_STATE = "RegionState";

    public static String getUserFirstName() throws IOException {
        return loadJsonUserData().getString(USER_FIRST_NAME);
    }

    public static String getUserLastName() throws IOException {
        return loadJsonUserData().getString(USER_LAST_NAME);
    }

    public static String getUserEmail() throws IOException {
        return loadJsonUserData().getString(USER_EMAIL);
    }

    public static String getUserPassword() throws IOException {
        return loadJsonUserData().getString(USER_PASSWORD);
    }

    public static String getUserCompany() throws IOException {
        return loadJsonUserData().getString(USER_COMPANY);
    }

    public static String getUserAddress1() throws IOException {
        return loadJsonUserData().getString(USER_ADDRESS_1);
    }

    public static String getUserAddress2() throws IOException {
        return loadJsonUserData().getString(USER_ADDRESS_2);
    }

    public static String getUserCity() throws IOException {
        return loadJsonUserData().getString(USER_CITY);
    }

    public static String getUserPostCode() throws IOException {
        return loadJsonUserData().getString(USER_POST_CODE);
    }

    public static String getUserCountry() throws IOException {
        return loadJsonUserData().getString(USER_COUNTRY);
    }

    public static String getUserRegionState() throws IOException {
        return loadJsonUserData().getString(USER_REGION_STATE);
    }
}
