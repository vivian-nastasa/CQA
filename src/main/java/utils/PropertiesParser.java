package utils;

import java.util.Properties;

public class PropertiesParser {

    private final Properties properties;

    public PropertiesParser(String filePath) {
        this.properties = new Properties();
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public void setProperty(String key, String value) {
        properties.setProperty(key, value);
    }
}
