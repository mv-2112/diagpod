package org.example;

import java.io.FileInputStream;
import java.util.Properties;
import static org.junit.Assert.*;

public class loadProperties {

    public static void loadProperties(String propertiesFile) {
        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String appConfigPath = rootPath + "diagpod.properties";

        Properties appProps = new Properties();
        appProps.load(new FileInputStream(appConfigPath));

        String appVersion = appProps.getProperty("METADATA_IP");
        assertEquals("169.254.169.254", appVersion);

    }
}
