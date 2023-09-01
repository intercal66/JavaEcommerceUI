package utilities;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.IOException;

public class JsonUserDataReader {
    private static final String USER_CONFIG = "src/main/resources/userData.json";

    public static JSONObject loadJsonUserData() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(USER_CONFIG);
        JSONTokener jsonTokener = new JSONTokener(fileInputStream);
        return new JSONObject(jsonTokener);
    }
}
