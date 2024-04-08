package org.example;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.util.Properties;

public class loadProperties {

    public static Properties loadProperties(String propertiesFile) {

        // String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        // String appConfigPath = rootPath + "diagpod.properties";


        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream stream = loader.getResourceAsStream("/diagpod.properties");

        Properties appProps = new Properties();
        try {
            // appProps.load(new FileInputStream(appConfigPath));
            appProps.load(stream);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String majorVersion=appProps.getProperty("MAJOR_VERSION");
        String minorVersion=appProps.getProperty("MINOR_VERSION");
        String subRevision=appProps.getProperty("SUB_REVISION");
        String appVersion = String.format("%s.%s.%s", majorVersion, minorVersion, subRevision);

        appProps.setProperty("DIAGPOD_VERSION", appVersion);

        return appProps;

    }
}
