package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class UrlPropertiesReader {
    private static final String URL_CONFIG = "src/main/resources/urlsConfig.properties";

    public static String getUrlProperty(String key) throws IOException {
        Properties properties = new Properties();
        FileInputStream inputStream = new FileInputStream(URL_CONFIG);
        properties.load(inputStream);
        inputStream.close();
        return properties.getProperty(key);
    }
}
