package utilities;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class JsonTelephoneDataReader {
    private static final String TELEPHONE_CONFIG = "src/main/resources/telephoneNumbersTestData.json";

    public static JSONObject loadJsonTelephoneData() throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(TELEPHONE_CONFIG);
        JSONTokener jsonTokener = new JSONTokener(fileInputStream);
        return new JSONObject(jsonTokener);
    }
}
