package pl.imgw.util;

import pl.imgw.model.ConfigProperties;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class PropertiesUtil {

    private PropertiesUtil(){}

    public static ConfigProperties getProperties() throws IOException {
        Properties prop = new Properties();
        final String propFileName = "./config/config.properties";
        URL inputStream = PropertiesUtil.class.getClassLoader().getResource(propFileName);
        assert inputStream != null;
        prop.load(inputStream.openStream());
        prop.load(inputStream.openStream());
        return new ConfigProperties(prop.getProperty("station_name"), prop.getProperty("directory"));
    }
}
