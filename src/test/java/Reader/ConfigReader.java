package Reader;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    public static String getBaseUrl() {
        return getProperty("config.properties", "base.url");
    }
    public static String getPostUrl() {
        return getProperty("config.properties", "post.url");
    }
    public static String getPutUrl() {
        return getProperty("config.properties", "put.url");
    }
    public static String getDeleteUrl() {
        return getProperty("config.properties", "delete.url");
    }
    public static String getUrl() {
        return getProperty("config.properties", "get.url");
    }


    public static int getValidStatusCode() {
        return Integer.parseInt(getProperty("testdata.properties", "valid.status.code"));
    }

    private static String getProperty(String fileName, String key) {
        Properties properties = new Properties();
        try (InputStream inputStream = ConfigReader.class.getClassLoader().getResourceAsStream(fileName)) {
            properties.load(inputStream);
            return properties.getProperty(key);
        } catch (IOException e) {
            throw new RuntimeException("Error loading properties file: " + fileName, e);
        }
    }
}
