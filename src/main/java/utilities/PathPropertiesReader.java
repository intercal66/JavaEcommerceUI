package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PathPropertiesReader {
    private static final String PATH_CONFIG = "src/main/resources/pathConfig.properties";

    public static String getPathProperty(String key) throws IOException {
        Properties properties = new Properties();
        FileInputStream inputStream = new FileInputStream(PATH_CONFIG);
        properties.load(inputStream);
        inputStream.close();
        return properties.getProperty(key);
    }
}
