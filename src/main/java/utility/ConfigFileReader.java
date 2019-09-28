package utility;

import java.io.*;
import java.io.FileInputStream;
import java.util.Properties;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConfigFileReader {
    public static Properties properties;
    private final String propertyFilePath= "C:\\git\\PHPTravelsAssignment\\src\\main\\java\\resources\\data.properties";


    public ConfigFileReader(){
        properties = new Properties();
        try {
            InputStreamReader reader = new InputStreamReader(new FileInputStream(propertyFilePath));
                properties.load(reader);
                reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getDriverPath(){
        String driverPath = properties.getProperty("driverPath");
        if(driverPath!= null) return driverPath;
        else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
    }

    public long getImplicitlyWait() {
        String implicitlyWait = properties.getProperty("implicitlyWait");
        if(implicitlyWait != null) return Long.parseLong(implicitlyWait);
        else throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");
    }

    public String getApplicationUrl() {
        String url = properties.getProperty("url");
        if(url != null) return url;
        else throw new RuntimeException("url not specified in the Configuration.properties file.");
    }
}
